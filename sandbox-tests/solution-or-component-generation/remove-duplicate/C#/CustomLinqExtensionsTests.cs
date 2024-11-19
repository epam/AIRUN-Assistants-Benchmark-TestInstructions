using Src;

namespace Test
{
    public class CustomLinqExtensionsTests
    {
        [Test]
        public void RemoveDuplicates_WithDuplicates_ReturnsDistinctList()
        {
            List<int> inputList = new List<int> { 1, 2, 2, 3, 4, 4, 5 };
            List<int> expectedList = new List<int> { 1, 2, 3, 4, 5 };

            List<int> result = inputList.RemoveDuplicates();

            CollectionAssert.AreEqual(expectedList, result);
        }

        [Test]
        public void RemoveDuplicates_WithEmptyList_ReturnsEmptyList()
        {
            List<string> inputList = new List<string>();
            List<string> expectedList = new List<string>();

            List<string> result = inputList.RemoveDuplicates();

            CollectionAssert.AreEqual(expectedList, result);
        }

        [Test]
        public void RemoveDuplicates_WithNoDuplicates_ReturnsSameList()
        {
            List<char> inputList = new List<char> { 'a', 'b', 'c', 'd' };
            List<char> expectedList = new List<char> { 'a', 'b', 'c', 'd' };

            List<char> result = inputList.RemoveDuplicates();

            CollectionAssert.AreEqual(expectedList, result);
        }

        [Test]
        public void RemoveDuplicates_WithNullList_ThrowsArgumentNullException()
        {
            List<string> inputList = null;

            Assert.Throws<ArgumentNullException>(() => inputList.RemoveDuplicates());
        }

        [Test]
        public void RemoveDuplicates_WithReferenceType_ReturnsDistinctList()
        {
            List<Person> inputList = new List<Person>
            {
                new Person { Id = 1, Name = "John" },
                new Person { Id = 2, Name = "Jane" },
                new Person { Id = 2, Name = "Jane" },
                new Person { Id = 3, Name = "Mike" }
            };
            List<Person> expectedList = new List<Person>
            {
                new Person { Id = 1, Name = "John" },
                new Person { Id = 2, Name = "Jane" },
                new Person { Id = 3, Name = "Mike" }
            };

            List<Person> result = inputList.RemoveDuplicates();

            CollectionAssert.AreEqual(expectedList, result);
        }

        public class Person : IEquatable<Person>
        {
            public int Id { get; set; }
            public string Name { get; set; }

            public bool Equals(Person other)
            {
                return Id == other.Id && Name == other.Name;
            }

            public override bool Equals(object obj) => Equals(obj as Person);

            public override int GetHashCode() => (Id, Name).GetHashCode();
        }
    }
}