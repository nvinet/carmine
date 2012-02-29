<!DOCTYPE html>
<html lang="en">
    <head>
        <title><g:message code="meta.title.default"/></title>
        <meta name="layout" content="landing" />
    </head>
    <body class="homepage">
        <content tag="content">
            <section class="value_main">
                <h1>Try products from exclusive beauty brands without spending a fortune</h1>
                <p>Get 5 deluxe samples delivered to your door for only £10 per month</p>
                <ul class="clearfix">
                    <li><span>1</span> Take a 3 minute quiz and tell us what you like</li>
                    <li><span>2</span> Our beauty experts pick 5 great products for you each month</li>
                    <li class="last"><span>3</span> You receive deluxe samples in a stylish beauty box</li>
                </ul>
                <g:link controller="subscription" action="order" class="button green"><span class="arrowRight">Get Started Now</span></g:link>
            </section>
            <section class="value_how">
                <h2><span>Carmine</span> is the best new way to discover beauty</h2>
                <p class="widget"><strong>Carmine</strong> is literally beauty’s best - in a box! We strive to make finding the right beauty products that much easier by sending you hand-picked samples to <strong>try before you buy</strong> each month.</p>

                <div class="box clearfix">
                    <h3>How it <span>works</span></h3>
                    <ul class="widget clearfix">
                        <li class="step1">
                            <h4>Take a 3 minute beauty quiz</h4>
                            <p>Tell us what you like so we can get to know your taste.</p>
                        </li>
                        <li class="step2">
                            <h4>Beauty experts pick products</h4>
                            <p>We have some passionate beauty experts to help select the best and unique products.</p>
                        </li>
                        <li class="step3 last">
                            <h4>Receive your samples by post</h4>
                            <p>We guarantee that you’ll never receive any flimsy sachets.</p>
                        </li>
                    </ul>
                    <p class="left" style="margin:12px 0 0 140px">Get 5 deluxe samples delivered to your door for only £10 per month. Cancel anytime.</p>
                    <g:link controller="subscription" action="order" class="button green"><span class="arrowRight">Get Started Now</span></g:link>
                </div>
                <div class="box">
                    <r:img dir="/images/landing/press.png"/>
                </div>
                <div class="widget">
                    <g:link controller="testimonial" action="index"><r:img dir="/images/landing/testimonials.png"/></g:link>
                </div>

            </section>
            <section class="ads">
                <ul>
                    <li><g:link controller="testimonial" action="index"><r:img dir="/images/landing/ad_testimonial.jpg"/></g:link></li>
                    <li><vh:localisedLink mapping="box"> <r:img dir="/images/landing/ad_box.jpg"/></vh:localisedLink></li>
                    <li class="last"><g:link url="http://feedback.carmine.co.uk/knowledgebase"><r:img dir="/images/landing/ad_faq.jpg"/></g:link></li>
                </ul>
            </section>
        </content>
    </body>
</html>