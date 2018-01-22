INSERT INTO `animes` (`id`, `name`, `studio_id`, `director_id`, `air_date`)
    VALUES
	(1, 'Cowboy Bebop', 8, 1, '1998-04-03'),
	(2, 'Samurai Champloo', 10, 1, '2004-01-26'),
	(3, 'Neon Genesis Evangelion', 4, 3, '1995-10-04'),
	(4, 'JoJo\'s Bizarre Adventure', 3, 8, '2012-10-05'),
	(5, 'Evangelion 1.11: You Are [Not] Alone', 4, 3, '2007-09-01'),
	(6, 'One Piece', 7, 9, '1999-10-20'),
	(7, 'Dragon Ball Super', 7, 9, '2015-07-05'),
	(8, 'Mob Psycho 100', 9, 10, '2016-07-12');

INSERT INTO `directors` (`id`, `name`)
    VALUES
	(1, 'Shinichiro Watanabe'),
	(2, 'Hayao Miyazaki'),
	(3, 'Hideaki Anno'),
	(4, 'Yoshiyuki Tomino'),
	(5, 'Katsuhiro Otomo'),
	(6, 'Kimitoshi Chioka'),
	(7, 'Masaaki Yuasa'),
	(8, 'Yasuko Kobayashi'),
	(9, 'Tatsuya Nagamine'),
	(10, 'Yuzuru Tatchikawa'),
	(11, 'Shingo Natsume');

INSERT INTO `studios` (`id`, `name`)
    VALUES
	(1, 'Madhouse Inc.'),
	(2, 'A-1 Pictures'),
	(3, 'David Production'),
	(4, 'GAINAX'),
	(5, 'Trigger Inc.'),
	(6, 'Studio Ghibli'),
	(7, 'Toei Animation'),
	(8, 'Sunrise'),
	(9, 'Bones'),
	(10, 'Manglobe');

INSERT INTO `users` (`id`, `username`, `password`)
    VALUES
	(1, 'Zhoka', '086531z'),
	(2, 'Ogami', 'om18Lo');

INSERT INTO `roles` (`id`, `role`)
    VALUES
	(1, 'Admin'),
	(2, 'User');

INSERT INTO `user_role` (`user_id`, `role_id`)
    VALUES
	(1, 1),
	(2, 2);