using eShop.Identity.API.Services;

namespace eShop.Identity.UnitTests
{
    [TestClass]
    [TestCategory("RedirectServiceTests")]
    public sealed class RedirectServiceTests
    {
        private readonly RedirectService redirectService = new();

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_WithSigninOidc_ReturnsCorrectUri()
        {
            // Arrange
            var url = "https://example.com?redirect_uri=https%3A%2F%2Fmyapp.com%2Fsignin-oidc";

            // Act
            var result = redirectService.ExtractRedirectUriFromReturnUrl(url);

            // Assert
            Assert.AreEqual("https://myapp.com/", result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_WithScope_ReturnsCorrectUri()
        {
            // Arrange
            var url = "https://example.com?redirect_uri=https%3A%2F%2Fmyapp.com%2Fscope";

            // Act
            var result = redirectService.ExtractRedirectUriFromReturnUrl(url);

            // Assert
            Assert.AreEqual("https://myapp.com/", result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_ComplexUri_ReturnsDecodedUri()
        {
            // Arrange
            var url = "https://example.com?redirect_uri=https%3A%2F%2Fmyapp.com%2Fapi%2Fv1%2Fsignin-oidc";

            // Act
            var result = redirectService.ExtractRedirectUriFromReturnUrl(url);

            // Assert
            Assert.AreEqual("https://myapp.com/api/v1/", result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_WithAmpersandInUrl_ReturnsCleanedUri()
        {
            // Arrange
            var url = "https://example.com?redirect_uri=https%3A%2F%2Fmyapp.com%2F&signin-oidc";

            // Act
            var result = redirectService.ExtractRedirectUriFromReturnUrl(url);

            // Assert
            Assert.AreEqual("https://myapp.com/", result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_WithoutRedirectUri_ReturnsEmptyString()
        {
            // Arrange
            var url = "https://example.com?param=value";

            // Act
            var result = redirectService.ExtractRedirectUriFromReturnUrl(url);

            // Assert
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_NoParams_ReturnsEmptyString()
        {
            // Arrange
            var url = "https://example.com";

            // Act
            var result = redirectService.ExtractRedirectUriFromReturnUrl(url);

            // Assert
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_WithEmptyString_ReturnsEmptyString()
        {
            // Arrange
            var url = string.Empty;

            // Act
            var result = redirectService.ExtractRedirectUriFromReturnUrl(url);

            // Assert
            Assert.AreEqual(string.Empty, result);
        }

        [TestMethod]
        public void ExtractRedirectUriFromReturnUrl_WithRedirectUriButNoSplitKey_ReturnsEmptyString()
        {
            // Arrange
            var url = "https://example.com?redirect_uri=https%3A%2F%2Fmyapp.com%2Fnosplitkey";

            // Act
            var result = redirectService.ExtractRedirectUriFromReturnUrl(url);

            // Assert
            Assert.AreEqual(string.Empty, result);
        }
    }
}
