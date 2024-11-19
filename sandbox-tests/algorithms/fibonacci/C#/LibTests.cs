using src;

namespace Test
{
    [TestFixture]
    public class LibTests
    {
        [Test]
        public void Fibonacci_WhenCalled_ReturnsFibonacciNumber()
        {
            var result = Lib.Fibonacci(6);
            Assert.That(result, Is.EqualTo(8));
        }

        [Test]
        public void Fibonacci_WhenCalledWithOne_ReturnsOne()
        {
            var result = Lib.Fibonacci(1);
            Assert.That(result, Is.EqualTo(1));
        }
    }
}