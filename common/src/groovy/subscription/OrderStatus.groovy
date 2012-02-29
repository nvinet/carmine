package subscription

enum OrderStatus {
	awaitingPreparation,
	inPreparation,
	shipped,
	received,
	lost,
	cancelled
}