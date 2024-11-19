**0003. Refactor Golf application access-control layer, replace Basic Authentication with Oauth2 Authorization**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - src/main/resources/application.properties
    - pom.xml
    - src/main/java/com/golf/app/security/AppSecurityConfig.java
    - src/main/java/com/golf/app/controller/AdminController.java
    - src/main/java/com/golf/app/controller/CompetitionController.java
    - src/main/java/com/golf/app/controller/CompetitionExceptionHandlerController.java
    - src/main/java/com/golf/app/controller/CourseController.java
    - src/main/java/com/golf/app/controller/ExceptionHandlerController.java
    - src/main/java/com/golf/app/controller/MainController.java
    - src/main/java/com/golf/app/controller/PlayerController.java
    - src/main/java/com/golf/app/controller/PlayerPhotoController.java
    - src/main/java/com/golf/app/controller/RoundController.java
    - src/main/java/com/golf/app/controller/RoundScoreController.java
    - src/main/java/com/golf/app/controller/ScoreCardController.java
    - src/main/java/com/golf/app/controller/ScoreCardImageController.java
    - src/main/java/com/golf/app/controller/UserController.java
    - src/test/java/com/golf/app/security/AppSecurityConfigTest.java
- Enter task description:

> Refactor Golf application access-control layer, replace Basic Authentication with OAuth2 authorization.
/admin endpoint should be accessed only by a client granted with GOLF:ADMIN scope.
A client granted with GOLF:COACH scope should access all endpoints except /admin endpoint.
A client granted with GOLF:USER scope should access all read only endpoints except /admin endpoint.

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assert conditions*

- assert soauth2-resource-server dependency is added to pom.xml

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
        </dependency>
```

- assert that jwk-set-uri parameters is added to application.properties. For instance:

```properties
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://${OAUTH2_HOST:localhost}:50080
```

- assert that AppSecurityConfig is updated:
    - InMemoryUserDetailsManager bean is removed
    - access to requests is restricted and Oauth2 Resource Server is configured in filterChain method. Sample:

```java
    @Bean
    SecurityFilterChain filterChain( HttpSecurity http ) throws Exception
    {
        http.authorizeHttpRequests( ( authorize ) -> authorize
                        .requestMatchers( "/admin/**" )
                        .access( AuthorityAuthorizationManager.hasAuthority( "SCOPE_GOLF:ADMIN" ) )
                        .requestMatchers( ( request ) -> Stream
                                .of( HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE )
                                .filter( ( method ) -> method.matches( request.getMethod() ) ).findFirst().isPresent() )
                        .access( AuthorityAuthorizationManager.hasAuthority( "SCOPE_GOLF:COACH" ) )
                        .requestMatchers( HttpMethod.GET )
                        .access( AuthorityAuthorizationManager.hasAnyAuthority( "SCOPE_GOLF:COACH",
                                "SCOPE_GOLF:USER" ) )
                        .anyRequest()
                        .authenticated() )
                .oauth2ResourceServer( ( oauth2 ) -> oauth2.jwt( withDefaults() ) );
        return http.build();
    }
```

- assert that AppSecurityConfigTest is updated to check access with scopes instead of roles.
- download WireMock JWT Standalone extension with the command:

```bash
(cd extensions && curl -O https://repo1.maven.org/maven2/org/wiremock/extensions/wiremock-jwt-extension-standalone/0.1.0/wiremock-jwt-extension-standalone-0.1.0.jar)
```

- start Mysql container and OAuth2 authorization server container with the command:

```bash
docker-compose up
```
- set env variables to specify Mysql and Oauth2 authorization hosts:

```bash
export MYSQL_HOST=host1
export OAUTH2_HOST=host1
```

- start the application with the following command with actual DB url and password:

```bash
mvn spring-boot:run
```
- assert /admin request is accessible with GOLF:ADMIN scope by running the commands:

```bash
ACCESSTOKEN=`curl -s --request POST --url  http://${OAUTH2_HOST}:50080/oauth2/token -u u1:p1 --header 'accept: application/json' --header 'content-type: application/x-www-form-urlencoded' --data "grant_type=client_credentials&scope=GOLF:ADMIN" | jq -r .access_token`

curl -v --header "Authorization: Bearer $ACCESSTOKEN" http://localhost:8082/admin
```

- verify the response:
    - HTTP status code: 200
    - Content-Type: text/plain;charset=UTF-8
    - Body: admin
- assert /admin request is not accessible with scope other than GOLF:ADMIN by running the commands:

```bash
ACCESSTOKEN=`curl -s --request POST --url  http://${OAUTH2_HOST}:50080/oauth2/token -u u1:p1 --header 'accept: application/json' --header 'content-type: application/x-www-form-urlencoded' --data "grant_type=client_credentials&scope=GOLF:WHATEVER" | jq -r .access_token`

curl -v --header "Authorization: Bearer $ACCESSTOKEN" http://localhost:8082/admin
```

- verify the response:
    - HTTP status code: 403
    - WWW-Authenticate: Bearer error="insufficient_scope", error_description="The request requires higher privileges than provided by the access token.", error_uri="https://tools.ietf.org/html/rfc6750#section-3.1"
-assert /player/add GET request is accessible with GOLF:USER scope by running the commands:

```bash
ACCESSTOKEN=`curl -s --request POST --url  http://${OAUTH2_HOST}:50080/oauth2/token -u u1:p1 --header 'accept: application/json' --header 'content-type: application/x-www-form-urlencoded' --data "grant_type=client_credentials&scope=GOLF:USER" | jq -r .access_token`

curl -v --header "Authorization: Bearer $ACCESSTOKEN" http://localhost:8082/player/add
```

- verify the response:
    - HTTP status code: 200
    - Content-Type: text/html;charset=UTF-8
    - Body contains src/main/resources/templates/player/player-add.html
-assert /player/add POST request is accessible with GOLF:COACH scope by running the commands:

```bash
ACCESSTOKEN=`curl -s --request POST --url  http://${OAUTH2_HOST}:50080/oauth2/token -u u1:p1 --header 'accept: application/json' --header 'content-type: application/x-www-form-urlencoded' --data "grant_type=client_credentials&scope=GOLF:COACH" | jq -r .access_token`

curl -v --header "Authorization: Bearer $ACCESSTOKEN" --header "Content-Type: application/x-www-form-urlencoded" --request POST --data 'name=Naomi&surname=OsaAF' http://localhost:8082/player/add
```

- verify the response:
    - HTTP status code: 302
