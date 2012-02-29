package common

import subscription.BoxOrder
import subscription.Box

class ShipmentBatch {

	Date dateShipped
	Date dateCreated
	Date lastUpdated

	static hasMany = [boxOrders : BoxOrder]

	static constraints = {
		dateShipped nullable: true
	}

	static mapping = {
		version false
	}

	def markAsInPreparation() {
		boxOrders*.markAsInPreparation()
		this.save()
	}

	def markAsShipped() {
		dateShipped = new Date()
		boxOrders*.markAsShipped()
		this.save()
	}

	boolean hasBeenShipped() {
		dateShipped != null
	}
}
