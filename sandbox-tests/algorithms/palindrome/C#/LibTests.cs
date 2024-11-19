using src;

namespace Test
{
    [TestFixture]
    public class LibTests
    {
        [TestCase(121)]
        [TestCase(267762)]
        [TestCase(999999999)]
        public void CheckIfNumberIsPalindrome_WhenNumberIsPalindrome_ReturnsTrue(int n)
        {
            var result = Lib.CheckIfNumberIsPalindrome(n);
            Assert.IsTrue(result);
        }

        [TestCase(123)]
        [TestCase(267362)]
        [TestCase(99999499)]
        public void CheckIfNumberIsPalindrome_WhenNumberIsNotPalindrome_ReturnsFalse(int n)
        {
            var result = Lib.CheckIfNumberIsPalindrome(n);
            Assert.IsFalse(result);
        }
    }
}