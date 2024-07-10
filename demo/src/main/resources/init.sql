-- Inserir gêneros
INSERT INTO genres (name) VALUES
                              ('Drama'),
                              ('Comedy'),
                              ('Action'),
                              ('Sci-Fi'),
                              ('Horror');

-- Inserir mídias
INSERT INTO media (title, description, rating, price, year, content_rating, thumb_url, trailer_url, episodes, media_type, genre_id, casting) VALUES
('Stranger Things', 'Coisas, bagulhos e parafernalhas estranhas', 8.5, 19.99, 2016, 'PG-13', NULL, 'ZhOrok2asq21aEDe', 10, 'SERIES', (SELECT id FROM genres WHERE name = 'Drama'), NULL),
('Friends', 'A hilarious comedy show', 8.9, 9.99, 1994, 'PG', NULL, 'AbCdEfGhIjKlMnOp', 236, 'SERIES', (SELECT id FROM genres WHERE name = 'Comedy'), NULL),
('Avengers: Endgame', 'An action-packed thriller', 8.4, 24.99, 2019, 'PG-13', NULL, 'QrStUvWxYz012345', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Action'), NULL),
('Interstellar', 'A journey through space and time', 8.6, 19.99, 2014, 'PG-13', NULL, '67890abcdefg', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Sci-Fi'), NULL),
('The Conjuring', 'A terrifying horror movie', 7.5, 11.99, 2013, 'R', NULL, 'hijklmnopqrstuv', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Horror'), NULL),
('Game of Thrones', 'A magical fantasy series', 9.3, 29.99, 2011, 'TV-MA', NULL, 'gameofthronesurl', 73, 'SERIES', (SELECT id FROM genres WHERE name = 'Drama'), NULL),
('The Big Bang Theory', 'A lovely romantic comedy', 8.1, 9.99, 2007, 'PG', NULL, 'bigbangtheoryurl', 279, 'SERIES', (SELECT id FROM genres WHERE name = 'Comedy'), NULL),
('The Dark Knight', 'An epic superhero movie', 9.0, 24.99, 2008, 'PG-13', NULL, 'thedarkknighturl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Action'), NULL),
('Blade Runner 2049', 'A sci-fi movie about a dystopian future', 8.0, 15.99, 2017, 'R', NULL, 'bladerunner2049url', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Sci-Fi'), NULL),
('A Quiet Place', 'A spine-chilling horror movie', 7.5, 12.99, 2018, 'PG-13', NULL, 'aquietplaceurl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Horror'), NULL),
('Breaking Bad', 'A high school chemistry teacher turned methamphetamine producer', 9.5, 19.99, 2008, 'TV-MA', NULL, 'breakingbadurl', 62, 'SERIES', (SELECT id FROM genres WHERE name = 'Drama'), NULL),
('The Office', 'A mockumentary on a group of typical office workers', 8.9, 9.99, 2005, 'PG', NULL, 'theofficeurl', 201, 'SERIES', (SELECT id FROM genres WHERE name = 'Comedy'), NULL),
('Mad Max: Fury Road', 'In a post-apocalyptic wasteland, a woman rebels against a tyrannical ruler', 8.1, 14.99, 2015, 'R', NULL, 'madmaxurl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Action'), NULL),
('The Matrix', 'A computer hacker learns from mysterious rebels about the true nature of his reality', 8.7, 19.99, 1999, 'R', NULL, 'thematrixurl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Sci-Fi'), NULL),
('It', 'In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster', 7.3, 11.99, 2017, 'R', NULL, 'iturl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Horror'), NULL),
('The Crown', 'Follows the political rivalries and romance of Queen Elizabeth II', 8.6, 19.99, 2016, 'TV-MA', NULL, 'thecrownurl', 40, 'SERIES', (SELECT id FROM genres WHERE name = 'Drama'), NULL),
('Parks and Recreation', 'The absurd antics of an Indiana town\'s public officials as they pursue various projects', 8.6, 9.99, 2009, 'PG', NULL, 'parksandrecurl', 125, 'SERIES', (SELECT id FROM genres WHERE name = 'Comedy'), NULL),
('Gladiator', 'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family', 8.5, 14.99, 2000, 'R', NULL, 'gladiatorurl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Action'), NULL),
('Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology', 8.8, 19.99, 2010, 'PG-13', NULL, 'inceptionurl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Sci-Fi'), NULL),
('The Exorcist', 'When a young girl is possessed by a mysterious entity, her mother seeks the help of two priests', 8.0, 12.99, 1973, 'R', NULL, 'theexorcisturl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Horror'), NULL),
('The Sopranos', 'New Jersey mob boss Tony Soprano deals with personal and professional issues in his home and business life', 9.2, 19.99, 1999, 'TV-MA', NULL, 'thesopranosurl', 86, 'SERIES', (SELECT id FROM genres WHERE name = 'Drama'), NULL),
('Brooklyn Nine-Nine', 'Jake Peralta, a talented but immature NYPD detective in Brooklyn\'s 99th Precinct', 8.4, 9.99, 2013, 'PG', NULL, 'brooklyn99url', 153, 'SERIES', (SELECT id FROM genres WHERE name = 'Comedy'), NULL),
('John Wick', 'An ex-hit-man comes out of retirement to track down the gangsters that killed his dog and took everything from him', 7.4, 14.99, 2014, 'R', NULL, 'johnwickurl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Action'), NULL),
('Star Wars: The Last Jedi', 'The Star Wars saga continues', 7.0, 19.99, 2017, 'PG-13', NULL, 'lastjediurl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Sci-Fi'), NULL),
('Get Out', 'A young African-American visits his white girlfriend\'s parents for the weekend, where his simmering uneasiness about their reception of him eventually reaches a boiling point', 7.7, 12.99, 2017, 'R', NULL, 'getouturl', NULL, 'MOVIE', (SELECT id FROM genres WHERE name = 'Horror'), NULL);

-- Adicionar mais 25 registros conforme necessário
