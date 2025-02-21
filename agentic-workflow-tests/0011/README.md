**0011. Migrate in-memory user and role definitions to database in Golf application**

*Act*

- Open the Golf application project from the repository https://github.com/PolinaTolkachova/golf-application
- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - src/main/java/com/golf/app/security/AppSecurityConfig.java
    - src/main/resources/application.properties
- Enter task description:

```
Migrate in-memory user and roles definitions to database.

Configure Spring Security to retrieve user information from the database.

Consider that default Spring Security schema should be used to store users and roles.
Ignore current user registration related model and functionality.

Create a SQL script to import existing in-memory users and roles to database.
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assertion*

<details>
<summary>Manual Assertion:</summary>

- Make sure, the following changes suggested in src/main/java/com/golf/app/security/AppSecurityConfig.java:
    - the method declaring InMemoryUserDetailsManager bean has been removed
    - added a method declaring UserDetailsService bean and creating JdbcUserDetailsManager as the bean implementation:

```java
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        return users;
    }
```

- Make sure that a SQL script(s) to import existing in-memory users and roles to database is created.
    - The script has statements to create tables USERS and AUTHORITIES. An unique index is created for AUTHORITIES table for username, authority:

```sql
CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);
```

    - The script has a statement inserting existing users into USERS table:

```sql
INSERT INTO users (username, password, enabled) VALUES
('user', '$2a$10$eWpP7/tdQM1gShtMC2dEtOReHUgRC6ImkoaKygE0JSRKDoDvOWLRW', true),
('1', '$2a$10$Uh7aJbjjCIZjfgfRYD2lxuWNAsFXZIfFDBnL/75yUh959WmtHK.VO', true),
('coach', '$2a$10$QAlLQjUrC9D/XlDkveCGm.oU53ufhXYqO7blYkL5OVL2LJRYooewq', true),
('a', '$2a$10$jn5UYee96Ay8OWss1QAAHO61hDakVLaUFmQ/fFiUmttQXMfLVfVUq', true);
```

    - The script has a statement inserting user roles into AUTHORITIES table:

```sql
INSERT INTO authorities (username, authority) VALUES
('user', 'ROLE_USER'),
('1', 'ROLE_USER'),
('coach', 'ROLE_COACH'),
('a', 'ROLE_ADMIN');
```

</details>

<details>
<summary>Automated LLM Assertion:</summary>

Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md).

</details>

*Additional note*

See a sample of correct solution in the [0001-Migrate-in-memory-user-and-roles-definitions-to-data path](exemplar/0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch).
