using NUnit.Framework;

namespace Tests
{
    [TestFixture()]
    public class NumericHelperTests
    {
        [Test()]
        public void TestSumOfEvenNumbers()
        {
            int sum = NumericHelper.SumOfEvenNumbers(1, 10);
            Assert.AreEqual(30, sum);
        }
    }
}