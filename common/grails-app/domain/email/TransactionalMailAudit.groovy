package email

class TransactionalMailAudit implements Serializable {

    private static final long serialVersionUID = 1;

    String email
    TransactionalEmailType type
    Date dateCreated

    static constraints = {
        email blank:false, email: true
        dateCreated nullable: false
    }

	static mapping = {
		version false
	}
}

enum TransactionalEmailType {
    reset_password,
    new_subscription,
	sender_new_gift,
	recipient_new_gift,
    account_creation,
    subscription_cancellation,
	refer_a_friend,
	gift_activation_notification,
	single_box_gift,
	subscription_referrer,
    recurrent_payment_failure,
    recurrent_payment_success,
    customer_free_box
}
