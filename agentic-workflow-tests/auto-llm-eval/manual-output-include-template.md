# *mvn clean install* command output:

```
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< com.golf:codebase-golf-application >-----------------
[INFO] Building Golf App 0.0.1-SNAPSHOT
[INFO]   from pom.xml
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  18.186 s
[INFO] Finished at: 2024-09-19T14:57:46+03:00
[INFO] ------------------------------------------------------------------------
```

# logs/golf-app.log content:

```
2024-09-20 11:38:58.130 [background-preinit] INFO  org.hibernate.validator.internal.util.Version -  HV000001: Hibernate Validator 8.0.1.Final
...
2024-09-20 11:39:09.561 [restartedMain] INFO  org.springframework.boot.web.embedded.tomcat.TomcatWebServer -  Tomcat started on port 8082 (http) with context path ''
2024-09-20 11:39:09.575 [restartedMain] INFO  com.golf.app.GolfWebApplication -  Started GolfWebApplication in 12.298 seconds (process running for 14.223)
```
