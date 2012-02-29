<g:applyLayout name="check-out">
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <g:layoutHead />
        </head>
        <body>
            <h1><g:message code="checkout.order.title"/></h1>
            <section id="checkoutOrderSummary" class="checkout">
                ${pageProperty(name:'page.content')}
            </section>
        </body>
    </html>
</g:applyLayout>