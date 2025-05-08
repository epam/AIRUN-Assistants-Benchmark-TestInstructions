using Microsoft.AspNetCore.WebUtilities;

namespace eShop.Identity.API.Services
{
    public class RedirectService(HashSet<Uri> whitelistedRedirectUris) : IRedirectService
    {
        public string ExtractRedirectUriFromReturnUrl(string url)
        {
            if (!Uri.TryCreate(url, UriKind.Absolute, out var uri))
                return string.Empty;

            var query = QueryHelpers.ParseQuery(uri.Query);
            if (!query.TryGetValue("redirect_uri", out var redirectUriValues))
                return string.Empty;

            var redirectUri = redirectUriValues.FirstOrDefault();
            if (redirectUri == null)
                return string.Empty;

            // unescaping any encoded characters (such as : or /) in the redirect URL
            // also allows to unescape double-escaped characters
            var decodedRedirectUri = Uri.UnescapeDataString(redirectUri);

            // transforming the decoded URL into a Uri
            if (!Uri.TryCreate(decodedRedirectUri, UriKind.Absolute, out var validatedRedirectUri))
                return string.Empty;    

            return whitelistedRedirectUris.Contains(validatedRedirectUri)
                ? validatedRedirectUri.ToString()
                : string.Empty;
        }
    }
}
