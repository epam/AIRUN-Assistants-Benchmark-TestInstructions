describe('Add Stock Info', () => {
    it('shows the new item as the first in product list', () => {
        cy.visit('/');

        cy.get('.catalog-item')
            .first()
            .should('exist')
            .find('.name')
            .first()
            .invoke('text')
            .then((productTitle) => {
                expect(productTitle.startsWith('Ab'), 'Its title starts with Ab').to.be.true;
            });
    });

    it('shows all 50 characters of the new item inside the same element', () => {
        cy.visit('/');

        cy.get('.catalog-item')
            .first()
            .should('exist')
            .find('.name')
            .first()
            .invoke('text')
            .should('have.length', 50);
    });

    it('shows Adventurer GPS Watch as out of stock in red', () => {
        cy.visit('/');

        cy.get('.catalog-item')
            .filter((_, element) => {
                const $nameEl = Cypress.$(element).find('.name').first();
                return $nameEl.text() === 'Adventurer GPS Watch';
            })
            .first()
            .should('exist')
            .then(($product) => {
                cy.wrap($product)
                    .contains('span', 'Out of stock')
                    .should('be.visible')
                    .then($stockInfo => {
                        const computedStyle = window.getComputedStyle($stockInfo[0]);
                        const color = computedStyle.color;
                        console.log('Direct computed color:', color);
                        
                        const [r, g, b] = color.match(/\d+/g).map(Number).slice(0, 3);
                        expect(r, 'Red component dominates green').to.be.greaterThan(g);
                        expect(r, 'Red component dominates blue').to.be.greaterThan(b);
                    });
            });
    });

    it('shows In stock label in green', () => {});

    it('aligns stock info correctly, single-line titles', () => {});

    it('aligns stock info correctly, multi-line titles', () => {});

    it('correctly shows stock info on an in-stock product page', () => {});

    it('correctly shows stock info on an out-of-stock product page', () => {});
});