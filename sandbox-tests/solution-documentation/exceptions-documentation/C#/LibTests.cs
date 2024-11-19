using System.Xml;

namespace LibTests
{
    public class Tests
    {
        private const string XmlFilePath = "../../../../src/bin/Debug/net7.0/src.xml";
        private XmlDocument xmlDocument = new XmlDocument();
        private string xpath = "/doc/members/member[starts-with(@name, 'M:src.Lib.PublishArticle')]";

        [SetUp]
        public void Setup()
        {
            Assert.True(File.Exists(XmlFilePath), "XML documentation file not found.");
            xmlDocument.Load(XmlFilePath);
        }

        [Test]
        public void PublishArticle_DocumentationIsNotNull()
        {
            var navigator = xmlDocument.CreateNavigator();

            var summaryNode = navigator.SelectSingleNode(xpath);

            Assert.NotNull(summaryNode, "Summary node for the method 'PublishArticle' not found.");
        }

        [Test]
        public void PublishArticle_HasFourExceptionsDocumented()
        {
            var navigator = xmlDocument.CreateNavigator();

            var exceptionNodes = navigator.Select(xpath + "/exception");

            Assert.That(exceptionNodes.Count, Is.EqualTo(4), "Method 'PublishArticle' should have 4 exceptions.");
        }

        [TestCase("T:System.ArgumentException")]
        [TestCase("T:System.NullReferenceException")]
        [TestCase("T:System.InvalidOperationException")]
        [TestCase("T:System.IO.FileNotFoundException")]
        public void PublishArticle_HasConcreteExceptionDocumentedAndIsNotExmpty(string cref)
        {
            var navigator = xmlDocument.CreateNavigator();

            var exceptionNode = navigator.SelectSingleNode(xpath + $"/exception[@cref='{cref}']");

            Assert.NotNull(exceptionNode, $"Exception '{cref}' not found.");
            Assert.IsNotEmpty(exceptionNode.Value, $"Exception '{cref}' is empty.");
        }

        [TestCase("T:System.ArgumentException", new string[] { "title", "content" })]
        [TestCase("T:System.NullReferenceException", new string[] { "author" })]
        [TestCase("T:System.InvalidOperationException", new string[] { "author" })]
        [TestCase("T:System.IO.FileNotFoundException", new string[] { "file", "publish" })]
        public void PublishArticle_ConcreteExceptionDocumentationContainWords(string cref, string[] words)
        {
            var navigator = xmlDocument.CreateNavigator();

            var exceptionNode = navigator.SelectSingleNode(xpath + $"/exception[@cref='{cref}']");

            var summary = exceptionNode.Value;

            foreach (var word in words)
            {
                Assert.True(summary.Contains(word), $"Exception '{cref}' should contain word '{word}'.");
            }
        }
    }
}