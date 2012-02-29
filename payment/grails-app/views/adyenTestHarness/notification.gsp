<html>
	<head>
		<title>Test Adyen Notifications</title>
	</head>
	<body>
		<p>
			<h2>This page can be used for testing Adyen Notifications</h2>
		</p>
		<form name="adyen" action="${createLink(controller:'paymentNotification', action:'index')}" method="post">
			<p>
			Notification from Test or Live platform<br />
			<input type="radio" name="live"  value="true" />Live: true<br />
			<input type="radio" name="live"  value="false" />Live: false
			</p>
			<p>
			Notification for event:<br />
			<input type="radio" name="eventCode"  value="AUTHORISATION" />AUTHORISATION<br />
			<input type="radio" name="eventCode"  value="CANCELLATION" />CANCELLATION<br />
			<input type="radio" name="eventCode"  value="PENDING" />PENDING<br />		
			<input type="radio" name="eventCode"  value="REFUND" />REFUND<br />
			<input type="radio" name="eventCode"  value="CAPTURE" />CAPTURE<br />
			<input type="radio" name="eventCode"  value="DISPUTE" />DISPUTE<br />
			<input type="radio" name="eventCode"  value="REPORT_AVAILABLE" />REPORT_AVAILABLE<br />
			<input type="radio" name="eventCode"  value="RECURRING_CONTRACT" />RECURRING_CONTRACT<br />
			<input type="radio" name="eventCode"  value="UKNOWN" />UKNOWN
			</p>
			<p>	
			<i>Get the following data from the customer area.</i><br />
			<table border="0" cellpadding="0" cellspacing="0">
			<tr><td>amount (in minor units) </td><td><input type="text" name="amount" value="" /></td></tr>
			<tr><td>currency </td><td><input type="text" name="currency" value="" /></td></tr>
			<tr><td>pspReference </td><td><input type="text" name="pspReference" value="" /></td></tr>
			<tr><td>merchantReference </td><td><input type="text" name="merchantReference" value="" /></td></tr>
			<tr><td>merchantAccountCode </td><td><input type="text" name="merchantAccountCode" value="${merchantCode}" />
			</table>
			</p>
			<p>
			Event successful (for example: AUTHORISATION authorised or refused)<br/>
			<input type="radio" name="success"  value="true" />success: true<br />
			<input type="radio" name="success"  value="false" />success: false
			</p>
			<p>
			paymentMethod:<br />
			<input type="radio" name="paymentMethod"  value="visa" />visa<br />
			<input type="radio" name="paymentMethod"  value="mc" />mc<br />
			<input type="radio" name="paymentMethod"  value="amex" />amex<br />
			<input type="radio" name="paymentMethod"  value="maestrouk" />maestrouk<br />
			<input type="radio" name="paymentMethod"  value="solo" />solo<br />
			<input type="radio" name="paymentMethod"  value="laser" />laser<br />
			<input type="radio" name="paymentMethod"  value="elv" />elv<br />
			<input type="radio" name="paymentMethod"  value="ideal" />ideal<br />
			<input type="radio" name="paymentMethod"  value="directDebit_NL" />directDebit_NL<br />
			<input type="radio" name="paymentMethod"  value="bankTransfer_NL" />bankTransfer_NL<br />
			<input type="radio" name="paymentMethod"  value="bankTransfer_DE" />bankTransfer_DE<br />
			<input type="radio" name="paymentMethod"  value="paypal" />paypal<br />
			<input type="radio" name="paymentMethod"  value="wallie" />wallie<br />
			<input type="radio" name="paymentMethod"  value="sms" />sms<br />
			<input type="radio" name="paymentMethod"  value="ivr" />ivr<br />
			<input type="radio" name="paymentMethod"  value="ivrLandline" />ivrLandline<br />
			<input type="radio" name="paymentMethod"  value="ivrMobile" />ivrMobile
			</p>
			<p>
			<table border="0" cellpadding="0" cellspacing="0">
			<tr><td>originalReference </td><td><input type="text" name="originalReference" value="DoNotCare" /></td></tr>
			<tr><td>eventDate </td><td><input type="text" name="eventDate" value="DoNotCare" /></td></tr>
			<tr><td>operations </td><td><input type="text" name="operations" value="DoNotCare" /></td></tr>		
			<tr><td>reason </td><td><input type="text" name="reason" value="DoNotCare" /></td></tr>
			</table>
			</p>
			<input type="submit" value="Test" />
		</form>
	</body>
</html>
