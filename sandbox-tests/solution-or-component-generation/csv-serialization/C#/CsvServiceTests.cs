using static CsvService.CsvService;

namespace Test
{
    public class CsvServiceTests
    {
        [Test]
        public void SerializeToCsv_EmptyObjectList_ReturnsEmptyStringOrNewLine()
        {
            var list = new List<object>();

            var actual = SerializeToCsv(list);

            Assert.That(actual == string.Empty || actual == "\r\n", Is.True);
        }

        [Test]
        public void SerializeToCsv_WithHeaders_SerializesCorrectly()
        {
            var list = new List<Person>
            {
                new Person { Name = "John", Age = 25 },
                new Person { Name = "Jane", Age = 30 }
            };
            var expected = "Name,Age\r\nJohn,25\r\nJane,30\r\n";

            var result = SerializeToCsv(list);

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void SerializeToCsv_WithoutHeaders_SerializesCorrectly()
        {
            var list = new List<Person>
            {
                new Person { Name = "John", Age = 25 },
                new Person { Name = "Jane", Age = 30 }
            };
            var expected = "John,25\r\nJane,30\r\n";

            var result = SerializeToCsv(list, hasHeader: false);

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void SerializeToCsv_CustomDelimiter_SerializesCorrectly()
        {
            var list = new List<Person>
            {
                new Person { Name = "John", Age = 25 },
                new Person { Name = "Jane", Age = 30 }
            };
            var expected = "Name;Age\r\nJohn;25\r\nJane;30\r\n";

            var result = SerializeToCsv(list, delimiter: ";");

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void SerializeToCsv_DifferentPropertyTypes_SerializesCorrectly()
        {
            var list = new List<SystemUser>
            {
                new SystemUser { Id = Guid.Parse("ef0724de-17df-45d4-bd4e-bd3cc5801116"), Name = "John", Age = 25 },
                new SystemUser { Id = Guid.Parse("9e9d3801-31b3-4615-b1f6-62575c0e548e"), Name = "Jane", Age = 30 }
            };
            var expected = "Id,Name,Age\r\nef0724de-17df-45d4-bd4e-bd3cc5801116,John,25\r\n9e9d3801-31b3-4615-b1f6-62575c0e548e,Jane,30\r\n";

            var result = SerializeToCsv(list);

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void SerializeToCsv_EmptyListWithHeaders_ReturnsOnlyHeader()
        {
            var list = new List<Person>();
            var expected = "Name,Age\r\n";

            var result = SerializeToCsv(list);

            Assert.That(result, Is.EqualTo(expected));
        }

        public class Person
        {
            public string Name { get; set; }
            public int Age { get; set; }
        }

        public class SystemUser : Person
        {
            public Guid Id { get; set; }
        }
    }
}