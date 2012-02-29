package email

import groovyx.net.http.*
import static groovyx.net.http.ContentType.HTML
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class ChimpMailProxyService {

    static transactional = false

    def config = ConfigurationHolder.config

    def ping() {
        String error
        Boolean success = false
        withHttp(uri: config.mailChimp.apiUrl) {
            def html = get(path : config.mailChimp.path, query : [method:'ping',apikey: config.mailChimp.apiKey], contentType: HTML){ resp, html ->
                JSONObject content = JSON.parse(html.BODY.toString())
                if(content.containsKey('error')){
                    //TODO log error
                    error = content.get('error')
                    success = false
                }
                else {
                    success = true
                }
            }
        }
        return success
    }

    def addSubscriberToList(String firstName, String lastName, String email, String listId){
        String error
        Boolean success = false
        withHttp(uri: config.mailChimp.apiUrl) {
            def html = post(path : config.mailChimp.path,
                    query : [method:'listSubscribe',
                            apikey: config.mailChimp.apiKey,
                            id: listId,
                            output:'json',
                            double_optin:false,
                            send_welcome: false,
                            email_address: email,
                            "merge_vars[FNAME]":firstName,
                            "merge_vars[LNAME]":lastName
                            ]
                    , contentType: HTML){ resp, html ->
                JSONObject content = JSON.parse(html.BODY.toString())
                if(content.containsKey('error')){
                   //TODO log error
                    error = content.get('error')
                    success = false
                }
                else{
                    success = true
                }
            }
        }

        return success

    }

    def removeSubscriberFromList(String email, String listId){
        String error
        Boolean success = false
        withHttp(uri: config.mailChimp.apiUrl) {
            def html = post(path : config.mailChimp.path,
                    query : [method:'listUnsubscribe',
                            apikey: config.mailChimp.apiKey,
                            id: listId,
                            output:'json',
                            email_address: email,
							send_goodbye: false,
							send_notify: false
                            ]
                    , contentType: HTML){ resp, html ->
                JSONObject content = JSON.parse(html.BODY.toString())
                if(content.containsKey('error')){
                    //TODO Log error
                    error = content.get('error')
                    success = false
                }
                else {
                    success = true
                }
            }
        }

        return success
    }

	def batchSubscribe(list, listId){
		String error
		boolean success = false

		def query = [
				method:'listBatchSubscribe',
				apikey: config.mailChimp.apiKey,
				id: listId,
				output:'json',
				double_optin:false,
				update_existing:true
		]

		def count = 0
		list.each {
			def batchItem = "batch[${count++}]"
			it.each { key, value ->
				query.("${batchItem}[$key]") = value
			}
		}

		withHttp(uri: config.mailChimp.apiUrl) {
			def html = post(
			path: config.mailChimp.path,
			query: query,
			contentType: HTML){ resp, html ->
				JSONObject content = JSON.parse(html.BODY.toString())
				if(content.containsKey('error')){
					//TODO Log error
					error = content.get('error')
					success = false
				}
				else {
					success = true
				}
			}
		}

		return success
	}
}
