using NUnit.Framework;

namespace Tests
{
    [TestFixture()]
    public class NumberHelperTests
    {
        private static List<int> numbers;

        [SetUp]
        public void SetUp()
        {
            numbers = new List<int> { 1, 3, 5, 7, 9 };
        }

        [Test()]
        public void TestFindLargestEvenNumberMaxFixed()
        {
            numbers = new List<int> { 1, 3, 5, 7, 9, 8 };
            Assert.DoesNotThrow(() =>
                NumberHelper.FindLargestEvenNumber(numbers)
            );
        }

        [Test()]
        public void TestFindLargestEvenNumberMaxExpected()
        {
            Assert.DoesNotThrow(() =>
                NumberHelper.FindLargestEvenNumber(numbers)
            );
        }
    }
}