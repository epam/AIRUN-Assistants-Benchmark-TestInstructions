using Microsoft.Extensions.Options;
using Moq;
using Npgsql;
using System.Reflection;
using eShop.OrderProcessor.Services;
using eShop.OrderProcessor;
using eShop.EventBus.Abstractions;
using Testcontainers.PostgreSql;
using Docker.DotNet;
using Docker.DotNet.Models;

namespace Ordering.UnitTests
{
    [TestClass]
    [DoNotParallelize]
    [TestCategory("GracePeriodManagerServiceTests")]
    public class GracePeriodManagerServiceTests
    {
        private class MemoryLogger<T> : ILogger<T>
        {
            public List<string> LoggedMessages = [];

            public IDisposable BeginScope<TState>(TState state) where TState : notnull
            {
                throw new NotImplementedException();
            }

            public bool IsEnabled(LogLevel logLevel)
            {
                return logLevel == LogLevel.Error;
            }

            public void Log<TState>(LogLevel logLevel, EventId eventId, TState state, Exception exception, Func<TState, Exception, string> formatter)
            {
                LoggedMessages.Add(formatter(state, exception));
            }
        }

        private static PostgreSqlContainer postgresContainer;

        private Mock<IOptions<BackgroundTaskOptions>> optionsMock;

        private Mock<IEventBus> eventBusMock = new();

        [ClassInitialize]
        public static async Task ClassInitializeAsync(TestContext context)
        {
            postgresContainer = new PostgreSqlBuilder()
                .WithDatabase("testdb")
                .WithUsername("testuser")
                .WithPassword("testpassword")
                .Build();
            await postgresContainer.StartAsync();
        }

        [ClassCleanup(ClassCleanupBehavior.EndOfClass)]
        public static async Task ClassCleanupAsync()
        {
            if (postgresContainer != null)
            {
                try
                {
                    await postgresContainer.StopAsync();
                }
                finally
                {
                    await postgresContainer.DisposeAsync();
                }
            }

            // sometimes, testcontainers/ruyk containers are not stopped automatically => forcing them to stop
            using var dockerClient = new DockerClientConfiguration().CreateClient();
            var containers = await dockerClient.Containers.ListContainersAsync(new ContainersListParameters() { All = true });
            foreach (var container in containers)
            {
                if (container.Image.StartsWith("testcontainers/ryuk"))
                {
                    await dockerClient.Containers.StopContainerAsync(container.ID, new ContainerStopParameters());
                }
            }
        }

        public GracePeriodManagerServiceTests()
        {
            // mocking options
            optionsMock = new();
            optionsMock.Setup(o => o.Value)
                .Returns(new BackgroundTaskOptions { GracePeriodTime = 10, CheckUpdateTime = 5 });
        }

        [TestMethod]
        public async Task GetConfirmedGracePeriodOrders_PostgresException_NoDetail_NoInnerException()
        {
            // Arranging
            var logger = new MemoryLogger<GracePeriodManagerService>();
            var postgresConnectionString = postgresContainer.GetConnectionString();
            var dataSourceBuilder = new NpgsqlDataSourceBuilder(postgresConnectionString);
            // note: the database does not contain any tables
            var dataSource = dataSourceBuilder.Build();
            var service = new GracePeriodManagerService(optionsMock.Object, eventBusMock.Object, logger, dataSource);

            // Acting
            var method = typeof(GracePeriodManagerService)
                .GetMethod("GetConfirmedGracePeriodOrders", BindingFlags.NonPublic | BindingFlags.Instance);
            var result = await(ValueTask<List<int>>)method.Invoke(service, null);

            // Asserting
            Assert.AreEqual(0, result.Count);
            Assert.AreEqual(1, logger.LoggedMessages.Count);
            Assert.Contains("SQL error loading confirmed grace period orders: ", logger.LoggedMessages[0]);
            Assert.Contains(PostgresErrorCodes.UndefinedTable, logger.LoggedMessages[0]);
            Assert.IsFalse(logger.LoggedMessages[0].Contains("Detail:"));
            Assert.IsFalse(logger.LoggedMessages[0].Contains("Root cause:"));
        }

        [TestMethod]
        public async Task GetConfirmedGracePeriodOrders_NpgsqlException_WithInnerException()
        {
            // Arranging
            var logger = new MemoryLogger<GracePeriodManagerService>();
            var postgresConnectionString = postgresContainer.GetConnectionString();
            var dataSourceBuilder = new NpgsqlDataSourceBuilder(postgresConnectionString);
            // note: the database does not contain any tables
            var dataSource = dataSourceBuilder.Build();
            var service = new GracePeriodManagerService(optionsMock.Object, eventBusMock.Object, logger, dataSource);
            // shutting down the container
            await postgresContainer.StopAsync();

            // Acting
            var method = typeof(GracePeriodManagerService)
                .GetMethod("GetConfirmedGracePeriodOrders", BindingFlags.NonPublic | BindingFlags.Instance);
            var result = await(ValueTask<List<int>>)method.Invoke(service, null);

            // Asserting
            Assert.AreEqual(0, result.Count);
            Assert.AreEqual(1, logger.LoggedMessages.Count);
            Assert.Contains("General error loading confirmed grace period orders: ", logger.LoggedMessages[0]);
            Assert.Contains("Root cause:", logger.LoggedMessages[0]);

            // Cleanup
            await postgresContainer.StartAsync();
        }
    }
}
