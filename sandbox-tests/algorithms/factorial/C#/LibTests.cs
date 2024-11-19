using src;

namespace Test
{
    [TestFixture]
    public class LibTests
    {
        [TestCase(5, 120)]
        [TestCase(6, 720)]
        [TestCase(7, 5040)]
        [TestCase(0, 1)]
        public void CalculateFactorialOfNumber_WhenCalled_ReturnsFactorialOfNumber(int n, int expectedResult)
        {
            var result = Lib.CalculateFactorialOfNumber(n);

            Assert.That(result, Is.EqualTo(expectedResult));
        }
    }
}