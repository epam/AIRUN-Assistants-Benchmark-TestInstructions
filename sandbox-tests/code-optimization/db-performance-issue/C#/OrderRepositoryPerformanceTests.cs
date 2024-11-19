using Context;
using Context.Models;
using Microsoft.EntityFrameworkCore;
using src;
using System.Diagnostics;

namespace Test
{
    public class OrderRepositoryPerformanceTests
    {
        private OrderContext _context;

        [SetUp]
        public void Setup()
        {
            var options = new DbContextOptionsBuilder<OrderContext>()
                .UseInMemoryDatabase(databaseName: "Performance Database")
                .Options;

            _context = new OrderContext(options);

            for (int i = 0; i < 1000000; i++)
            {
                _context.Orders.Add(new Order
                {
                    Id = Guid.NewGuid(),
                    Name = $"Order {i + 1}",
                    Description = $"Test Order {i + 1}",
                    TotalPrice = 100,
                    IsComplete = false
                });
            }

            _context.SaveChanges();
        }

        [Test]
        public void CompareQueryPerformance()
        {
            var service = new OrdersRepository(_context);
            var stopwatch = new Stopwatch();

            stopwatch.Start();
            var resultOptimized = service.GetAllNonCompletedOrdersOptimized();
            stopwatch.Stop();
            var optimizedTime = stopwatch.ElapsedMilliseconds;
            TestContext.WriteLine($"Execution time for optimized query: {optimizedTime} ms");

            stopwatch.Reset();

            stopwatch.Start();
            var resultNonOptimized = service.GetAllNonCompletedOrdersNonOptimized();
            stopwatch.Stop();
            var nonOptimizedTime = stopwatch.ElapsedMilliseconds;
            TestContext.WriteLine($"Execution time for non-optimized query: {nonOptimizedTime} ms");

            Assert.IsNotNull(resultOptimized);
            Assert.IsNotNull(resultNonOptimized);
            Assert.Less(optimizedTime, nonOptimizedTime, "The optimized query should be faster than the non-optimized query.");
        }
    }
}