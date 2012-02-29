package backoffice

import subscription.Box

class NotificationController {

    def boxService
    def notificationService

    def index = {
        [
                recentBoxes: boxService.boxesShippedToDate(session.country)
        ]
    }
    
    def notifyCustomersWithFailedPayment = {
        Box box = Box.read(params.boxId)
        notificationService.notifyFailedPaymentCustomers(box)
        
        flash.message = "Customer with failed payment have been successfully notified"
        
        redirect controller: "notification", action: 'index'
        
    }

    def notifyCustomersWithSuccessfulPayment = {
        Box box = Box.read(params.boxId)
        notificationService.notifySuccessPaymentCustomers(box)

        flash.message = "Customer with successful payment have been successfully notified"

        redirect controller: "notification", action: 'index'
    }
}
