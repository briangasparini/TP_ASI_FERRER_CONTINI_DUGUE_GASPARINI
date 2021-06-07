

INSERT INTO public."user"(usr_user_id, name, wallet, login, password) VALUES
 (0, 'Bank', 999999999, 'admin', 'G@1ei*-84'),
 (nextval('userseq'), 'Dorian', 10000, 'Captain', 'lnjkn-541'),
 (nextval('userseq'), 'Brian', 1, 'LeConnard', 'lnjkn-541'),
 (nextval('userseq'), 'Enzo', 45000, 'LeCoach', 'lnjkn-541'),
 (nextval('userseq'), 'Hugo', 5000, 'LaLongueVue', 'lnjkn-541');

INSERT INTO card(id, name, description, img_url, hp, energy, attack, defense, prix, usr_user_id,family, affinity) VALUES
 (nextval('cardseq'), 'Pikachu', 'Pokemon celebre dans le monde entier, il est de type éclair et est très recherché parmi les collectionneurs', 'google.com/pika.gif', 200, 50, 46, 20, 50, 0, 0, 0),
 (nextval('cardseq'), 'Evoli', 'un Pokémon de type Normal de la première génération, qui a la faculté d évoluer différemment selon les circonstances. Il est d ailleurs le Pokémon avec le plus d évolutions possibles : huit au total.', 'google.com/evoli.gif', 400, 50, 81, 15, 100, 0, 2, 12),
 (nextval('cardseq'), 'Mewtwo', 'un Pokémon légendaire de type Psy de la première génération. C est également un Pokémon créé par l homme à partir de l ADN de Mew', 'google.com/mewtwo.gif', 100, 50, 29, 74, 20, 0, 1, 6),
 (nextval('cardseq'), 'Bulbizarre', 'un Pokémon de départ de type Plante et Poison de la première génération offert par le Professeur Chen dans la région de Kanto. Il est le premier Pokémon du Pokédex National et du Pokédex de Kanto.', 'google.com/bulbizarre.gif', 175, 50, 91, 35, 38, 2, 0, 7),
 (nextval('cardseq'), 'Dracaufeu', 'un Pokémon de type Feu et Vol de la première génération. On retrouve Dracaufeu sur les jaquettes des jeux Pokémon Rouge et Pokémon Rouge Feu.', 'google.com/dracaufeu.gif', 300, 50, 64, 48, 45, 0, 0, 5),
 (nextval('cardseq'), 'Salameche', ' le Pokémon de départ de type Feu offert par le Professeur Chen dans la région de Kanto et par le Professeur Platane dans la région de Kalos.', 'google.com/salameche.gif', 75, 50, 43, 20, 75, 0, 1, 4),
 (nextval('cardseq'), 'Ronflex', 'Pokémon pionceur, est un Pokémon extrêmement lourd de type Normal réputé pour ne faire que dormir et manger.', 'google.com/ronflex.gif', 99, 50, 81, 23, 80, 0, 0, 1),
 (nextval('cardseq'), 'Boustiflor', 'la première évolution de Chétiflor et un Pokémon de type Plante et Poison de la première génération.', 'google.com/boustiflor.gif', 328, 26, 61, 48, 10, 0, 1, 11),
 (nextval('cardseq'), 'Rondoudou', 'un petit Pokémon de type Normal de la première génération. Dans la sixième génération, ce Pokémon acquiert le second type Fée.', 'google.com/rondoudou.gif', 167, 50, 28, 62, 60, 0, 2, 10),
 (nextval('cardseq'), 'Doduo', 'Doduo est un Pokémon qui vit, à l état sauvage, dans les grandes plaines, où il peut courir à loisir. Ne pouvant pas voler, il a développé ses pattes pour échapper à ses ennemis', 'google.com/doduo.gif', 348, 50, 43, 38, 48, 0, 2, 17),
 (nextval('cardseq'), 'Aerodactyl', 'Pokémon préhistoriques qui n existent plus qu à l état de fossiles. Il est néanmoins possible de le faire revivre à partir d un Vieil Ambre contenant son ADN fossilisé', 'google.com/aerodactyl.gif', 397, 84, 29, 20, 30, 0, 1, 13),
 (nextval('cardseq'), 'Xatu', 'un Pokémon de type Psy et Vol de la deuxième génération et l évolution de Natu.', 'google.com/xatu.gif', 310, 18, 46, 47, 95, 0, 1, 9),
 (nextval('cardseq'), 'Mantine', 'Pokémon de type Eau et Vol apparu lors de la deuxième génération.', 'google.com/mantine.gif', 420, 47, 39, 16, 46, 0, 0, 2),
 (nextval('cardseq'), 'Slakoth', ' Pokémon de base de type Normal inspiré du paresseux et apparu dans la troisième génération', 'google.com/slakoth.gif', 318, 53, 24, 34, 26, 0, 2, 15),
 (nextval('cardseq'), 'Medicham', 'un Pokémon de type Combat et Psy apparu dans la troisième génération.', 'google.com/medicham.gif', 267, 81, 73, 51, 19, 0, 1, 16),
 (nextval('cardseq'), 'Torkoal', ' Pokémon de base de type Feu apparu dans la troisième génération.', 'google.com/torkal.gif', 149, 43, 81, 16, 46, 0, 0, 17),
 (nextval('cardseq'), 'Tropius', 'un Pokémon de type Plante et Vol apparu dans la troisième génération.', 'google.com/tropius.gif', 346, 42, 61, 84, 34, 0, 0, 8),
 (nextval('cardseq'), 'Groudon', 'Pokémon légendaire de type Sol de la troisième génération. C est le Pokémon emblématique de Pokémon Rubis et Pokémon Rubis Oméga.', 'google.com/groudon.gif', 168, 73, 27, 29, 78, 0, 0, 14),
 (nextval('cardseq'), 'Burmy', 'Pokémon de type Insecte de la quatrième génération.', 'google.com/burmy.gif', 281, 99, 99, 61, 42, 0, 1, 8),
 (nextval('cardseq'), 'Stunky', 'un Pokémon de type Poison et Ténèbres de la quatrième génération.', 'google.com/stunky.gif', 264, 76, 10, 84, 61, 0, 0, 4),
 (nextval('cardseq'), 'Rhyperior', 'un Pokémon de type Sol et Roche de la quatrième génération.', 'google.com/rhyperior.gif', 238, 13, 14, 31, 38, 0, 2, 3);
