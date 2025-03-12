# *mvn clean install* output:

```
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< com.golf:golf-application >----------------------
[INFO] Building Golf App 0.0.1-SNAPSHOT
[INFO]   from pom.xml
...
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ golf-application ---
[INFO]
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ golf-application ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 4 source files with javac [debug parameters release 17] to target\test-classes
[INFO]
[INFO] --- surefire:3.1.2:test (default-test) @ golf-application ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0
[INFO]
...
[INFO]
[INFO] --- install:3.1.1:install (default-install) @ golf-application ---
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.687 s
[INFO] Finished at: 2025-03-12T17:14:59+03:00
[INFO] ------------------------------------------------------------------------
```

# *mvn spring-boot:run* output:

```
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< com.golf:golf-application >----------------------
[INFO] Building Golf App 0.0.1-SNAPSHOT
[INFO]   from pom.xml
...
[INFO]
[INFO] --- spring-boot:3.2.1:run (default-cli) @ golf-application ---
...
2025-03-12T17:29:40.242 [restartedMain] INFO  o.a.coyote.http11.Http11NioProtocol -  Starting ProtocolHandler ["http-nio-8082"]
2025-03-12T17:29:40.262 [restartedMain] INFO  o.s.b.w.e.tomcat.TomcatWebServer -  Tomcat started on port 8082 (http) with context path ''
2025-03-12T17:29:40.276 [restartedMain] INFO  com.golf.app.GolfWebApplication -  Started GolfWebApplication in 5.099 seconds (process running for 5.433)
```

# logs/golf-app.log content:

```
2025-03-12T17:29:40.223 [restartedMain] INFO  o.s.b.d.a.OptionalLiveReloadServer -  LiveReload server is running on port 35729
2025-03-12T17:29:40.242 [restartedMain] INFO  o.a.coyote.http11.Http11NioProtocol -  Starting ProtocolHandler ["http-nio-8082"]
2025-03-12T17:29:40.262 [restartedMain] INFO  o.s.b.w.e.tomcat.TomcatWebServer -  Tomcat started on port 8082 (http) with context path ''
2025-03-12T17:29:40.276 [restartedMain] INFO  com.golf.app.GolfWebApplication -  Started GolfWebApplication in 5.099 seconds (process running for 5.433)
2025-03-12T17:30:43.098 [http-nio-8082-exec-2] INFO  o.a.c.c.C.[Tomcat].[localhost].[/] -  Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-03-12T17:30:43.099 [http-nio-8082-exec-2] INFO  o.s.web.servlet.DispatcherServlet -  Initializing Servlet 'dispatcherServlet'
2025-03-12T17:30:43.100 [http-nio-8082-exec-2] INFO  o.s.web.servlet.DispatcherServlet -  Completed initialization in 1 ms
```
