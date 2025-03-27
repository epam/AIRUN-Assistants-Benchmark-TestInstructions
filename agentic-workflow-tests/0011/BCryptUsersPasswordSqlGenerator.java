import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUsersPasswordSqlGenerator {

    public static void main(String[] args) {
        String scriptTemplate = """
INSERT INTO users (username, password, enabled) VALUES
('user', '%s', true),
('1', '%s', true),
('coach', '%s', true),
('a', '%s', true);
""";
        BCryptPasswordEncoder e = new BCryptPasswordEncoder();
        System.out.print(String.format(scriptTemplate, e.encode("userPass"), e.encode("1"), e.encode("coachPass"),
                e.encode("a")));
    }

}
