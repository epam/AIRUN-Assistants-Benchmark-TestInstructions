using HttpAuthLib;

namespace Test
{
    public class Tests
    {
        [Test]
        public void CreateBasicAuthenticationHeader_StringReturned_String()
        {
            string username = "username";
            string password = "password";
            string expected = "Basic dXNlcm5hbWU6cGFzc3dvcmQ=";

            HttpAuth httpAuth = new HttpAuth();
            string actual = httpAuth.CreateBasicAuthenticationHeader(username, password);

            Assert.AreEqual(expected, actual);
        }

        [Test]
        public void CreateBadicAuthenticationHeader_ContainsBasic_String()
        {
            string username = "username";
            string password = "password";
            string expected = "Basic";

            HttpAuth httpAuth = new HttpAuth();
            string actual = httpAuth.CreateBasicAuthenticationHeader(username, password);

            StringAssert.Contains(expected, actual);
        }

        [Test]
        public void CreateBasicAuthenticationHeader_ContainsUsername_String()
        {
            string username = "username";
            string password = "password";

            HttpAuth httpAuth = new HttpAuth();
            string actual = httpAuth.CreateBasicAuthenticationHeader(username, password);
            string decoded = System.Text.Encoding.UTF8.GetString(System.Convert.FromBase64String(actual.Replace("Basic ", string.Empty)));

            StringAssert.Contains(username, decoded);
        }

        [Test]
        public void CreateBasicAuthenticationHeader_ContainsPassword_String()
        {
            string username = "username";
            string password = "password";

            HttpAuth httpAuth = new HttpAuth();
            string actual = httpAuth.CreateBasicAuthenticationHeader(username, password);
            string decoded = System.Text.Encoding.UTF8.GetString(System.Convert.FromBase64String(actual.Replace("Basic ", string.Empty)));

            StringAssert.Contains(password, decoded);
        }
    }
}