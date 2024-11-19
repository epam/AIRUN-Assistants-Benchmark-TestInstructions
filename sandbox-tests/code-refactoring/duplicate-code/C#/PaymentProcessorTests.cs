using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tests
{
    [TestFixture()]
    public class PaymentProcessorTests
    {
        [Test()]
        public void ProcessPaymentTest()
        {
            PaymentProcessor paymentProcessor = new PaymentProcessor();
            Payment payment = paymentProcessor.ProcessPayment(true);
            Assert.AreEqual("ICICI", payment.PaymentBank);
            Assert.AreEqual("online", payment.PaymentMode);
            Assert.AreEqual("credit", payment.PaymentType);
            Assert.AreEqual("active", payment.PaymentStatus);
            Assert.AreEqual(DateTime.Now.Date, payment.PaymentDate.Date);
                
        }
    }
}