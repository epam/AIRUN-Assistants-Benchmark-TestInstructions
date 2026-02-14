using eShop.Identity.API.Services;

namespace eShop.Identity.UnitTests
{
    [TestClass]
    [TestCategory("RedirectServiceSecurityTests")]
    public class RedirectServiceSecurityTests
    {
        private readonly RedirectService redirectService = 
            new(
                [
                    new Uri("https://trusted.com/callback"),
                    new Uri("https://secure-site.com/return"),
                    new Uri("https://another-trusted.com/redirect?auto=true")
                ]
            );

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_NonWhitelistedUrl_ReturnsEmpty()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://malicious.com?redirect_uri=https://malicious.com/callback");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_DoubleEncodedNonWhitelistedUrl_ReturnsEmpty()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri=https%253A%252F%252Fmalicious.com%252Fcallback");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_DoubleEncodedWhitelistedUrl_ReturnsUrl()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri=https%253A%252F%252Ftrusted.com%252Fcallback");
            Assert.AreEqual("https://trusted.com/callback", result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_MalformedUrl_ReturnsEmpty()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri=ht!tp://malformed-url");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_ValidWhitelistedUrl_ReturnsUrl()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri=https://trusted.com/callback");
            Assert.AreEqual("https://trusted.com/callback", result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_NoRedirectUriParameter_ReturnsEmpty()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_EmptyRedirectUriValue_ReturnsEmpty()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri=");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_EmptyRedirectUriValueWithoutEquals_ReturnsEmpty()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_InvalidPercentEncoding_ReturnsEmpty()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri=%2");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_AmpersandSeparated_WhitelistedFirst_ReturnsWhitelisted()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri=https://trusted.com/callback&https://malicious.com/callback");
            Assert.AreEqual("https://trusted.com/callback", result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_AmpersandSeparated_MaliciousFirst_ReturnsEmpty()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://trusted.com?redirect_uri=https://malicious.com/callback&https://trusted.com/callback");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_InvalidUri_ReturnsEmtpy()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("Some invalid URI");
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_EmptyUri_ReturnsEmtpy()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl(string.Empty);
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_ValidIncludingAnotherQuestionMark_ReturnsUrl()
        {
            var result = redirectService.ExtractRedirectUriFromReturnUrl("https://another-trusted.com?redirect_uri=https://another-trusted.com/redirect%3Fauto=true");
            Assert.AreEqual("https://another-trusted.com/redirect?auto=true", result);
        }
    }
}
