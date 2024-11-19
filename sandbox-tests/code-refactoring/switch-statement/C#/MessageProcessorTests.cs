using NUnit.Framework;
using Microsoft.CodeAnalysis.CSharp;
using Microsoft.CodeAnalysis.CSharp.Syntax;

namespace Tests
{
    [TestFixture()]
    public class MessageProcessorTests
    {
        private MessageProcessor messageProcessor = new MessageProcessor();

        [Test()]
        public void TestHandleMessageError100()
        {
            Message message = new Message
            {
                ErrorCode = "100"
            };

            var exception = Assert.Throws<MessageException>(() =>
            {
                messageProcessor.HandleMessageError(message);
            });

            Assert.AreEqual("Exception with code 100 occurred while processing the message", exception.Message);
        }

        [Test()]
        public void TestHandleMessageError200()
        {
            Message message = new Message
            {
                ErrorCode = "200"
            };

            var exception = Assert.Throws<MessageException>(() =>
            {
                messageProcessor.HandleMessageError(message);
            });

            Assert.AreEqual("Exception with code 200 occurred while processing the message", exception.Message);
        }

        [Test()]
        public void TestHandleMessageError300()
        {
            Message message = new Message
            {
                ErrorCode = "300"
            };

            var exception = Assert.Throws<MessageException>(() =>
            {
                messageProcessor.HandleMessageError(message);
            });

            Assert.AreEqual("Exception with code 300 occurred while processing the message", exception.Message);
        }

        [Test]
        public void TestHandleMessageErrorHasSwitchStatement()
        {
            var filename = "..\\..\\..\\..\\switch-statement\\MessageProcessor.cs";
            var code = File.ReadAllText(filename);
            var tree = CSharpSyntaxTree.ParseText(code);
            var root = tree.GetRoot();
            var expectMethodName = "HandleMessageError";
            var expectedStatement = "switch";

            var method = root.DescendantNodes().OfType<MethodDeclarationSyntax>()
            .Where(x => x.Identifier.Text == expectMethodName).FirstOrDefault();
            var methodStatement = method?.ToFullString().Trim();

            Assert.That(methodStatement.Contains(expectedStatement));
        }
    }
}