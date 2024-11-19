using F23.StringSimilarity;
using NUnit.Framework;

namespace openapiTests
{
    public class ControllerTests
    {
        private const string GeneratedOpenApiDocumentationPath = "GeneratedOpenApiDocumentation.json";
        private const string CorrectOpenApiDocumentationFilePath = "CorrectOpenApiDocumentation.json";
        private const double SimilarityThreshold = 0.6;

        [Test]
        public void ControllerOpenApiDocumentationSimilarityTest()
        {
            var similarity = CalculateSimilarity(File.ReadAllText(CorrectOpenApiDocumentationFilePath), File.ReadAllText(GeneratedOpenApiDocumentationPath));

            Console.WriteLine($"Similarity: {similarity}");
            Assert.That(similarity, Is.GreaterThan(SimilarityThreshold));
        }

        private static double CalculateSimilarity(string text1, string text2)
        {
            return new Jaccard().Similarity(text1, text2);
        }
    }
}