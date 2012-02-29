<%@ page import="subscription.Purchasable" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="checkout_facebook"/>
</head>
    <body class="facebookTab">
        <content tag="content">
            <r:img uri="${vh.getMediaServer()}/web/subscription/box.jpg"/>
            <h1><span>Carmine</span> is the best new way to discover beauty</h1>
            <p><strong>Carmine</strong> is literally beauty's best - in a box! We strive to make finding the right beauty products that much easier by sending you hand-picked samples to <strong>try before you buy</strong> each month.</p>
            <p class="right">No contract. Cancel anytime <a href="#" id="subscriptionLink" class="button red"><span class="arrowRight">Get started now!</span></a></p>
            <br/><br/>
            <section class="info">
                <ul class="clearfix">
                    <li>
                        <r:img uri="${vh.getMediaServer()}/web/subscription/step-1.png"/>
                        <h3>Take a 3 minutes beauty quiz</h3>
                        <p>Tell us what you like so we can get to know your taste.</p>
                    </li>
                    <li class="last">
                        <r:img uri="${vh.getMediaServer()}/web/subscription/step-2.png"/>
                        <h3>Beauty experts pick products</h3>
                        <p>Our passionate beauty experts to help select the best and unique products.</p>
                    </li>
                    <li>
                        <r:img uri="${vh.getMediaServer()}/web/subscription/step-3.png"/>
                        <h3>Receive your samples by post</h3>
                        <p>We guarantee that you’ll never receive any flimsy sachets.</p>
                    </li>
                    <li class="marketing last">
                        <p>Get <strong>5 deluxe samples</strong> delivered to your door for <span>only £10</span> per month</p>
                        <br/><a href="#" id="subscriptionLinkBotton" class="button red"><span class="arrowRight">Get started now!</span></a><br/>
                        <p class="cancel">No contract. Cancel anytime</p>
                    </li>
                </ul>
            </section>
            <r:script>
                $(function(){
                    $('#subscriptionLink, #subscriptionLinkBotton').on('click', function(e){
                       FB.getLoginStatus(function(response){
                            if(response.authResponse){
                                redirectToAddress()
                            }
                            else {
                                FB.login(function(){}, {scope: 'email,user_about_me,user_birthday,user_location,user_website, friends_about_me, publish_actions'});
                            }
                        });
                        e.preventDefault()
                    })
                })

                var redirectToAddress = function(){
                    carmine.redirect("${g.createLink(controller:"checkout", action:"address", params: [purchasable:purchasable, planId:plan.id, boxId: currentBox.id, facebookHeader:true])}")
                }

                FB.Event.subscribe('auth.login', function(response){
                    facebook.login()
                });
                $('body').on('facebook_auth_start', carmine.showSpinner)
                $('body').on('facebook_auth_end', carmine.hideSpinner)
                $('body').on('facebook_auth_success', function(){
                    redirectToAddress()
                })
            </r:script>
        </content>
    </body>
</html>