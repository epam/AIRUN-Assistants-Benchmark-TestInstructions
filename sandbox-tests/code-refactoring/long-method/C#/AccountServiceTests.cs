using NUnit.Framework;

namespace Tests
{
    [TestFixture()]
    public class AccountServiceTests
    {
        [Test()]
        public void HandeResponseTest()
        {
            AccountService accountService = new AccountService();
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.Id = 1;
            accountResponse.Name = "John";
            accountResponse.Email = "";
            accountResponse.Phone = "1234567890";
            Account account = accountService.HandleResponse(accountResponse);
            Assert.AreEqual(account.Id, accountResponse.Id);
            Assert.AreEqual(account.Name, accountResponse.Name);
            Assert.AreEqual(account.Email, accountResponse.Email);
            Assert.AreEqual(account.Phone, accountResponse.Phone);

        }

        [Test()]
        public void HandeResponseTestNullEmail()
        {
            AccountService accountService = new AccountService();
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.Id = 1;
            accountResponse.Name = "John";
            accountResponse.Email = null;
            accountResponse.Phone = "1234567890";

            var exception = Assert.Throws<ArgumentException>(() => {
                Account account = accountService.HandleResponse(accountResponse);
            });
            Assert.AreEqual("Email is required", exception.Message);

        }
    }
}