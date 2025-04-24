    public static async Task<Results<Ok, BadRequest<string>, ProblemHttpResult>> CancelOrderAsync(
        [FromHeader(Name = "x-requestid")] Guid requestId,
        CancelOrderCommand command,
        [AsParameters] OrderServices services)
    {
        return await ShipOrCancelOrderAsync(
            requestId,
            command,
            services,
            "Cancel order failed to process.");
    }

    public static async Task<Results<Ok, BadRequest<string>, ProblemHttpResult>> ShipOrderAsync(
        [FromHeader(Name = "x-requestid")] Guid requestId,
        ShipOrderCommand command,
        [AsParameters] OrderServices services)
    {
        return await ShipOrCancelOrderAsync(
            requestId,
            command,
            services,
            "Ship order failed to process.");
    }

    private static async Task<Results<Ok, BadRequest<string>, ProblemHttpResult>> ShipOrCancelOrderAsync<TCommand>(
        Guid requestId,
        TCommand command, 
        OrderServices services,
        string failureMessage)
        where TCommand : IRequest<bool>
    {
        if (requestId == Guid.Empty)
        {
            return TypedResults.BadRequest("Empty GUID is not valid for request ID");
        }

        var identifiedCommand = new IdentifiedCommand<TCommand, bool>(command, requestId);

        // Use reflection to get the OrderNumber property from the command
        var orderNumberProperty = command.GetType().GetProperty("OrderNumber");
        var orderNumber = orderNumberProperty?.GetValue(command);

        services.Logger.LogInformation(
            "Sending command: {CommandName} - {IdProperty}: {CommandId} ({@Command})",
            identifiedCommand.GetGenericTypeName(),
            "OrderNumber",
            orderNumber,
            identifiedCommand);

        var commandResult = await services.Mediator.Send(identifiedCommand);

        if (!commandResult)
        {
            return TypedResults.Problem(detail: failureMessage, statusCode: 500);
        }

        return TypedResults.Ok();
    }
