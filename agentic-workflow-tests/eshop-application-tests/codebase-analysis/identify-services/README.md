# Idenfity all services started by the application

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

- Ensure that no file is open
- Open the agent interface and enter:

```text
Identify all application and infrastructure services started by the solution, such as API or background services, which expose an HTTP or TCP endpoint. Shortly describe each service. Group services into logical groups.
```

- Submit the request

## Assert

- Open the solution in Visual Studio. Ensure that **eShop.AppHost** is the startup project. Run the solution.
- Observe the list of services shown in the webpage that opens.
- Ensure that:
  - All services shown in the webpage are mentioned by the agent
  - The agent does not mention any services not shown in the webpage (e.g., **OpenAI**)
  - The agent uses exactly those service names that appear in the first column of the webpage (e.g., **eventbus** instead of **RabbitMQ**)
  - The services are logically grouped, e.g., into
    - API services
    - Background processing services
    - Backend-for-frontend services
    - Frontend services
    - Infrastructure services
