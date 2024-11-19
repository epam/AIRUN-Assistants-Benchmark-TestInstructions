using src;
using Microsoft.CodeAnalysis.CSharp;
using Microsoft.CodeAnalysis.CSharp.Syntax;

namespace Test
{
    public class LibTests
    {
        [Test]
        public void TestGreet_WhenCalledWithNull_ReturnsHello()
        {
            var lib = new Lib();
            var name = (string)null;

            var result = lib.Greet(name);

            Assert.That(result, Is.EqualTo("Hello!"));
        }

        [Test]
        public void TestGreet_WhenCalledWithName_ReturnsHelloName()
        {
            var lib = new Lib();
            var name = "John";

            var result = lib.Greet(name);

            Assert.That(result, Is.EqualTo("Hello, John!"));
        }
    }
}