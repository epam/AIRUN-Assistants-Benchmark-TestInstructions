using System.Xml;

namespace ControllerTests
{
    public class Tests
    {
        private const string XmlFilePath = "../../../../src/bin/Debug/net7.0/src.xml";
        private XmlDocument xmlDocument = new XmlDocument();
        private string xpath = "/doc/members/member[starts-with(@name, 'M:src.Controllers.SocialMediaStatsController.GetMostTrendingSM')]/summary";


        [SetUp]
        public void Setup()
        {
            Assert.True(File.Exists(XmlFilePath), "XML documentation file not found.");
            xmlDocument.Load(XmlFilePath);
        }

        [Test]
        public void GetMostTrendingSM_HasSummary()
        {
            var navigator = xmlDocument.CreateNavigator();

            var summaryNode = navigator.SelectSingleNode(xpath);

            Assert.NotNull(summaryNode, "Summary node for the method 'GetMostTrendingSM' not found.");
        }

        [Test]
        public void GetMostTrendingSM_SummaryIsNotEmpty()
        {
            var navigator = xmlDocument.CreateNavigator();

            var summaryNode = navigator.SelectSingleNode(xpath);
            
            Assert.False(string.IsNullOrWhiteSpace(summaryNode.Value), "Summary for the method 'GetMostTrendingSM' is empty or whitespace.");
        }

        [TestCase("most")]
        [TestCase("trending")]
        [TestCase("social")]
        [TestCase("media")]
        public void GetMostTrendongSM_SummaryContainsWord(string expected)
        {
            var navigator = xmlDocument.CreateNavigator();

            var summaryNode = navigator.SelectSingleNode(xpath);

            StringAssert.Contains(expected, summaryNode.Value);
        }
    }
}