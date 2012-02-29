databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1326454041803-1") {
		sql("""
			update gift set is_complimentary = false;
			update subscription set is_complimentary = false;

			update gift set is_complimentary = true where recipient_email in (
				'cerievans1@gmail.com',
				'mrslisataylor@sky.com',
				'jo@pimb.co.uk',
				'jaynebarrie@live.co.uk',
				'fennelseeds@live.co.uk',
				'jade_natasha@hotmail.com',
				'samcompg13@gmail.com',
				'katiepo1989@yahoo.co.uk',
				'samc200079@yahoo.co.uk');

				update subscription set is_complimentary = true where id in (
				  select activated_subscription_id from gift where recipient_email in (
				  'cerievans1@gmail.com',
				  'mrslisataylor@sky.com',
				  'jo@pimb.co.uk',
				  'jaynebarrie@live.co.uk',
				  'fennelseeds@live.co.uk',
				  'jade_natasha@hotmail.com',
				  'samcompg13@gmail.com',
				  'katiepo1989@yahoo.co.uk',
				  'samc200079@yahoo.co.uk')
				);

				update box_order set payment_type = 'complementary' where subscription_id in (
				  select activated_subscription_id from gift where recipient_email in (
				  'cerievans1@gmail.com',
				  'mrslisataylor@sky.com',
				  'jo@pimb.co.uk',
				  'jaynebarrie@live.co.uk',
				  'fennelseeds@live.co.uk',
				  'jade_natasha@hotmail.com',
				  'samcompg13@gmail.com',
				  'katiepo1989@yahoo.co.uk',
				  'samc200079@yahoo.co.uk')
				);
		""")
	}

	changeSet(author: "parker (manual)", id: "1326454041803-2") {
		addNotNullConstraint(columnDataType: "bit", columnName: "is_complimentary", tableName: "subscription")
	}

	changeSet(author: "parker (manual)", id: "1326454041803-3") {
		addNotNullConstraint(columnDataType: "bit", columnName: "is_complimentary", tableName: "gift")
	}
}