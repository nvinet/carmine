databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1316100721835-1") {
		sql("""
		INSERT INTO `quiz` VALUES (1,1,'Beauty Profile');

		INSERT INTO `quiz_question` VALUES (1,1,'Take an arm, take a leg but not my:',1,3),(2,1,'Favorite It girl:',1,8),(3,1,'What kind of perfume do you like?',1,12),(4,1,'I want to look:',1,16),(5,1,'Do you colour your hair?',1,18),(6,1,'If yes, do you colour your hair at home or at the salon?',1,21),(7,1,'What do you usually do?',1,24),(8,1,'Dark roots?',1,26),(9,1,'Why not?',1,31),(10,1,'You wish you could master the art of:',1,35),(11,1,'Shimmer Sparkle Shine',1,37),(12,1,'If yes, Would you wear acid green nail polish?',1,39),(13,1,'Do you feel naked without Mascara',1,41),(14,1,'I wish I could kidnap the makeup artist from:',1,48),(15,1,'Mad men - Who has the best beauty style?',1,51),(16,1,'Gossip Girl - Who has the best beauty style?',1,55),(17,1,'Pretty little liars - Who has the best beauty style?',1,60),(18,1,'90210 - Who has the best beauty style?',1,65),(19,1,'Glee - Who has the best beauty style?',1,70),(20,1,'Grey''s anatomy - Who has the best beauty style?',1,75),(21,1,'Come on, it''s a serious beauty quiz we''re doing here!',1,76),(22,1,'Magazines you like to read:',1,80),(23,1,'Favorite permanent trend:',1,87),(24,1,'Favorite retro look:',1,92),(25,1,'I would totally buy:',1,97),(26,1,'I could spend all my money on:',1,103),(27,1,'Celebrities tend to look best',1,106),(28,1,'Who had the better look?',1,108),(29,1,'Would you consider "weird" a compliment?',1,110),(30,1,'I''m dying to try:',1,115),(31,1,'When you''re shopping for moisturizer, you care most about:',1,119),(32,1,'Would you ever get Botox?',1,123),(33,1,'Which look would you rock off the catwalk?',1,127),(34,1,'How often do you blowdry your hair?',1,132),(35,1,'How many lipsticks do you own?',1,136),(36,1,'Where do you look for beauty inspiration?',1,140),(37,1,'Your dream mini-break:',1,144),(38,1,'Do you wear sunscreen?',1,147),(39,1,'Do you smoke?',1,151),(40,1,'I always travel with a hair dryer',1,153),(41,1,'I’d cause an international incident if they tried to confiscate my perfume at the airport.',1,155),(42,1,'I sleep in my makeup.',1,158),(43,1,'I wouldn’t answer the door if I wasn’t wearing makeup.',1,160),(44,1,'I check the label for parabens, artificial colors, etc. before I buy shampoo or lotion.',1,162),(45,1,'I use tanning beds.',1,164),(46,1,'I’m easily bored.',1,166),(47,1,'I like to mix up my own masks or body scrubs.',1,168),(48,1,'I would cancel a date if I woke up with a pimple.',1,170);

		INSERT INTO `quiz_answer` VALUES (1,1,30,'Lip balm',70,NULL,NULL,100,100,2,1,10,0),(2,1,NULL,'Red Lipstick',100,NULL,70,NULL,30,2,1,90,1),(3,1,100,'Purple Eyeliner',10,100,70,NULL,10,2,1,60,2),(4,1,NULL,'Curling',70,NULL,90,30,30,2,1,70,3),(5,1,30,'Pippa Middleton',100,10,NULL,NULL,70,3,2,70,0),(6,1,NULL,'Rose Huntington-Whiteley',NULL,30,90,NULL,NULL,3,2,100,1),(7,1,100,'Alexa Chung',NULL,100,70,NULL,NULL,3,2,70,2),(8,1,NULL,'Dionne Bromfeld',NULL,70,NULL,NULL,100,3,2,30,3),(9,1,NULL,'None of the above',NULL,NULL,NULL,NULL,NULL,3,2,NULL,4),(10,1,NULL,'Floral (notes like rose, gardenia and musk).',NULL,NULL,NULL,NULL,NULL,4,3,NULL,0),(11,1,NULL,'Woodsy (notes like leather, oakmoss and vetiver).',NULL,NULL,NULL,NULL,NULL,4,3,NULL,1),(12,1,NULL,'Exotic (notes like sandalwood, patchouli and jasmine).',NULL,NULL,NULL,NULL,NULL,4,3,NULL,2),(13,1,NULL,'Fresh (notes like marine, citrus and green).',NULL,NULL,NULL,NULL,NULL,4,3,NULL,3),(14,1,70,'Bombshell hot',NULL,NULL,90,NULL,30,5,4,100,0),(15,1,30,'Polished and sophisticated',100,30,NULL,NULL,NULL,5,4,70,1),(16,1,10,'Like I’m not wearing any makeup ',NULL,NULL,NULL,NULL,100,5,4,NULL,2),(17,1,100,'Unique/cool',10,100,NULL,NULL,30,5,4,70,3),(18,1,60,'Yes',NULL,NULL,NULL,30,NULL,6,5,90,0),(19,1,10,'No',NULL,NULL,NULL,80,NULL,9,5,30,1),(20,1,100,'I''m DIY',NULL,NULL,NULL,10,NULL,7,6,NULL,0),(21,1,30,'I go to the pros',NULL,NULL,NULL,70,NULL,7,6,80,1),(22,1,NULL,'Both',NULL,NULL,NULL,30,NULL,7,6,NULL,2),(23,1,100,'It’s always different: from chunky surfer highlights to fire engine red, I’ve tried it all',30,100,70,10,10,8,7,80,0),(24,1,60,'I like to stay close to my natural shade, so a few highlights or a glaze',70,30,NULL,NULL,NULL,8,7,NULL,1),(25,1,30,'I’ve found my ideal shade and just maintain it.',70,NULL,NULL,NULL,NULL,8,7,NULL,2),(26,1,NULL,'Frumpy',100,NULL,NULL,NULL,70,10,8,NULL,0),(27,1,NULL,'Cool',30,100,70,NULL,NULL,10,8,NULL,1),(28,1,20,'I love my natural colour',NULL,NULL,NULL,NULL,100,10,9,NULL,0),(29,1,NULL,'I can’t deal with the maintenance',40,NULL,40,NULL,NULL,10,9,10,1),(30,1,30,'I’m afraid it won’t look natural',80,30,60,NULL,100,10,9,NULL,2),(31,1,30,'I don''t want to damage my hair',NULL,40,40,100,70,10,9,NULL,3),(32,1,NULL,'Let''s just say I had a bad experience',NULL,NULL,NULL,NULL,NULL,10,9,NULL,4),(33,1,NULL,'The perfectly painted winged liquid line',100,NULL,70,NULL,30,11,10,70,0),(34,1,70,'Applying false eye-lashes',70,60,90,NULL,10,11,10,100,1),(35,1,NULL,'The at-home facial',NULL,NULL,30,70,100,11,10,NULL,2),(36,1,70,'Making bedhead look incidental',20,80,NULL,70,70,11,10,70,3),(37,1,70,'Love',NULL,80,80,NULL,NULL,12,11,NULL,0),(38,1,30,'No way!',80,NULL,NULL,NULL,80,13,11,NULL,1),(39,1,100,'Totally',10,100,40,NULL,10,13,12,NULL,0),(40,1,40,'Forget it',70,NULL,NULL,NULL,70,13,12,NULL,1),(41,1,NULL,'Yes',80,70,90,NULL,60,14,13,NULL,0),(42,1,NULL,'No',10,10,10,NULL,100,14,13,10,1),(43,1,NULL,'Mad men',NULL,NULL,NULL,NULL,NULL,15,14,NULL,0),(44,1,NULL,'Gossip girl',NULL,NULL,NULL,NULL,NULL,16,14,NULL,1),(45,1,NULL,'Pretty little liars',NULL,NULL,NULL,NULL,NULL,17,14,NULL,2),(46,1,NULL,'90210',NULL,NULL,NULL,NULL,NULL,18,14,NULL,3),(47,1,NULL,'Glee',NULL,NULL,NULL,NULL,NULL,19,14,NULL,4),(48,1,NULL,'Grey''s anatomy',NULL,NULL,NULL,NULL,NULL,20,14,NULL,5),(49,1,NULL,'The Simpsons',NULL,NULL,NULL,NULL,NULL,21,14,NULL,6),(50,1,60,'Joan',60,NULL,90,NULL,30,22,15,90,0),(51,1,40,'Peggy',NULL,NULL,30,NULL,90,22,15,40,1),(52,1,NULL,'Betty',100,40,70,NULL,NULL,22,15,70,2),(53,1,NULL,'Serena',NULL,NULL,80,NULL,60,22,16,70,0),(54,1,NULL,'Blair',80,40,60,NULL,60,22,16,NULL,1),(55,1,NULL,'Jenny',40,80,60,NULL,30,22,16,NULL,2),(56,1,60,'Vanessa',NULL,60,NULL,NULL,60,22,16,40,3),(57,1,NULL,'Spencer',NULL,NULL,NULL,NULL,60,22,17,NULL,0),(58,1,NULL,'Ashley',NULL,NULL,70,NULL,NULL,22,17,60,1),(59,1,60,'Aria',NULL,80,60,NULL,NULL,22,17,NULL,2),(60,1,NULL,'Alison',NULL,NULL,70,NULL,NULL,22,17,60,3),(61,1,NULL,'Emily',60,NULL,NULL,NULL,70,22,17,40,4),(62,1,NULL,'Ivy',NULL,60,NULL,NULL,70,22,18,30,0),(63,1,40,'Annie',60,NULL,NULL,NULL,60,22,18,40,1),(64,1,40,'Adrianna',70,NULL,NULL,NULL,NULL,22,18,NULL,2),(65,1,NULL,'Naomi',NULL,60,80,NULL,40,22,18,60,3),(66,1,70,'Silver',40,70,60,NULL,NULL,22,18,NULL,4),(67,1,30,'Rachel',60,40,40,NULL,70,22,19,30,0),(68,1,NULL,'Quinn',60,40,70,NULL,NULL,22,19,60,1),(69,1,NULL,'Sue',NULL,NULL,30,NULL,70,22,19,20,2),(70,1,NULL,'Santana',NULL,NULL,NULL,NULL,NULL,22,19,60,3),(71,1,NULL,'Brittany',60,NULL,NULL,NULL,70,22,19,40,4),(72,1,30,'Meredith',60,40,30,NULL,80,22,20,30,0),(73,1,NULL,'Cristina',NULL,70,40,NULL,60,22,20,40,1),(74,1,60,'Callie',NULL,60,70,NULL,30,22,20,60,2),(75,1,40,'Teddy',60,30,70,NULL,70,22,20,70,3),(76,1,60,'Lexi',70,40,60,NULL,60,22,20,NULL,4),(77,1,NULL,'OK, I will be serious',NULL,NULL,NULL,NULL,NULL,22,21,NULL,0),(78,1,NULL,'Vogue, Grazia',NULL,NULL,80,NULL,NULL,23,22,70,0),(79,1,20,'Psychologies, Red',NULL,20,40,NULL,70,23,22,30,1),(80,1,NULL,'Tatler, Harper''s Bazaar',80,40,60,NULL,NULL,23,22,70,2),(81,1,90,'Love, ID',20,90,NULL,NULL,NULL,23,22,60,3),(82,1,70,'Smoky eyes',40,70,70,NULL,30,24,23,70,0),(83,1,80,'Black nail polish',30,90,60,NULL,40,24,23,70,1),(84,1,NULL,'Boho waves',NULL,60,60,NULL,70,24,23,NULL,2),(85,1,70,'Blunt fringe',60,60,NULL,NULL,NULL,24,23,NULL,3),(86,1,40,'Messy updo',60,NULL,70,NULL,NULL,24,23,60,4),(87,1,80,'Pixie cut',60,80,NULL,NULL,NULL,24,23,60,5),(88,1,20,'Sleek pony tail',90,30,60,NULL,60,24,23,40,6),(89,1,NULL,'50’s lady: Perfectly painted scarlet lips, matte skin',90,30,70,NULL,NULL,25,24,60,0),(90,1,60,'60’s bombshell: Big lashes, liquid liner, frosty lips',NULL,NULL,90,NULL,40,25,24,90,1),(91,1,NULL,'70’s California babe:  Nearly-naked skin, beachy hair',NULL,NULL,NULL,NULL,80,25,24,NULL,2),(92,1,10,'80’s preppie: Neat headbands…',90,20,30,NULL,80,25,24,30,3),(93,1,70,'90''s grunge',20,80,60,NULL,20,25,24,60,4),(94,1,NULL,'Sunscreen that doesn''t hurt my eyes',NULL,NULL,NULL,80,60,26,25,NULL,0),(95,1,NULL,'Battery operated flat iron',NULL,NULL,NULL,20,40,26,25,80,1),(96,1,NULL,'Lipstick that seriously won''t come off on my cup',70,NULL,60,NULL,NULL,26,25,NULL,2),(97,1,70,'Mood changing nail polish',30,70,NULL,NULL,40,26,25,NULL,3),(98,1,70,'Makeup you’re supposed to sleep in',30,70,NULL,NULL,40,26,25,NULL,4),(99,1,70,'Nars',NULL,80,70,NULL,NULL,27,26,NULL,0),(100,1,60,'Dior',60,60,80,NULL,NULL,27,26,NULL,1),(101,1,NULL,'Chanel',80,60,70,NULL,NULL,27,26,NULL,2),(102,1,40,'Origins',NULL,40,NULL,90,100,27,26,40,3),(103,1,90,'I prefer indie brands',30,100,NULL,NULL,NULL,27,26,60,4),(104,1,90,'Anything organic',30,100,NULL,NULL,NULL,27,26,60,5),(105,1,NULL,'On the red carpet',70,20,80,NULL,20,28,27,80,0),(106,1,70,'Off-duty, when they’re rocking their own style',30,100,20,NULL,80,29,27,40,1),(107,1,NULL,'Once they''re photo-shopped',NULL,NULL,NULL,NULL,NULL,28,27,NULL,2),(108,1,NULL,'Marylin Monroe',70,NULL,90,NULL,20,29,28,90,0),(109,1,NULL,'Jackie O',100,NULL,70,NULL,80,29,28,30,1),(110,1,NULL,'Yes',10,90,30,NULL,30,30,29,NULL,0),(111,1,10,'Um, not really',90,10,70,NULL,90,30,29,90,1),(112,1,90,'Fish pedicure',20,80,60,NULL,80,31,30,80,0),(113,1,80,'Lash extensions',70,NULL,90,NULL,10,31,30,100,1),(114,1,90,'Nail tattoos',20,90,70,NULL,10,31,30,80,2),(115,1,NULL,'Brazilian blowdry',70,NULL,100,40,30,31,30,60,3),(116,1,70,'Permanent hair removal',NULL,NULL,NULL,NULL,NULL,31,30,70,4),(117,1,40,'High-tech ingredients that promise dramatic results.',NULL,NULL,NULL,NULL,70,32,31,60,0),(118,1,20,'How it smells and feels on the skin.',NULL,NULL,NULL,NULL,90,32,31,60,1),(119,1,NULL,'How it looks on your dresser.',70,NULL,80,NULL,NULL,32,31,80,2),(120,1,NULL,'It’s organic and wasn’t tested on animals.',NULL,NULL,NULL,70,100,32,31,NULL,3),(121,1,40,'Never! (Ask me again in a few years).',NULL,NULL,NULL,NULL,70,33,32,60,0),(122,1,20,'Never! (Really). ',NULL,NULL,NULL,NULL,90,33,32,20,1),(123,1,80,'Probably. If I hate it, it’s not like the results are permanent.',NULL,NULL,NULL,NULL,30,33,32,70,2),(124,1,90,'I already do.',NULL,NULL,NULL,40,0,33,32,100,3),(125,1,NULL,'Pucci',NULL,90,NULL,NULL,NULL,34,33,NULL,0),(126,1,NULL,'Valentino',NULL,NULL,NULL,NULL,90,34,33,NULL,1),(127,1,NULL,'Placeholder',NULL,NULL,NULL,NULL,NULL,34,33,NULL,2),(128,1,NULL,'Ralph Lauren',90,NULL,NULL,NULL,NULL,34,33,NULL,3),(129,1,NULL,'Every morning, right before I flat iron it.',70,20,80,10,20,35,34,90,0),(130,1,NULL,'I get a blowout every Tuesday afternoon.',90,20,70,40,20,35,34,70,1),(131,1,90,'Crimped, curled or pin straight—it all depends on what I’m wearing. ',30,90,60,30,10,35,34,70,2),(132,1,20,'I just let it air-dry and do its thing',10,60,10,90,90,35,34,20,3),(133,1,NULL,'Rarely. I just put in some product and let it get textured and messy.',10,90,40,60,10,35,34,40,4),(134,1,90,'I have a whole drawer of shades I’m over. Want some? ',40,80,60,NULL,10,36,35,80,0),(135,1,60,'At least 10. I’m still searching for the perfect everyday color.',90,40,NULL,NULL,30,36,35,70,1),(136,1,40,'Lipstick freaks me out.',NULL,60,NULL,NULL,90,36,35,NULL,2),(137,1,30,'I’m more of a gloss girl.',NULL,NULL,NULL,NULL,60,36,35,40,3),(138,1,40,'Red carpet',70,20,80,NULL,30,37,36,90,0),(139,1,90,'Runway',NULL,80,70,NULL,20,37,36,70,1),(140,1,NULL,'Classic films',90,NULL,70,NULL,NULL,37,36,80,2),(141,1,60,'Street',20,90,30,NULL,NULL,37,36,20,3),(142,1,NULL,'Shopping week-end in Paris',80,NULL,70,NULL,NULL,38,37,NULL,0),(143,1,NULL,'Camping at Glastonbury',40,90,20,NULL,70,38,37,NULL,1),(144,1,NULL,'Head-to-toe treatments at a luxury spa',70,20,80,60,60,38,37,NULL,2),(145,1,NULL,'Silent organic detox eco cruelty-free yoga retreat (What? This is my dream).',NULL,NULL,NULL,60,90,38,37,NULL,3),(146,1,NULL,'Religiously, even in the winter',NULL,NULL,NULL,90,NULL,39,38,NULL,0),(147,1,NULL,'Only at the beach',NULL,NULL,NULL,40,NULL,39,38,NULL,1),(148,1,NULL,'Don''t you know that skin has to burn before it tans?',NULL,NULL,NULL,10,NULL,39,38,NULL,2),(149,1,NULL,'Yes. Now leave me alone.',NULL,NULL,NULL,10,NULL,40,39,NULL,0),(150,1,NULL,'Not anymore.',NULL,NULL,NULL,NULL,NULL,40,39,NULL,1),(151,1,NULL,'Only when I''m drunk.',NULL,NULL,NULL,30,NULL,40,39,NULL,2),(152,1,NULL,'Never have, never will.',NULL,NULL,NULL,90,NULL,40,39,NULL,3),(153,1,NULL,'TRUE',NULL,NULL,NULL,NULL,NULL,41,40,70,0),(154,1,NULL,'FALSE',NULL,NULL,NULL,NULL,80,41,40,30,1),(155,1,NULL,'TRUE',NULL,NULL,NULL,NULL,NULL,42,41,80,0),(156,1,NULL,'FALSE',NULL,NULL,NULL,NULL,NULL,42,41,NULL,1),(157,1,NULL,'Never',NULL,NULL,NULL,80,NULL,43,42,NULL,0),(158,1,NULL,'Sometimes',NULL,NULL,NULL,40,NULL,43,42,NULL,1),(159,1,NULL,'Often',NULL,NULL,NULL,20,NULL,43,42,NULL,2),(160,1,NULL,'TRUE',NULL,NULL,NULL,NULL,NULL,44,43,90,0),(161,1,NULL,'FALSE',NULL,NULL,NULL,NULL,NULL,44,43,NULL,1),(162,1,NULL,'TRUE',NULL,NULL,NULL,70,NULL,45,44,NULL,0),(163,1,NULL,'FALSE',NULL,NULL,NULL,NULL,NULL,45,44,NULL,1),(164,1,NULL,'TRUE',NULL,NULL,NULL,10,NULL,46,45,NULL,0),(165,1,NULL,'FALSE',NULL,NULL,NULL,NULL,NULL,46,45,NULL,1),(166,1,70,'TRUE',NULL,NULL,NULL,NULL,NULL,47,46,NULL,0),(167,1,30,'FALSE',NULL,NULL,NULL,NULL,NULL,47,46,NULL,1),(168,1,NULL,'TRUE',NULL,NULL,NULL,60,90,48,47,NULL,0),(169,1,NULL,'FALSE',NULL,NULL,NULL,NULL,NULL,48,47,NULL,1),(170,0,NULL,'TRUE',NULL,NULL,NULL,NULL,NULL,NULL,48,90,0),(171,0,NULL,'FALSE',NULL,NULL,NULL,NULL,NULL,NULL,48,NULL,1);
		""")
	}

}