<html>
    <head>
        <title>Carmine Backoffice</title>
        <meta name="layout" content="main" />
        <style type="text/css" media="screen">

        #nav {
            margin-top:20px;
            margin-left:30px;
            width:228px;
            float:left;

        }
        .homePagePanel * {
            margin:0px;
        }
        .homePagePanel .panelBody ul {
            list-style-type:none;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody h1 {
            text-transform:uppercase;
            font-size:1.1em;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody {
            background: url(images/leftnav_midstretch.png) repeat-y top;
            margin:0px;
            padding:15px;
        }
        .homePagePanel .panelBtm {
            background: url(images/leftnav_btm.png) no-repeat top;
            height:20px;
            margin:0px;
        }

        .homePagePanel .panelTop {
            background: url(images/leftnav_top.png) no-repeat top;
            height:11px;
            margin:0px;
        }
        h2 {
            margin-top:15px;
            margin-bottom:15px;
            font-size:1.2em;
        }
        #pageBody {
            margin-left:280px;
            margin-right:20px;
        }
        </style>
    </head>
    <body>
        <div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
                    <h1>Carmine Status</h1>
					<h4>UK</h4>
                    <ul>
                        <li>Registered users: <strong><bo:numberOfRegisteredUsers countryCode="GB"/></strong></li>
						<li>Facebook profiles: <strong><bo:numberOfFacebookUsers countryCode="GB"/></strong></li>
						<li>Active Subscribers: <strong><bo:activeSubscribersSize countryCode="GB"/></strong></li>
						<li>Subscription gifts: <strong><bo:subscriptionGifts countryCode="GB"/></strong></li>
						<li>One-off gifts: <strong><bo:oneOffGifts countryCode="GB"/></strong></li>
                    </ul>
					<h4>FR</h4>
					<ul>
                        <li>Registered users: <strong><bo:numberOfRegisteredUsers countryCode="FR"/></strong></li>
                        <li>Facebook profiles: <strong><bo:numberOfFacebookUsers countryCode="FR"/></strong></li>
                        <li>Active Subscribers: <strong><bo:activeSubscribersSize countryCode="FR"/></strong></li>
						<li>Subscription gifts: <strong><bo:subscriptionGifts countryCode="FR"/></strong></li>
						<li>One-off gifts: <strong><bo:oneOffGifts countryCode="FR"/></strong></li>
                    </ul>
					<h4>${session.country}</h4>
					<ul>
						<li>Orders awaiting prep:
							<ul>
								<g:each var="box" in="${bo.boxesShippedToDate()}">
									<li><strong>${box.name}:</strong> ${bo.newOrdersCount(box:box)}</li>
								</g:each>
							</ul>
						</li>
					</ul>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>
        <div id="pageBody">
            <h1>Welcome to Carmine backoffice</h1>

			<sec:ifAllGranted roles="ROLE_WRITER">
            <div id="controllerList" class="dialog">
                <h2>Products and Brands</h2>
                <ul>
                    <li class="controller"><g:link controller="brand" action="list" params="[countryCode:'GB']">Manage UK Brands</g:link></li>
					<li class="controller"><g:link controller="brand" action="list" params="[countryCode:'FR']">Manage FR Brands</g:link></li>
				</ul>
				<br/>
				<ul>
					<li class="controller"><g:link controller="product" action="list" params="[countryCode:'GB']">Manage UK Products</g:link></li>
					<li class="controller"><g:link controller="product" action="list" params="[countryCode:'FR']">Manage FR Products</g:link></li>
                </ul>
            </div>
			</sec:ifAllGranted>

            <sec:ifAllGranted roles="ROLE_CRM">
            <div id="controllerList" class="dialog">
                <h2>CRM</h2>
                <ul>
                    <li class="controller"><g:link controller="feature">Features</g:link></li>
					<li class="controller"><g:link controller="quizQuestion">Beauty Quiz Questions</g:link></li>
					<li class="controller"><g:link controller="subscriptionPlan">Subscription plans</g:link></li>
					<li class="controller"><g:link controller="affiliate">Affiliates</g:link></li>
					<li class="controller"><g:link controller="discountVoucher">Vouchers</g:link></li>
					<li class="controller"><g:link controller="box">Box Management</g:link></li>
					<li class="controller"><g:link controller="subscribersBatch">Subscribers Batches</g:link></li>
					<li class="controller"><g:link controller="ad">Ads</g:link></li>
                </ul>
            </div>
			</sec:ifAllGranted>

			<sec:ifAllGranted roles="ROLE_OPS">
            <div id="controllerList" class="dialog">
                <h2>OPS</h2>
                <ul>
                    <li class="controller"><g:link controller="customer">Customer Management</g:link><g:render template="/common/searchCustomerForm"/></li>
					<li class="controller"><g:link controller="shipmentBatch">Shipment Batches</g:link></li>
                    <li class="controller"><g:link controller="notification">Customer Notification</g:link></li>
					<li class="controller"><g:link controller="complimentaryOrder">Complimentary Orders</g:link></li>
					<li class="controller"><g:link controller="complimentarySubscription">Complimentary Subscriptions</g:link></li>
                </ul>
            </div>
			</sec:ifAllGranted>

			<sec:ifAllGranted roles="ROLE_ADMIN">
            <div id="AdminList" class="dialog">
                <h2>Admin Console</h2>
                <ul>
                    <li class="controller"><g:link controller="user" action="create">Create new user</g:link></li>
                    <li class="controller"><g:link controller="user" action="search">Search existing user</g:link></li>
                    <li class="controller"><g:link controller="role" action="create">Create new role</g:link></li>
                    <li class="controller"><g:link controller="role" action="search">Create existing role</g:link></li>
                </ul>
            </div>
            </sec:ifAllGranted>
        </div>
    </body>
</html>
