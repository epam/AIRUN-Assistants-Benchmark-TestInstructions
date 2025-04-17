        private async Task CheckConfirmedGracePeriodOrders()
        {
            if (logger.IsEnabled(LogLevel.Debug))
            {
                logger.LogDebug("Checking confirmed grace period orders");
            }

            try 
            {
                await foreach (var orderId in StreamConfirmedGracePeriodOrders())
                {
                    var confirmGracePeriodEvent = new GracePeriodConfirmedIntegrationEvent(orderId);

                    logger.LogInformation("Publishing integration event: {IntegrationEventId} - ({@IntegrationEvent})", confirmGracePeriodEvent.Id, confirmGracePeriodEvent);

                    await eventBus.PublishAsync(confirmGracePeriodEvent);
                }
            }
            catch (Exception ex)
            {
                logger.LogError(ex, "Error loading confirmed grace period orders");
            }
        }
