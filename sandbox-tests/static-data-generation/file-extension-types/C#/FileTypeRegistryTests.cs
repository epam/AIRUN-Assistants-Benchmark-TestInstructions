using FileLib;

namespace Test
{
    public class Tests
    {
        [Test]
        public void Top10FileExtensionTypes_WhenCalled_ReturnsNonEmptyArray()
        {
            var fileTypeRegistry = new FileTypeRegistry();

            var result = fileTypeRegistry.Top10FileExtensionTypes;

            Assert.That(result, Is.Not.Empty);
        }

        [Test]
        public void Top10FileExtensionTypes_WhenCalled_Returns10Strings()
        {
            var fileTypeRegistry = new FileTypeRegistry();

            var result = fileTypeRegistry.Top10FileExtensionTypes;

            Assert.That(result, Has.Length.EqualTo(10));
        }

        [Test]
        public void Top10FileExtensionTypes_WhenCalled_ReturnsNonEmptyStrings()
        {
            var fileTypeRegistry = new FileTypeRegistry();

            var result = fileTypeRegistry.Top10FileExtensionTypes;

            Assert.That(result, Is.All.Not.Empty);
        }

        [Test]
        public void Top10FileExtensionTypes_WhenCalled_ReturnsRegexValidExtensions()
        {
            var fileTypeRegistry = new FileTypeRegistry();

            var result = fileTypeRegistry.Top10FileExtensionTypes;

            Assert.That(result, Is.All.Matches(@"^\.\w+$"));
        }

        [Test]
        public void Top10FileExtensionTypes_WhenCalled_ReturnsUniqueExtensions()
        {
            var fileTypeRegistry = new FileTypeRegistry();

            var result = fileTypeRegistry.Top10FileExtensionTypes;

            Assert.That(result, Is.Unique);
        }
    }
}