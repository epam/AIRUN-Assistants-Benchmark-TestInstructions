using Microsoft.VisualStudio.TestPlatform.TestHost;
using src;

namespace Test
{
    [TestFixture]
    public class BankAccountTests
    {
        [Test]
        public void CheckBalance_ShouldPrintArgumentNullExceptionForCredits()
        {
            StringWriter consoleOutput = new StringWriter();
            Console.SetOut(consoleOutput);

            double initialAmount = 1000.00;
            List<double> credits = null;
            List<double> debits = new List<double> { 100.00, 50.25, 80.00 };
            BankAccount.CheckBalance(initialAmount, credits, debits);

            string output = consoleOutput.ToString();
            Assert.IsTrue(output.Contains("Credits list cannot be null."));
        }
    }
}