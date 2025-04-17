        private async IAsyncEnumerable<int> StreamConfirmedGracePeriodOrders()
        {
            await using var conn = dataSource.CreateConnection();
            await using var command = conn.CreateCommand();
            command.CommandText = """
                SELECT "Id"
                FROM ordering.orders
                WHERE CURRENT_TIMESTAMP - "OrderDate" >= @GracePeriodTime AND "OrderStatus" = 'Submitted'
                """;
            command.Parameters.AddWithValue("GracePeriodTime", TimeSpan.FromMinutes(_options.GracePeriodTime));

            await conn.OpenAsync();
            await using var reader = await command.ExecuteReaderAsync();
            while (await reader.ReadAsync())
            {
                yield return reader.GetInt32(0);
            }
        }
