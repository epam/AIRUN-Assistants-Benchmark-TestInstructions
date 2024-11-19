using NUnit.Framework;
using Swashbuckle.AspNetCore.Annotations;


namespace Tests
{
    public class UsersControllerTests
    {

        [Test]
        public void testIfCreateUserMethodContainSwaggerOperationAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("CreateUser");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerOperationAttribute), false).Any();


            Assert.True(hasAttribute);
        }

        [Test]
        public void testIfCreateUserMethodContainSwaggerResponseAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("CreateUser");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerResponseAttribute), false).Any();


            Assert.True(hasAttribute);
        }
 
        [Test]
        public void testIfGetUserMethodContainSwaggerOperationAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("GetUser");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerOperationAttribute), false).Any();


            Assert.True(hasAttribute);
        }

        [Test]
        public void testIfGetUserMethodContainSwaggerResponseAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("GetUser");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerResponseAttribute), false).Any();


            Assert.True(hasAttribute);
        }

        [Test]
        public void testIfGetAllUsersMethodContainSwaggerOperationAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("GetAllUsers");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerOperationAttribute), false).Any();


            Assert.True(hasAttribute);
        }

        [Test]
        public void testIfGetAllUsersMethodContainSwaggerResponseAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("GetAllUsers");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerResponseAttribute), false).Any();


            Assert.True(hasAttribute);
        }
        
        [Test]
        public void testIfUpdateUserMethodContainSwaggerOperationAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("UpdateUser");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerOperationAttribute), false).Any();


            Assert.True(hasAttribute);
        }
        
        [Test]
        public void testIfUpdateUserMethodContainSwaggerResponseAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("UpdateUser");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerResponseAttribute), false).Any();


            Assert.True(hasAttribute);
        }

        [Test]
        public void testIfDeleteUserMethodContainSwaggerOperationAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("DeleteUser");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerOperationAttribute), false).Any();


            Assert.True(hasAttribute);
        }

        [Test]
        public void testIfDeleteUserMethodContainSwaggerResponseAttribute()
        {
            var methodInfo = typeof(UsersController).GetMethod("DeleteUser");
            var hasAttribute = methodInfo.GetCustomAttributes(typeof(SwaggerResponseAttribute), false).Any();


            Assert.True(hasAttribute);
        }

    }
}