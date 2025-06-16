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

    it('shows In stock label in green', () => {
        cy.visit('/');

        cy.get('.catalog-item')
            .eq(2)
            .should('exist')
            .then(($product) => {
                cy.wrap($product)
                    .contains('span', 'In stock')
                    .should('be.visible')
                    .then($stockInfo => {
                        const computedStyle = window.getComputedStyle($stockInfo[0]);
                        const color = computedStyle.color;
                        console.log('Direct computed color:', color);
                        
                        const [r, g, b] = color.match(/\d+/g).map(Number).slice(0, 3);
                        expect(g, 'Green component dominates red').to.be.greaterThan(r);
                        expect(g, 'Green component dominates blue').to.be.greaterThan(b);
                    });
            });
    });

    it('vertically aligns stock info correctly, single-line titles', () => {
        cy.visit('/');

        cy.get('.catalog-item')
            .filter((_, element) => {
                const $nameEl = Cypress.$(element).find('.name').first();
                return $nameEl.text() === 'Adventurer GPS Watch';
            })
            .first()
            .should('exist')
            .within(_ => {
                cy.get('.price').as('price');
                cy.contains('span', 'Out of stock').as('stockInfo');

                cy.get('@price').then($price => {
                    cy.get('@stockInfo').then($stockInfo => {
                        const priceRectRight = $price[0].getBoundingClientRect().right;
                        const stockInfoRectRight = $stockInfo[0].getBoundingClientRect().right;

                        expect(stockInfoRectRight, 'Stock info is aligned with price').to.be.closeTo(priceRectRight, 2);
                    });
                });
            });
    });

    it('vertically aligns stock info correctly, multi-line titles', () => {
        cy.visit('/');

        cy.get('.catalog-item')
            .first() // The first item has a multi-line title
            .should('exist')
            .within(_ => {
                cy.get('.price').as('price');
                cy.contains('span', 'In stock').as('stockInfo');

                cy.get('@price').then($price => {
                    cy.get('@stockInfo').then($stockInfo => {
                        const priceRectRight = $price[0].getBoundingClientRect().right;
                        const stockInfoRectRight = $stockInfo[0].getBoundingClientRect().right;

                        expect(stockInfoRectRight, 'Stock info is aligned with price').to.be.closeTo(priceRectRight, 2);
                    });
                });
            });
    });

    it('horizontally aligns stock info and multi-line titles correctly', () => {
        cy.visit('/');

        cy.get('.catalog-item')
            .first() // The first item has a multi-line title
            .should('exist')
            .within(_ => {
                cy.get('.name').as('name');
                cy.contains('span', 'In stock').as('stockInfo');

                cy.get('@name').then($name => {
                    cy.get('@stockInfo').then($stockInfo => {
                        const nameRectLine2Top = $name[0].getBoundingClientRect().top + $name[0].getBoundingClientRect().height / 2;
                        const stockInfoRectTop = $stockInfo[0].getBoundingClientRect().top;

                        expect(stockInfoRectTop, 'Price is aligned with name').to.be.closeTo(nameRectLine2Top, 5);
                    });
                });
            });
    });

    it('horizontally aligns price and single-line titles correctly', () => {
        cy.visit('/');

        cy.get('.catalog-item')
            .eq(1)
            .should('exist')
            .within(_ => {
                cy.get('.name').as('name');
                cy.get('.price').as('price');

                cy.get('@name').then($name => {
                    cy.get('@price').then($price => {
                        const nameRectTop = $name[0].getBoundingClientRect().top;
                        const priceRectTop = $price[0].getBoundingClientRect().top;

                        expect(priceRectTop, 'Price is aligned with name').to.be.closeTo(nameRectTop, 2);
                    });
                });
            });
    });

    it('shows stock info on an in-stock product page in green', () => {
        cy.visit('/item/95');

        cy.contains('span', 'In stock (100 units)')
            .should('be.visible')
            .then($stockInfo => {
                const computedStyle = window.getComputedStyle($stockInfo[0]);
                const color = computedStyle.color;
                console.log('Direct computed color:', color);
                
                const [r, g, b] = color.match(/\d+/g).map(Number).slice(0, 3);
                expect(g, 'Green component dominates red').to.be.greaterThan(r);
                expect(g, 'Green component dominates blue').to.be.greaterThan(b);
            });
    });

    it('correctly shows stock info on an out-of-stock product page', () => {
        cy.visit('/item/99');

        cy.contains('span', 'Out of stock')
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

    it('positions stock info correctly on product page', () => {
        cy.visit('/item/95');

        cy.get('.item-details')
            .within(_ => {
                cy.get('.price').as('price');
                cy.get('button').contains('Log in to purchase').as('loginButton');
                cy.contains('span', 'In stock').as('stockInfo');

                cy.get('@price').then($price => {
                    cy.get('@loginButton').then($loginButton => {
                        cy.get('@stockInfo').then($stockInfo => {
                            const priceRectRight = $price[0].getBoundingClientRect().right;
                            const stockInfoRectLeft = $stockInfo[0].getBoundingClientRect().left;
                            const stockInfoRectRight = $stockInfo[0].getBoundingClientRect().right;
                            const loginButtonRectLeft = $loginButton[0].getBoundingClientRect().left;

                            expect(stockInfoRectLeft, 'Stock info is to the right of price').to.be.greaterThan(priceRectRight);
                            expect(loginButtonRectLeft, 'Login button is to the right of stock info').to.be.greaterThan(stockInfoRectRight);
                        });
                    });
                });
            });
    });
});