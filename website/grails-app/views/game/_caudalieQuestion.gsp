<g:formRemote name="caudalieQuestion" url="[controller: 'game', action: 'submitParticipation']" update="question">
	<g:hiddenField name="gameId" value="1"/>
	<div>
		<p class="step">1</p>
		<g:if test="${participantCommand?.errors?.hasFieldErrors('answer')}">
			<p class="messageError">
				Please answer the question
			</p>
		</g:if>
		<p class="question">So, you think you know Caudalie like the back of your hand? Then tell us, which of the following ingredients is found in most of the brand's products:</p>
		<g:radioGroup name="answer" values="['Pineapple Extract', 'Grape-seed Polyphenols','French Algae']" labels="['Pineapple Extract', 'Grape-seed Polyphenols','French Algae']" value="${participantCommand?.answer}">
			<p class="answer">${it.radio} ${it.label}</p>
		</g:radioGroup>
	</div>
	<div>
		<p class="step">2</p>
		<p>Show us some love, how about a Like?</p>
		<p class="like"><r:img dir="/images/brands/m/caudalie.png"/> <span class="fb-like" data-href="http://www.facebook.com/pages/CAUDALIE/102099475153" data-layout="button_count" data-send="false" data-width="70" data-show-faces="false"></span></p>
		<p class="like"><r:img dir="/images/carmine-signature.png"/> <span class="fb-like" data-href="http://www.facebook.com/Carmine.UK" data-layout="button_count" data-send="false" data-width="70" data-show-faces="false"></span></p>
		<p style="display:none">Caudalie</p>
		<p class="like clearfix">
			<label>Share and give your friends a chance to win too!</label>
			<span class="fb-like" data-href="http://www.carmine.co.uk/misc/game/caudalie" data-layout="button_count" data-send="false" data-width="70" data-show-faces="false"></span>
		</p>
	</div>
	<div>
		<p class="step">3</p>
		<p>To enter the competition, we'll just need your email address</p>
		<br/>
		<g:if test="${participantCommand?.errors?.hasFieldErrors('email')}">
			<p class="messageError">
				Please provide valid email address
			</p>
		</g:if>
		<vh:textField command="${participantCommand}" name="email" id="gameEmail" class="emailField" />
		<p class="gameApprove clearfix"><g:checkBox id="gameApprove" name="contactMe" value="${participantCommand?.contactMe}"/> <label for="gameApprove">I love winning stuff. Tell me about more competitions like this one!</label></p>
		<p><g:submitButton name="submit" value="Submit »" class="submit" /></p>
	</div>
</g:formRemote>
