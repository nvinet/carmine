databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "13155757578-1") {
		sql ("""
			ALTER TABLE `beauty_profile` DROP COLUMN `version` ;
			ALTER TABLE `beauty_profile_task` DROP COLUMN `version` ;
			ALTER TABLE `brand_vote` DROP COLUMN `version` ;
			ALTER TABLE `customer_address` DROP COLUMN `version` ;
			ALTER TABLE `gift` DROP COLUMN `version` ;
			ALTER TABLE `loyalty_point` DROP COLUMN `version` ;
			ALTER TABLE `marketing_mail_audit` DROP COLUMN `version` ;
			ALTER TABLE `payment` DROP COLUMN `version` ;
			ALTER TABLE `provider_payment_feedback` DROP COLUMN `version` ;
			ALTER TABLE `provider_payment_notification` DROP COLUMN `version` ;
			ALTER TABLE `quiz_participant_answer` DROP COLUMN `version` ;
			ALTER TABLE `referral` DROP COLUMN `version` ;
			ALTER TABLE `subscription` DROP COLUMN `version` ;
			ALTER TABLE `transactional_mail_audit` DROP COLUMN `version` ;
		""")
	}
}