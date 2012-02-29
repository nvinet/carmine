databaseChangeLog = {


	changeSet(author: "nvinet (generated)", id: "1325846255810-1") {
		addColumn(tableName: "product") {
			column(name: "description", type: "varchar(255)")
		}
	}

	changeSet(author: "nvinet (generated)", id: "1325846255810-2") {
		sql("""
			update product set description = 'Natural cosmetics made from the famous grapes in the Bordeaux region based on solid science' where id = 1;
			update product set description = 'Fun, multi-use products presented to you in packaging that will have you converted in no time' where id = 2;
			update product set description = 'Award winning, luxurious aromatherapy based products free of harmfull elements' where id = 3;
			update product set description = 'Super effective nail repair system that will cure all your nails challenges in two weeks' where id = 4;
			update product set description = 'Glamorous products developed by an expert make-up artist who has had many celebrities for client' where id = 5;
			update product set description = 'This semi-permanent brow ink will allow you to draw in individual hairs to enhance and define your brows to perfection.' where id = 6;
			update product set description = 'This fun, versatile stick of colour comes from the make-up line of celebrity fashion and pop icon Nicola Roberts.' where id = 7;
			update product set description = 'The organic bath and body equivalent to champagne will leave you smelling delightful and feeling silky smooth from head to toe.' where id = 8;
			update product set description = 'Glamour will know no limits once you''re equipped with this revolutionary lipstick complete with a built-in light and mirror!' where id = 9;
			update product set description = 'Made by Scottish singing legend Lulu, this powerful anti-ageing cream will turn back the hands of time while you get a good night''s rest!' where id = 10;
			update product set description = 'Let the experts in brow and lash care define your brows to perfection using this ancient, painless hair removal technique.' where id = 11;
			update product set description = 'A professional make-up tool for blending, smudging and transforming your pretty peepers.' where id = 12;
			update product set description = 'A luxurious, nutrient-rich body wash made with organic pomegranate seed oil.' where id = 13;
			update product set description = 'A new BFF for anyone who wants to spend up to 50% less time with their hair dryer.' where id = 14;
			update product set description = 'L''équivalent bio, pour le bain et le corps, du champagne vous laissera un délicieux parfum, ainsi qu''une impression de douceur semblable à la soie, de la tête aux pieds.' where id = 15;
			update product set description = 'Le fameux Pain d’Alep®, ancêtre du savon de Marseille, utilise les vertus hydratantes de l’huile d’olive conjuguées à celles du laurier pour nettoyer tout en douceur.' where id = 16;
			update product set description = 'Dans le coffret de Décembre, découvrez le Démaquillant Intense Biokaliftin ou la Crème Visage Néroli Absolis' where id = 17;
			update product set description = 'Gagnant d''un prix, aromathérapie luxueuse ne contenant pas de produits nocifs' where id = 18;
			update product set description = 'Les lèvres sont repulpées, le volume est plus marqué et le dessin plus précis. Cela vous donne en quelque sorte l''illusion d''une chirurgie esthétique.' where id = 19;
			update product set description = 'A little pot of glittery eye colour that will put flashy necklaces and diamond-encrusted mobile phones to shame.' where id = 20;
			update product set description = 'The one-step regime to a flawless, radiant complexion that will transform even the most tired looking skin.' where id = 21;
			
		""")
	}

}
