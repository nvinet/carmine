package email

import grails.plugin.spock.UnitSpec
import common.ConfigService

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 04/11/11
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */
class MarketingMailServiceSpec extends UnitSpec {

	ChimpMailProxyService CMservice
	ConfigService configService
	MarketingMailService service

	def setup() {
		CMservice = Mock()
		configService = Mock()
		service = new MarketingMailService()
		service.chimpMailProxyService = CMservice
		service.configService = configService

		List.metaClass.partition = { size ->
			def rslt = delegate.inject( [ [] ] ) { ret, elem ->
				( ret.last() << elem ).size() >= size ? ret << [] : ret
			}
			if( rslt.last()?.size() == 0 ) rslt.pop()
			rslt
		}
	}

	def "Shoudl be able to updat ethe CRM subscriber liast"(){
		given: "I have a large list of items"
			def list = []
			1..100.each {
				list << it
			}
			def country = 'GB'

		when: "I send the list to the mailchimp service, it should be split and sent"
			configService.getConfigItem('mailChimp.subscriber', country)>>'123456'
			CMservice.batchSubscribe(list,'123456') >> true

		then: "the response should be true"
			assert service.updateSubscriberList(list,country)
	}
}
