        private async ValueTask<List<int>> GetConfirmedGracePeriodOrders()
        {
            try
            {
                await using var conn = dataSource.CreateConnection();
                await using var command = conn.CreateCommand();
                command.CommandText = """
                    SELECT "Id"
                    FROM ordering.orders
                    WHERE CURRENT_TIMESTAMP - "OrderDate" >= @GracePeriodTime AND "OrderStatus" = 'Submitted'
                    """;
                command.Parameters.AddWithValue("GracePeriodTime", TimeSpan.FromMinutes(_options.GracePeriodTime));

                List<int> ids = [];

                await conn.OpenAsync();
                await using var reader = await command.ExecuteReaderAsync();
                while (await reader.ReadAsync())
                {
                    ids.Add(reader.GetInt32(0));
                }

                return ids;
            }
            catch (NpgsqlException exception)
            {
                logger.LogError(exception, "Fatal error establishing database connection");
            }

            return [];
        }
