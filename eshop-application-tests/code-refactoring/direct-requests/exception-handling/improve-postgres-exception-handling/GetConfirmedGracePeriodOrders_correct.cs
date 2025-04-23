        private async ValueTask<List<int>> GetConfirmedGracePeriodOrders()
        {
            try
            {
                using var conn = dataSource.CreateConnection();
                using var command = conn.CreateCommand();
                command.CommandText = """
                    SELECT "Id"
                    FROM ordering.orders
                    WHERE CURRENT_TIMESTAMP - "OrderDate" >= @GracePeriodTime AND "OrderStatus" = 'Submitted'
                    """;
                command.Parameters.AddWithValue("GracePeriodTime", TimeSpan.FromMinutes(_options.GracePeriodTime));

                List<int> ids = [];

                await conn.OpenAsync();
                using var reader = await command.ExecuteReaderAsync();
                while (await reader.ReadAsync())
                {
                    ids.Add(reader.GetInt32(0));
                }

                return ids;
            }
            catch (PostgresException postgresEx)
            {
                var message = $"SQL error loading confirmed grace period orders: {postgresEx.Message}";
                if (!string.IsNullOrEmpty(postgresEx.Detail))
                {
                    message += $" Detail: {postgresEx.Detail}";
                }
                if (postgresEx.InnerException != null)
                {
                    message += $" Root cause: {postgresEx.InnerException.Message}";
                }
                logger.LogError(postgresEx, message);
            }
            catch (NpgsqlException npgsqlEx)
            {
                var message = $"General error loading confirmed grace period orders: {npgsqlEx.Message}";
                if (npgsqlEx.InnerException != null)
                {
                    message += $" Root cause: {npgsqlEx.InnerException.Message}";
                }
                logger.LogError(npgsqlEx, message);
            }

            return [];
        }
