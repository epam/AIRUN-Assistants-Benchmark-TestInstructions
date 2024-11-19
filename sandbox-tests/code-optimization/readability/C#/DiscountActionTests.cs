using NUnit.Framework;
using Microsoft.CodeAnalysis.CSharp;
using Microsoft.CodeAnalysis.CSharp.Syntax;

namespace Tests
{
    [TestFixture()]
    public class DiscountActionTests
    {
        private static readonly string CHILD = "CHILD";
        private static readonly string EMPLOYEE = "EMPLOYEE";
        private static readonly string SENIOR = "SENIOR";
        private static readonly string STUDENT = "STUDENT";

        private readonly DiscountAction discountAction = new DiscountAction();

        [Test()]
        public void TestCalculateDiscountStudent()
        {
            Discount discount = discountAction.CalculateDiscount(100, STUDENT, false);

            Assert.AreEqual(10, discount.Rate);
            Assert.AreEqual(STUDENT, discount.UserType);
            Assert.IsFalse(discount.IsHoliday);
        }

        [Test()]
        public void TestCalculateDiscountSenior()
        {
            Discount discount = discountAction.CalculateDiscount(100, SENIOR, false);

            Assert.AreEqual(15, discount.Rate);
            Assert.AreEqual(SENIOR, discount.UserType);
            Assert.IsFalse(discount.IsHoliday);
        }

        [Test()]
        public void TestCalculateDiscountEmployee()
        {
            Discount discount = discountAction.CalculateDiscount(100, EMPLOYEE, false);

            Assert.AreEqual(20, discount.Rate);
            Assert.AreEqual(EMPLOYEE, discount.UserType);
            Assert.IsFalse(discount.IsHoliday);
        }

        [Test()]
        public void TestCalculateDiscountNoDiscount()
        {
            Discount discount = discountAction.CalculateDiscount(100, CHILD, false);

            Assert.AreEqual(0, discount.Rate);
            Assert.AreEqual(CHILD, discount.UserType);
            Assert.IsFalse(discount.IsHoliday);
        }

        [Test]
        public void TestDiscountActionHasBuildDiscountMethod()
        {
            var filename = "..\\..\\..\\..\\readability\\DiscountAction.cs";
            var code = File.ReadAllText(filename);
            var tree = CSharpSyntaxTree.ParseText(code);
            var root = tree.GetRoot();
            var expectMethodName = "BuildDiscount";

            var method = root.DescendantNodes().OfType<MethodDeclarationSyntax>()
            .Where(x => x.Identifier.Text == expectMethodName).FirstOrDefault();

            Assert.NotNull(method, "BuildDiscount private method is not used in DiscountAction");
        }
    }
}