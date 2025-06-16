const { defineConfig } = require("cypress");

module.exports = defineConfig({
    e2e: {
        baseUrl: "https://localhost:7298",
        specPattern: "cypress/e2e/**/*.cy.{js,jsx}",
        supportFile: false
    },
});
