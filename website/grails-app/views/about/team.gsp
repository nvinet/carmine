<!DOCTYPE html>
<html lang="en">
    <head>
        <title><g:message code="about.team.meta.title"/></title>
		<meta name="description" content="${g.message(code:'about.team.meta.desc')}">
		<meta name="layout" content="1Col"/>
    </head>
    <body>
        <content tag="subNav">
            <nav id="accountSubNav" class="headerSubNav">
                <span class="arrow" style="right:285px"><r:img dir="/images/icons/headerArrowTop.png"/></span>
                <ul class="clearfix" id="myCarmineMenu">
                    <li><vh:localisedLink mapping="us"><g:message code="about.us.title"/></vh:localisedLink></li>
                    <li class="selected"><vh:localisedLink mapping="team"><g:message code="about.team.title"/></vh:localisedLink></li>
                    <li class="last"><vh:localisedLink mapping="jobs"><g:message code="about.job.title"/></vh:localisedLink></li>
                </ul>
            </nav>
        </content>

        <content tag="content">

            <div id="meetTheTeam">
                <h1><g:message code="about.team.title"/></h1>
				<%
					def team = ['whole-team','anais','clement','dan','emma','florentine','jenni','lauren','michiel','nic','olivier','roxanne','sarah', 'emeline', 'ben']
				%>
				<section class="col-1">
					<section id="teamPhotos">
						<section id="selectedMemberPhoto"><!-- placeholder --></section>
						<section id="teamThumbnails">
							<ul class="noBullet">
								<g:each in="${team}" var="name">
									<li class="left"><g:render template="memberThumbnail" model="[id:name]"/></li>
								</g:each>
							</ul>
						</section>
					</section>
				</section>


				<section class="content col-2">
					<section id="selectedMemberDetails" class="memberDetails"><!-- placeholder --></section>
					<section id="hiddenMemberDetails" style="display:none;">
						<g:each in="${team}" var="name">
							<g:render template="memberDetails" model="[name: name]" />
						</g:each>
					</section>

					<script>
						$(function() {
							$('.memberThumb').click(function() {
								var memberId = $(this).data('memberid')
								showTeamMember(memberId)
								highlightTeamMemberThumbnail($(this))
							})

							// select default member to show
							$('#whole-team-thumb').click()
						})

						function highlightTeamMemberThumbnail(thumbToHighlight) {
							var superQuickly = 1
							var fadedOut = 0.3
							var fullyVisible = 1.0
							// clear previously highlighted
							$('.memberThumb').fadeTo(superQuickly, fadedOut)
							// highlight currently selected
							thumbToHighlight.fadeTo(superQuickly, fullyVisible)
						}

						function showTeamMember(memberId) {
							var memberDetailsToShow = $('#hiddenMemberDetails #'+memberId).html()
							var memberFullSizedPhoto = $('#hiddenMemberDetails #'+memberId+' .memberFullSizedPhoto').html()
							$('#selectedMemberDetails').html(memberDetailsToShow)
							$('#selectedMemberPhoto').html(memberFullSizedPhoto)
						}
					</script>
				</section>
			</div>
        </content>
    </body>
</html>