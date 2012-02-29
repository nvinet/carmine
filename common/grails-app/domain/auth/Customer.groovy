package auth

import subscription.Subscription
import website.LoyaltyPoint
import website.Referral
import subscription.Gift
import website.BeautyProfile
import website.Country
import common.SingleBoxGift
import subscription.BoxOrder
import website.LoyaltyPointRedemption

class Customer implements Serializable {

	static searchable = true

	private static final long serialVersionUID = 1;

	/**
	 * @deprecated use {@link this.email}
	 */
	@Deprecated
    String username

	String firstName
	String lastName
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
	Customer referredBy
	String referralCode
	Date dateCreated
	Date lastUpdated
    boolean newsletterSubscriber
	String facebookUID
	FacebookInfo facebookInfo
	BeautyProfile beautyProfile
	Country country

	static hasMany = [loyaltyPoints: LoyaltyPoint, referrals: Referral, loyaltyPointRedemptions:LoyaltyPointRedemption]


    static constraints = {
        username blank:false, unique: true, email: true
        firstName blank:false
        lastName blank:false
        password blank: false
		referredBy nullable: true
        facebookInfo nullable:true
        facebookUID nullable: true, unique: true
		beautyProfile nullable: true, unique: true
		referralCode nullable: true
    }

    static mapping = {
        password column: '`password`'
        id generator:'common.ObfuscatedIdGenerator'
		version false
    }

	static transients = [
			'fullName',
			'authorities',
			'email',
			'subscribedToNewsletter',
			'currentSubscription',
			'eligibleForNewSubscription',
			'loyaltyPointsTotal',
			'expiredSubscriptions',
			'giftSubscriptionsPurchased',
			'singleBoxGiftsPurchased',
            'facebookUser',
			'fixLengthSubscription',
            'allSubscriptionOrders'
	]

	String getEmail() {
		username
	}

	String getFullName() {
		"$firstName $lastName"
	}

    Set<Role> getAuthorities() {
        CustomerRole.findAllByCustomer(this).collect { it.role } as Set
    }

	boolean isEligibleForNewSubscription() {
		currentSubscription == null
	}

    boolean isFacebookUser(){
        facebookUID != null
    }

	def hasSameEmailAddress(String matchEmail) {
		return this.email.equalsIgnoreCase(matchEmail)
	}

	Subscription getCurrentSubscription() {
		//should only ever be one or zero current subscriptions per customer
		def subscriptions = Subscription.currentSubscriptionsForCustomer(this).list()
		return subscriptions ? subscriptions.first() : null
	}

	Integer getLoyaltyPointsTotal() {
		loyaltyPoints*.getValue()?.sum() as Integer ?: 0
	}

	List<Subscription> getExpiredSubscriptions() {
		Subscription.expiredSubscriptionsForCustomer(this).list()
	}
    
    List<BoxOrder> getAllSubscriptionOrders(){
        def set = expiredSubscriptions?.boxOrders
        if (currentSubscription){
            set += currentSubscription.boxOrders
        }
        set.flatten().sort { a,b -> b.dateCreated <=> a.dateCreated }
    }

	boolean hasExpiredSubscriptions() {
		!expiredSubscriptions.empty
	}

	boolean hasFixLengthSubscription(){
		currentSubscription && currentSubscription.fixedLength
	}

	List<Gift> getGiftSubscriptionsPurchased() {
		Gift.successfullyPaidForBy(this).list()
	}

	List<SingleBoxGift> getSingleBoxGiftsPurchased() {
		SingleBoxGift.successfullyPaidForBy(this).list()
	}

	boolean hasPurchasedGifts() { // gift subscriptions OR single box gifts
		!(giftSubscriptionsPurchased.empty && singleBoxGiftsPurchased.empty)
	}

    String toString(){
        return this.fullName
    }

}
