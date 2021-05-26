INSERT INTO public."user"(usr_user_id, name, wallet, login, password) VALUES
 (0, 'Dorian', 100, 'dodoasticot', 'lnjkn-541');

INSERT INTO card(id, name, description, img_url, hp, energy, attack, defense, prix, usr_user_id,family, affinity) VALUES
 (0, 'Pikachu', 'Pokemon celebre dans le monde entier, il est de type éclair et est très recherché parmi les collectionneurs', 'google.com/pika.gif', 200, 50, 70, 20, 50, 0, 0, 0);
 
 INSERT INTO public.user_list_card(user_usr_user_id, list_card_id) VALUES 
 (0, 0);