-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Sep 06, 2020 at 09:52 AM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `sofyan`
--

-- --------------------------------------------------------

--
-- Table structure for table `acteurs`
--

CREATE TABLE `acteurs` (
  `id` bigint(20) NOT NULL,
  `film1` varchar(255) DEFAULT NULL,
  `film2` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `acteurs`
--

INSERT INTO `acteurs` (`id`, `film1`, `film2`, `image`, `nom`) VALUES
(1, 'test1', 'test2', 'string', 'string'),
(2, 'Docteur Strange', '12 Years a Slave', 'benedict_cumberbatch.jpg', 'Benedict Cumberbatch'),
(3, 'Inglourious Basterds', 'Fight Club', 'brad_Pitt.jpg', 'Brad Pitt'),
(4, 'Drive', 'Breaking Bad', 'bryan_cranston.jpg', 'Bryan Cranston'),
(5, 'The Dark Knight, Le Chevalier Noir', 'Le Mans 66', 'christian-bale.jpg', 'Christian Bale'),
(6, 'Time out', 'Inception', 'cillian-murphy.jpeg', 'Cillian Murphy'),
(7, 'Harry Potter', 'Swiss Army Man', 'daniel-radcliffe.jpg', 'Daniel Radcliffe'),
(8, 'Jumanji : Bienvenue dans la jungle', 'San Andreas', 'dwayne_Johnson.jpg', 'Dwayne Johnson'),
(9, 'Le Labyrinthe', 'Teen Wolf', 'dylan-obrien.jpg', 'Dylan O Brien'),
(10, 'Indiana Jones', 'Star Wars', 'harisson_ford.jpg', 'Harrison Ford'),
(11, 'Candy', 'Le Secret de Brokeback Mountain', 'heath_ledger.jpg', 'Heath Ledger'),
(12, 'Shining', 'Vol au dessus d un nid de coucou', 'jack_Nicholson.jpg', 'Jack Nicholson'),
(13, 'Combats de maitre', 'Rush Hour', 'jackie-chan.jpg', 'Jackie Chan'),
(14, 'Spider-Man: Far From Home', 'Prisoners', 'jake_gyllenhaal.jpg', 'Jake Gyllenhaal'),
(15, 'X-Men', 'Split', 'james_McAvoy.jpg', 'James MCavoy'),
(16, 'Expendables', 'Fast & Furious 7', 'jason-Statham.jpg', 'Jason Statham'),
(17, 'Ace Ventura : detective chien et chat', 'The Truman Show', 'jim-Carrey.jpg', 'Jim Carrey'),
(18, 'Joker', 'Gladiator', 'joaquin-phoenix.png', 'Joaquin Phoenix'),
(19, 'Pirates des Caraibes', 'Charlie et la Chocolaterie', 'johnny-depp.jpg', 'Johnny Depp'),
(20, 'Matrix', 'John Wick', 'keanu_reeves.jpg', 'Keanu Reeves'),
(21, 'The Revenant', 'Titanic', 'leonardo_dicaprio.png', 'Leonardo DiCaprio'),
(22, 'La Grande Vadrouille', 'Les aventures de Rabbi Jacob', 'louis_defunes.jpg', 'Louis de Funes'),
(23, 'Interstellar', 'Le loup de Wall Street', 'matthew_mcconaughey.jpg', 'Matthew McConauguey'),
(24, 'La chute de la maison blanche', 'Million Dollar Baby', 'morgan-freeman.jpg', 'Morgan Freeman'),
(25, 'Le Parrain', 'Les Affranchis', 'robert_De_Niro.jpg', 'Robert De Niro'),
(26, 'Iron Man', 'Sherlock Holmes', 'robert_downeyjr.png', 'Robert Downey JR'),
(27, 'Jumanji', 'Madame Doubtfire', 'robin_Williams.jpg', 'Robin Williams'),
(28, 'Avengers', 'Pulp Fiction', 'samuelljackson.jpg', 'Samuel L Jackson'),
(29, 'Forrest Gump', 'Seul au monde', 'tom-hanks.jpg', 'Tom Hanks'),
(30, 'Venom', 'Peaky Blinders', 'tom-hardy.jpg', 'Tom Hardy'),
(31, 'Spider Man', 'The Impossible', 'tom_Holland.jpg', 'Tom Holland'),
(32, 'Men In Black', 'Je suis une legende', 'will_smith.jpg', 'Will Smith');

-- --------------------------------------------------------

--
-- Table structure for table `actrices`
--

CREATE TABLE `actrices` (
  `id` bigint(20) NOT NULL,
  `film1` varchar(255) DEFAULT NULL,
  `film2` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actrices`
--

INSERT INTO `actrices` (`id`, `film1`, `film2`, `image`, `nom`) VALUES
(1, 'Premier contact', 'Il était une fois', 'amy_Adams.jpg', 'Amy Adams'),
(2, 'Mr et Mrs Smith', 'Lara Croft', 'angelina-Jolie.jpg', 'Angelina Jolie'),
(3, 'Interstellar', 'Alice au pays des merveilles', 'anne-hathaway.png', 'Anne Hathaway'),
(4, 'Captain Marvel', 'Room', 'brie-larson.jpg', 'Brie Larson'),
(5, 'The Mask', 'Mary à tout prix', 'cameron-diaz.jpg', 'Cameron Diaz'),
(6, 'Star Wars', 'Bons baisers d Hollywood', 'carrie-Fisher.jpg', 'Carrie Fisher'),
(7, 'Scandale', 'Mad Max : Fury Road', 'charlize-theron.jpg', 'Charlize Theron'),
(8, 'Kick-Ass', 'Si je reste', 'chloe-grace-moretz.jpg', 'Chloe Grace Moretz'),
(9, 'Solo : A Star Wars Story', 'Last Christmas', 'emilia-clarke.jpg', 'Emilia Clarke'),
(10, 'Harry Potter', 'Noé', 'emma-Watson.jpg', 'Emma Watson'),
(11, 'La La Land', 'The Amazing Spider-Man', 'emma_Stone.jpg', 'Emma Stone'),
(12, '300', 'Miss Peregrine et les enfants particuliers', 'evagreen.jpg', 'Eva Green'),
(13, 'Wonder Woman', 'Justice League', 'gal-gadot.png', 'Gal Gadot'),
(14, 'Harry Potter', 'Cendrillon', 'helena_Bonham_Carter.jpg', 'Helena Bonham Carter'),
(15, 'Friends', 'Polly et moi', 'jennifer-aniston.jpg', 'Jennifer Aniston'),
(16, 'Hunger Games', 'Red Sparrow', 'jennifer_Lawrence.jpg', 'Jennifer Lawrence'),
(17, 'American Horror Story', 'Je te promets', 'jessica-Lange.jpg', 'Jessica Lange'),
(18, 'Pretty Woman', 'Coup de foudre à Notting Hill', 'julia-roberts.jpg', 'Julia Roberts'),
(19, 'Pirates des Caraibes', 'Love Actually', 'keira-knightley.jpg', 'Keira Knightley'),
(20, 'Suicide Squad', 'Moi, Tonya', 'margot-robbie.png', 'Margot Robbie'),
(21, 'Papa ou Maman', 'La Tour Montparnasse Infernale', 'marina-fois.jpg', 'Marina Fois'),
(22, 'Inception', 'Les petits mouchoirs', 'marion-cotillard.jpg', 'Marion Cotillard'),
(23, 'Mamma Mia!', 'Le diable s’habille en prada', 'meryl-streep.jpg', 'Meryl Streep'),
(24, 'Stranger Things', 'Godzilla 2', 'millie-bobby-brown.jpg', 'Millie Bobby Brown'),
(25, 'Black Swan', 'Star Wars 3', 'natalie-portman.png', 'Natalie Portman'),
(26, 'Bird Box', 'Twelve Years a Slave', 'sarah-paulson.jpg', 'Sarah Paulson'),
(27, 'Avengers', 'Jojo Rabbit', 'scarlett-johansson.jpg', 'Scarlett Johansson'),
(28, 'X-Men : Dark Phoenix', 'Another Me', 'sophie_Turner.png', 'Sophie Turner'),
(29, 'Pulp Fiction', 'Kill Bill', 'uma-thurman.jpg', 'Uma Thurman'),
(30, 'Fences', 'Les veuves', 'viola-davis.jpg', 'Viola Davis'),
(31, 'Dracula', 'Beetlejuice', 'winona_Ryder.jpg', 'Winona Ryder'),
(32, 'The Greatest Showman', 'SpiderMan : Far From Home', 'zendaya.jpg', 'Zendaya');

-- --------------------------------------------------------

--
-- Table structure for table `avengers`
--

CREATE TABLE `avengers` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `acteur` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `avengers`
--

INSERT INTO `avengers` (`id`, `description`, `acteur`, `image`, `nom`) VALUES
(1, 'Costume permettant de changer sa taille et communiquer aux fourmis', 'Paul Rudd', 'antman.png', 'Ant Man'),
(2, 'Roi du Wakanda, sens, force et agilité accrues', 'Chadwick Boseman', 'black_panther.png', 'Black Panther'),
(3, 'Combattante au corps à corps', 'Scarlett Johansson', 'black_widow.png', 'Black Widow'),
(4, 'Condition physique amélioré', 'Chris Evans', 'captain_america.png', 'Captain America'),
(5, 'Force, vitesse, agilité, durabilité surhumaine, vol, absorbe et projette de l\'énergie', 'Brie Larson', 'marvel.png', 'Captain Marvel'),
(6, 'Magicien des sciences occultes', 'Benedict Cumberbatch', 'strange.jpg', 'Docteur Strange'),
(7, 'Lien télépathique avec son oiseau', 'Anthony Mackie', 'faucon.png', 'Faucon'),
(8, 'Equipe de supers héros', 'Star-Lord, Gamora, Groot, Rocket, Drax, Nébula', 'gardiens_galaxie.png', 'Gardiens de la Galaxie'),
(9, 'Maitre archer et tireur d’élite', 'Jeremy Renner', 'archer.png', 'HawKeye'),
(10, 'Génie', 'Mark Ruffalo', 'hulk.jpg', 'Hulk'),
(11, 'Inventeur de génie', 'Robert Downey JR', 'ironman.png', 'Iron Man'),
(12, 'Bras gauche cybernétique', 'Sebastian Stan', 'soldat_hiver.jpg', 'Le Soldat de l’Hiver'),
(13, 'Capacités magiques scientifiquement améliorées', 'Elizabeth Olsen', 'sorciere_rouge.jpg', 'Sorcière Rouge'),
(14, 'Doté des pouvoirs d’araignées.', 'Tom Holland', 'spiderman.png', 'Spider Man'),
(15, 'Dieu du tonerre', 'Chris Hemsworth', 'thor.png', 'Thor'),
(16, 'Android, mélange de JARVIS (IA de Stark) et de la Pierre de l’Esprit', 'Paul Bettany', 'vision.jpg', 'Vision');

-- --------------------------------------------------------

--
-- Table structure for table `chansons`
--

CREATE TABLE `chansons` (
  `id` bigint(20) NOT NULL,
  `musique` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `dessinsanimes`
--

CREATE TABLE `dessinsanimes` (
  `id` bigint(20) NOT NULL,
  `annee` varchar(255) DEFAULT NULL,
  `gentil` varchar(255) DEFAULT NULL,
  `mechant` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

CREATE TABLE `films` (
  `id` bigint(20) NOT NULL,
  `acteur1` varchar(255) DEFAULT NULL,
  `acteur2` varchar(255) DEFAULT NULL,
  `annee` varchar(255) DEFAULT NULL,
  `synopsis` varchar(1023) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`id`, `acteur1`, `acteur2`, `annee`, `synopsis`, `image`, `nom`) VALUES
(1, 'Sam Worthington', 'Zoe Saldana', '2009', 'Malgré sa paralysie, Jake Sully, un ancien marine immobilisé dans un fauteuil roulant, est resté un combattant au plus profond de son être. Il est recruté pour se rendre à des années-lumière de la Terre, sur Pandora, où de puissants groupes industriels exploitent un minerai rarissime destiné à résoudre la crise énergétique sur Terre.', 'avatar.jpg', 'AVATAR'),
(2, 'Robert Downey JR', 'Chris Evans', '2018', 'Alors que les Avengers et leurs alliés ont continué de protéger le monde face à des menaces bien trop grandes pour être combattues par un héros seul, un nouveau danger est venu de l\'espace : Thanos. Despote craint dans tout l\'univers, Thanos a pour objectif de recueillir les six Pierres d\'Infinité, des artefacts parmi les plus puissants de l\'univers, et de les utiliser afin d\'imposer sa volonté sur toute la réalité. Tous les combats que les Avengers ont menés culminent dans cette bataille.', 'avengers.png', 'AVENGERS INFINITY WAR'),
(3, 'Christian Bale', 'Michael Caine', '2008', 'Batman est plus que jamais déterminé à éradiquer le crime organisé qui sème la terreur en ville. Epaulé par le lieutenant Jim Gordon et par le procureur de Gotham City, Harvey Dent, Batman voit son champ d\'action s\'élargir. La collaboration des trois hommes s\'avère très efficace et ne tarde pas à porter ses fruits jusqu\'à ce qu\'un criminel redoutable vienne plonger la ville de Gotham City dans le chaos.', 'batman.png', 'BATMAN THE DARK KNIGHT'),
(4, 'Ryan Reynolds', 'Morena Baccarin', '2016', 'Wade Wilson, un ancien militaire des forces spéciales, est devenu mercenaire. Après avoir subi une expérimentation hors-norme qui va accélérer ses pouvoirs de guérison, il va devenir Deadpool. Armé de ses nouvelles capacités et d\'un humour noir survolté, il va traquer l\'homme qui a bien failli anéantir sa vie.', 'deadpool.png', 'DEADPOOL'),
(5, 'Leonardo Di Caprio', 'Jamie Foxx', '2012', 'Un ancien esclave s\'associe avec un chasseur de primes d\'origine allemande qui l\'a libéré : il accepte de traquer avec lui des criminels recherchés. En échange, il l\'aidera à retrouver sa femme perdue depuis longtemps et esclave elle-aussi. Un western décoiffant.', 'django.jpg', 'DJANGO UNCHAINED'),
(6, 'Brad Pitt', 'Edward Norton', '1999', 'Jack est un jeune expert en assurance insomniaque, désillusionné par sa vie personnelle et professionnelle. Lorsque son médecin lui conseille de suivre une thérapie afin de relativiser son mal-être, il rencontre dans un groupe d\'entraide Marla avec qui il parvient à trouver un équilibre.', 'fight-club.jpg', 'FIGHT CLUB'),
(7, 'Tom Hanks', 'Gary Sinise', '1994', 'Au fil des différents interlocuteurs qui viennent s\'asseoir tour à tour à côté de lui sur un banc, Forrest Gump raconte la fabuleuse histoire de sa vie. Sa vie est à l\'image d\'une plume qui se laisse porter par le vent, tout comme Forrest se laisse porter par les événements qu\'il traverse dans l\'Amérique de la seconde moitié du 20e siècle.', 'forrest-gump.jpg', 'FORREST GUMP'),
(8, 'Clint Eastwood', 'Geraldine Hughes', '2008', 'Walt Kowalski, un vétéran de la guerre de Corée, vient de perdre sa femme. Seul, misanthrope, bougon et raciste, il veille jalousement sur sa Ford Gran Torino, râlant sans cesse contre les habitants de son quartier, en majorité d\'origine asiatique. Un jour, son jeune voisin, Tao, tente de lui voler sa voiture sous la pression d\'un gang. Walt s\'aperçoit bientôt que l\'adolescent est littéralement harcelé par les jeunes caïds. Prenant la défense de Tao, Walt devient malgré lui le héros du quartier.', 'gran-torino.jpg', 'GRAN TORINO'),
(9, 'Daniel Radcliffe', 'Emma Watson', '2011', 'Orphelin, le jeune Harry Potter peut enfin quitter ses tyranniques oncle et tante Dursley lorsqu\'un curieux messager lui révèle qu\'il est un sorcier. À 11 ans, Harry va enfin pouvoir intégrer la légendaire école de sorcellerie de Poudlard, y trouver une famille digne de ce nom et des amis, développer ses dons, et préparer son glorieux avenir.', 'harry-potter-1.jpg', 'HARRY POTTER A L\'ÉCOLE DES SORCIERS'),
(10, 'Daniel Radcliffe', 'Ralph Fiennes', '2011', 'Dans la 2e Partie de cet épisode final, le combat entre les puissances du bien et du mal de l\'univers des sorciers se transforme en guerre sans merci. Les enjeux n\'ont jamais été si considérables et personne n\'est en sécurité. Mais c\'est Harry Potter qui peut être appelé pour l\'ultime sacrifice alors que se rapproche l\'ultime épreuve de force avec Voldemort.', 'harry-potter-7.jpg', 'HARRY POTTER ET LES RELIQUES DE LA MORT 2ÈME PARTIE'),
(11, 'Leonardo Di Caprio', 'Marion Cotillard', '2010', 'Dom Cobb est un voleur expérimenté dans l\'art périlleux de `l\'extraction\' : sa spécialité consiste à s\'approprier les secrets les plus précieux d\'un individu, enfouis au plus profond de son subconscient, pendant qu\'il rêve et que son esprit est particulièrement vulnérable. Très recherché pour ses talents dans l\'univers trouble de l\'espionnage industriel, Cobb est aussi devenu un fugitif traqué dans le monde entier. Cependant, une ultime mission pourrait lui permettre de retrouver sa vie d\'avant.', 'inception.jpg', 'INCEPTION'),
(12, 'Matthew McConaughey', 'Anne Hathaway', '2014', 'Dans un futur proche, la Terre est de moins en moins accueillante pour l\'humanité qui connaît une grave crise alimentaire. Le film raconte les aventures d\'un groupe d\'explorateurs qui utilise une faille récemment découverte dans l\'espace-temps afin de repousser les limites humaines et partir à la conquête des distances astronomiques dans un voyage interstellaire.', 'interstellar.jpg', 'INTERSTELLAR'),
(13, 'Jeff Goldblum', 'Laura Dern', '1993', 'Ne pas réveiller le chat qui dort, c\'est ce que le milliardaire John Hammond aurait dû se rappeler avant de se lancer dans le clonage de dinosaures. C\'est à partir d\'une goutte de sang absorbée par un moustique fossilisé que John Hammond et son équipe ont réussi à faire renaître une dizaine d\'espèces de dinosaures.', 'jurassic.jpg', 'JURASSIC PARK'),
(14, 'Taron Egerton', 'Colin Firth', '2015', 'Harry Hart est un agent spécial de \'Kingsman\', l\'élite très élégante du renseignement indépendant britannique. Alors que la société secrète recherche de nouvelles recrues, Hart s\'intéresse à Eggsy, un jeune homme effronté de la banlieue londonienne. Stupéfié par les talents de l\'espion en costumes trois pièces, le garçon accepte de subir l\'entraînement intensif réservé aux jeunes privilégiés qui rêvent de devenir agent secret.', 'kingsman.jpg', 'KINGSMAN SERVICES SECRETS'),
(15, 'Emma Stone', 'Ryan Gosling', '2016', 'Au coeur de Los Angeles, une actrice en devenir prénommée Mia sert des cafés entre des auditions. De son côté, Sebastian, passionné de jazz, joue du piano dans des clubs miteux pour assurer sa subsistance. Tous deux sont bien loin de la vie rêvée à laquelle ils aspirent, mais ils développent des sentiments amoureux l\'un pour l\'autre.', 'la-la-land.jpg', 'LA LA LAND'),
(16, 'Tom Hanks', 'Michael Clarke Duncan', '1999', 'Paul Edgecomb, pensionnaire centenaire d\'une maison de retraite, est hanté par ses souvenirs. Gardien-chef du pénitencier de Cold Mountain, en 1935, en Louisiane, il était chargé de veiller au bon déroulement des exécutions capitales au bloc E (la ligne verte) en s\'efforçant d\'adoucir les derniers moments des condamnés. Parmi eux se trouvait un colosse du nom de John Coffey, accusé du viol et du meurtre de deux fillettes.', 'la-ligne-verte.png', 'LA LIGNE VERTE'),
(17, 'Takuya Kimura', 'Emily Mortimer', '2004', 'Sophie, une orpheline de 18 ans, travaille dur dans la boutique de chapelier que lui a laissée son père. Un jour, en ville, elle croise Hauru, un magicien très séduisant mais faible de caractère. Une sorcière, se méprenant sur leurs sentiments, change Sophie en une vieille femme de 90 ans. Désespérée, Sophie erre dans la campagne quand elle aperçoit un étrange château qui se déplace sur d\'immenses pattes.', 'le-chateau-ambulant.jpg', 'LE CHÂTEAU AMBULANT'),
(18, 'Matthew Broderick', 'Jeremy Irons', '1994', 'Le fils du roi des animaux vient de naître. Son oncle est jaloux car il aimerait lui aussi régner. Il invente une ruse qui aboutira sur la mort du roi. Le jeune fils, Simba, témoin de la mort de son père, et s\'en croyant responsable, va fuir sa horde.', 'le-roi-lion.png', 'LE ROI LION'),
(19, 'Elijah Wood', 'Viggo Mortensen', '2003', 'Les armées de Sauron ont attaqué `Minas Tirith\', la capitale de `Gondor\'. Jamais ce royaume autrefois puissant n\'a eu autant besoin de son roi. Cependant, Aragorn trouvera-t-il en lui la volonté d\'accomplir sa destinée ? Tandis que Gandalf s\'efforce de soutenir les forces brisées de Gondor, Théoden exhorte les guerriers de Rohan à se joindre au combat. Cependant, malgré leur courage et leur loyauté, les forces des Hommes ne sont pas de taille à lutter contre les innombrables légions d\'ennemis.', 'le-seigneur-des-anneaux.png', 'LE SEIGNEUR DES ANNEAUX LE RETOUR DU ROI'),
(20, 'Miyu Irino', 'Peng Yuchang', '2002', 'La petite Chihiro accompagne ses parents dans une promenade sylvestre qui doit les conduire vers leur nouvelle maison en banlieue. Alors qu\'elle prend un raccourci à travers un tunnel peu emprunté, la petite famille se retrouve soudain en territoire inconnu. Le temps de retrouver leur chemin, ils font une halte dans un gigantesque restaurant en plein air, totalement déserté.', 'le-voyage-de-chihiro.jpg', 'LE VOYAGE DE CHIHIRO'),
(21, 'Johnny Depp', 'Orlando Bloom', '2003', 'Petite, Elizabeth Swann, la fille du gouverneur, a sauvé de la noyade Will Turner après le naufrage de son bateau. Les années ont passé, Will et Elizabeth ont grandi. Will est devenu forgeron à Port Royal, et Elizabeth se prépare à épouser le commodore Norrington. Cependant, la vie d\'Elizabeth bascule lorsque le capitaine Barbossa et sa bande de pirates décident d\'attaquer Port Royal et la prennent en otage. Malheureusement pour lui, Barbossa a commis deux erreurs.', 'pirates-des-caraibes.png', 'PIRATES DES CARAÏBES LA MALÉDICTION DU BLACK PEARL'),
(22, 'Yōji Matsuda', 'Yuriko Ishida', '1997', 'Ashitaka, un jeune guerrier japonais, affronte un sanglier géant et furieux qui attaque son village. Il tue la bête, mais se retrouve atteint par un mal mystérieux. Sur le conseil des sages, il part vers l\'Ouest, à la recherche de ce qui a transformé l\'animal en démon. Au cours de son périple, il rencontre San, une jeune fille qui vit avec les loups. Ashitaka apprend que les humains sont à l\'origine de tous ces maux, car ils détruisent la forêt, qu\'ils exploitent pour alimenter leurs forges.', 'princesse-mononoke.jpg', 'PRINCESSE MONONOKÉ'),
(23, 'Uma Thurman', 'John Travolta', '1994', 'L\'odyssée sanglante et burlesque de petits malfrats dans la jungle de Hollywood à travers trois histoires qui s\'entremêlent. Dans un restaurant, un couple de jeunes braqueurs, Pumpkin et Yolanda, discutent des risques que comporte leur activité. Deux truands, Jules Winnfield et son ami Vincent Vega, qui revient d\'Amsterdam, ont pour mission de récupérer une mallette au contenu mystérieux et de la rapporter à Marsellus Wallace.', 'pulp-fiction.png', 'PULP FICTION'),
(24, 'Olivia Cooke', 'Tye Sheridan', '2018', 'En 2045, le monde est au bord du chaos. Les êtres humains se réfugient dans l\'OASIS, univers virtuel mis au point par le brillant et excentrique James Halliday. Avant de disparaître, celui-ci a décidé de léguer son immense fortune à quiconque découvrira l\'oeuf de Pâques numérique qu\'il a pris soin de dissimuler dans l\'OASIS. L\'appât du gain provoque une compétition planétaire.', 'ready-player-one.jpeg', 'READY PLAYER ONE'),
(25, 'Michael J.Fox', 'Christopher Lloyd', '1985', 'Le jeune Marty McFly mène une existence anonyme, auprès de sa petite amie Jennifer, seulement troublée par sa famille en crise et un proviseur qui serait ravi de l\'expulser du lycée. Ami de l\'excentrique professeur Emmett Brown, il l\'accompagne tester sa nouvelle expérience : le voyage dans le temps via une DeLorean modifiée. La démonstration tourne mal : des trafiquants d\'armes débarquent et assassinent le scientifique.', 'retour-vers-le-futur.png', 'RETOUR VERS LE FUTUR'),
(26, 'Jack Nicholson', 'Shelley Duvall', '1980', 'Jack Torrance, gardien d\'un hôtel fermé l\'hiver, sa femme et son fils Danny s\'apprêtent à vivre de longs mois de solitude. Danny, qui possède un don de médium, le Shining, est effrayé à l\'idée d\'habiter ce lieu, théâtre marqué par de terribles évènements passés...', 'shining.jpg', 'SHINING'),
(27, 'Leonardo Di Caprio', 'Mark Ruffalo', '2010', 'En 1954, une meurtrière, extrêmement dangereuse, placée en centre de détention psychiatrique disparaît sur l\'île de Shutter Island. Deux officiers du corps fédéral des marshals, Teddy Daniels et Chuck Aule, sont envoyés sur place pour enquêter. Très vite, Teddy Daniels comprend que le personnel de l\'établissement cache quelque chose. Seul indice dont il dispose : un bout de papier sur lequel est griffonnée une suite de chiffres entrecoupée de lettres.', 'shutter-island.jpg', 'SHUTTER ISLAND'),
(28, 'Hayden Christensen', 'Ewan McGregor', '2005', 'La Guerre des Clones fait rage. Une franche hostilité oppose désormais le Chancelier Palpatine au Conseil Jedi. Anakin Skywalker, jeune Chevalier Jedi pris entre deux feux, hésite sur la conduite à tenir. Séduit par la promesse d\'un pouvoir sans précédent, tenté par le côté obscur de la Force, il prête allégeance au maléfique Darth Sidious et devient Dark Vador.Les Seigneurs Sith s\'unissent alors pour préparer leur revanche, qui commence par l\'extermination des Jedi.', 'star-wars.png', 'STAR WARS LA REVANCHE DES SITH'),
(29, 'Jim Carrey', 'Laura Linney', '1998', 'Truman Burbank mène une vie calme et heureuse. Il habite dans un petit pavillon propret de la radieuse station balnéaire de Seahaven.', 'the-truman-show.png', 'THE TRUMAN SHOW'),
(30, 'Richard Darbois', 'Jean-Philippe Puymartin', '1996', 'Woody, le cow-boy à la démarche déhanchée, reste le jouet préféré d\'Andy, même si aujourd\'hui Buzz partage cette amitié. Toujours chef de bande, Woody protège et rassure tous les jouets de la chambre. Kidnappé par un collectionneur sans scrupules, Woody va découvrir qu\'il fut jadis une vraie star. Après maintes péripéties, il va être confronté à la décision la plus importante de sa vie : rentrer chez lui pour retrouver Andy et les jouets ou rester pour devenir une pièce rare de musée.', 'toy-story.jpg', 'TOY STORY'),
(31, 'J.K. Simmons', 'Miles Teller', '2014', 'Ambitieux et perfectionniste, Andrew, 19 ans, rêve de devenir le meilleur batteur de jazz de sa génération. Élève au conservatoire de Manhattan, il serait prêt à tout donner, comme beaucoup de ses camarades, pour intégrer le cours d\'orchestre de Terence Fletcher, professeur tyrannique célèbre pour son amour de la perfection musicale. Par chance, lors d\'une répétition, Fletcher remarque Andrew et son talent encore brut.', 'whiplash.jpg', 'WHIPLASH'),
(32, 'Taki Tachibana', 'Mitsuha Miyamizu', '2016', 'Mitsuha, adolescente coincée dans une famille traditionnelle, rêve de quitter ses montagnes natales pour découvrir la vie trépidante de Tokyo. Elle est loin d\'imaginer pouvoir vivre l\'aventure urbaine dans la peau de... Taki, un jeune lycéen vivant à Tokyo. À travers ses rêves, Mitsuha se voit littéralement propulsée dans la vie du jeune garçon. Quel mystère se cache derrière ces rêves étranges qui unissent deux destinées que tout oppose et qui ne se sont jamais rencontrées ?', 'your-name.jpg', 'YOUR NAME');

-- --------------------------------------------------------

--
-- Table structure for table `horreur`
--

CREATE TABLE `horreur` (
  `id` bigint(20) NOT NULL,
  `acteur1` varchar(255) DEFAULT NULL,
  `acteur2` varchar(255) DEFAULT NULL,
  `annee` varchar(255) DEFAULT NULL,
  `synopsis` varchar(1023) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `jeux`
--

CREATE TABLE `jeux` (
  `id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jeux`
--

INSERT INTO `jeux` (`id`, `image`, `nom`) VALUES
(1, 'assassins.jpg', 'Assassins Creeds'),
(2, 'bf.png', 'Battlefield'),
(3, 'cod.jpg', 'Call of Duty'),
(4, 'csgo.png', 'Counter-Strike'),
(5, 'dofus.png', 'Dofus'),
(6, 'fallout.png', 'Fallout'),
(7, 'fifa.jpg', 'Fifa'),
(8, 'final.png', 'Final Fantasy'),
(9, 'fortnite.png', 'Fortnite'),
(10, 'god.png', 'God Of War'),
(11, 'gta.png', 'GTA'),
(12, 'halo.png', 'Halo'),
(13, 'kingdom.png', 'Kingdom Hearts'),
(14, 'lol.png', 'League of Legends'),
(15, 'life.png', 'Life is Strange'),
(16, 'mario.jpg', 'Mario Kart'),
(17, 'minecraft.png', 'Minecraft'),
(18, 'overwatch.png', 'Overwatch'),
(19, 'pokemon.png', 'Pokemon'),
(20, 'portal.png', 'Portal'),
(21, 'r6.png', 'Rainbox Six'),
(22, 'read.jpeg', 'Red Dead Redemption'),
(23, 'rocket.png', 'Rocker League'),
(24, 'elder.png', 'Super Mario'),
(25, 'super.png', 'Super Smash Bros'),
(26, 'elder.png', 'The Elder Scrolls'),
(27, 'last.jpg', 'The Last of Us'),
(28, 'zelda.jpg', 'The Legend of Zelda'),
(29, 'witcher.png', 'The Witcher'),
(30, 'uncharted.png', 'Uncharted'),
(31, 'undertale.png', 'Undertale'),
(32, 'wow.jpeg', 'World of Warcraft');

-- --------------------------------------------------------

--
-- Table structure for table `mechants`
--

CREATE TABLE `mechants` (
  `id` bigint(20) NOT NULL,
  `ennemi` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mechants`
--

INSERT INTO `mechants` (`id`, `ennemi`, `image`, `nom`) VALUES
(1, 'Neo', 'agent-smith.jpg', 'AGENT SMITH'),
(2, 'Harry Potter', 'bellatrix-lestrange.png', 'BELLATRIX LESTRANGE'),
(3, '7 enfants', 'ca.jpg', 'ÇA'),
(4, 'Les non Lannister', 'cersei.jpg', 'CERSEI'),
(5, 'Les Jedis', 'dark-vador.jpeg', 'DARK VADOR'),
(6, 'Jack Sparrow', 'davy-jones.jpg', 'DAVY JONES'),
(7, 'Jonathan Joestar', 'dio.jpg', 'DIO'),
(8, 'Luffy', 'doflamingo.png', 'DOFLAMINGO'),
(9, 'Sangoku', 'freezer.png', 'FREEZER'),
(10, 'Frodon', 'gollum.jpg', 'GOLLUM'),
(11, 'Walter White', 'gus-fring.jpg', 'GUS FRING'),
(12, 'Maison Verger', 'hannibal-lecter.jpeg', 'HANNIBAL LECTER'),
(13, 'Aldo Raine', 'hans-landa.jpg', 'HANS LANDA'),
(14, 'Gon', 'hisoka.jpg', 'HISOKA'),
(15, 'Aladdin', 'jafar.jpg', 'JAFAR'),
(16, 'Allison Kerry', 'jigsaw.jpg', 'JIGSAW'),
(17, 'Sacha', 'la-team-rocket.jpg', 'LA TEAM ROCKET'),
(18, 'Batman', 'le-joker.png', 'LE JOKER'),
(19, 'L', 'light_yagami.jpg', 'LIGHT YAGAMI'),
(20, 'Naruto', 'madara.jpg', 'MADARA'),
(21, 'Le monde', 'magneto.jpg', 'MAGNÉTO'),
(22, 'Roi Stéphane', 'malefique.jpg', 'MALÉFIOUE'),
(23, 'Hunter', 'meruem.jpg', 'MERUEM'),
(24, 'Rick Grimes', 'negan.png', 'NEGAN'),
(25, 'Naruto', 'pain.png', 'PAIN'),
(26, 'Les Jedis', 'palpatine.jpg', 'PALPATINE'),
(27, 'Les Starks', 'ramsay-bolton.jpg', 'RAMSAY BOLTON'),
(28, 'Tous', 'sauron.jpg', 'SAURON'),
(29, 'Mufasa', 'scar.png', 'SCAR'),
(30, 'Michael Scofield', 't-bag.png', 'T-BAG'),
(31, 'Avengers', 'thanos.jpg', 'THANOS'),
(32, 'Harry Potter', 'voldemort.jpg', 'VOLDEMORT');

-- --------------------------------------------------------

--
-- Table structure for table `rappeurs`
--

CREATE TABLE `rappeurs` (
  `id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rappeurs`
--

INSERT INTO `rappeurs` (`id`, `image`, `nom`) VALUES
(1, 'alkpote.jpg', 'ALKPOTE'),
(2, 'alpha-wann.png', 'ALPHA WANN'),
(3, 'bigflo-oli.png', 'BIGFLO & OLI'),
(4, 'booba.jpg', 'BOOBA'),
(5, 'columbine.jpg', 'COLUMBINE'),
(6, 'damso.webp', 'DAMSO'),
(7, 'freeze-corleone.jpg', 'FREEZE CORLEONE'),
(8, 'guizmo.jpeg', 'GUIZMO'),
(9, 'hamza.jpg', 'HAMZA'),
(10, 'hugo-tsr.jpg', 'HUGO TSR'),
(11, 'iam.jpg', 'IAM'),
(12, 'jok-air.png', 'JOK\'AIR'),
(13, 'jul.jpg', 'JUL'),
(14, 'kaaris.jpg', 'KAARIS'),
(15, 'kery-james.jpg', 'KERY JAMES'),
(16, 'koba-lad.jpg', 'KOBA LAD'),
(17, 'lefa.jpg', 'LEFA'),
(18, 'lomepal.jpg', 'LOMEPAL'),
(19, 'lorenzo.jpg', 'LORENZO'),
(20, 'maitre-gims.jpg', 'MAÎTRE GIMS'),
(21, 'nekfeu.jpg', 'NEKFEU'),
(22, 'ninho.jpg', 'NINHO'),
(23, 'niska.png', 'NISKA'),
(24, 'ntm.png', 'NTM'),
(25, 'orelsan.jpg', 'ORELSAN'),
(26, 'plk.jpg', 'PLK'),
(27, 'pnl.jpg', 'PNL'),
(28, 'romeo-elvis.png', 'ROMÉO ELVIS'),
(29, 'sch.jpg', 'SCH'),
(30, 'sofiane.jpg', 'SOFIANE'),
(31, 'vald.jpg', 'VALD'),
(32, 'zola.jpg', 'ZOLA');

-- --------------------------------------------------------

--
-- Table structure for table `realisateur`
--

CREATE TABLE `realisateur` (
  `id` bigint(20) NOT NULL,
  `info1` varchar(255) DEFAULT NULL,
  `info2` varchar(255) DEFAULT NULL,
  `info3` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `saga`
--

CREATE TABLE `saga` (
  `id` bigint(20) NOT NULL,
  `nombrefilms` varchar(255) DEFAULT NULL,
  `contenu` varchar(2047) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saga`
--

INSERT INTO `saga` (`id`, `nombrefilms`, `contenu`, `image`, `nom`) VALUES
(1, '6', 'Dans le vide de l’espace, un groupe d’ouvriers fait un jour la rencontre d’une espèce extraterrestre inconnue, le xénomorphe. Celui-ci va peu à peu semer la mort dans leur vaisseau. Ellen Ripley va réussir à quitter le vaisseau, mais, d’épisode en épisode, réaliser que la créature et ses semblables la suivent où qu’elle aille et qu’elle ne peut échapper à son destin funeste.', 'alien.png', 'Alien'),
(2, '24', 'Pour contrecarrer les plans de super-vilains de plus en plus retords, qui veulent tantôt dominer le monde, tantôt le détruire, des super-héros venus de différents horizons décident de s’unir.', 'avengers.jpg', 'Avengers'),
(3, '8', 'Orphelin élevé par son oncle et sa tante, Harry Potter apprend à onze ans qu’il est en fait un magicien et que ses parents ont été tués par un puissant sorcier. Mais avant de faire toute la lumière sur la lumière sur la mort de ses parents, il va devoir apprendre les arcanes de la magie à l’école de Poudlard en compagnie de ses deux meilleurs amis Ron et Hermione.', 'harry-potter.jpg', 'Harry Potter'),
(4, '5', 'Archéologue, Indiana Jones est fasciné par les reliques mythologiques. En pleine seconde guerre mondiale, il va partir à la recherche de l’Arche de Noé, puis d’un temple indien, du Graal ou d’un crâne en cristal. Grâce à son bagout, sa maîtrise du fouet et ses connaissances il va tout faire pour trouver ces objets sacrés et les empêcher de tomber entre de mauvaises mains.', 'indiana-jones.jpg', 'Indiana Jones'),
(5, '5', 'Le milliardaire John Hammond possède une île, au large du Costa Rica, sur laquelle il a dépensé sans compter pour ouvrir un parc d’attraction d’un autre genre, dans lequel les visiteurs viendrait voir des dinosaures en chair et en os. Les choses vont vite dégénérer quand, après un problème électrique, les dinosaures vont s’échapper de leurs enclos et semer la terreur dans le parc.', 'jurassik-park.jpg', 'Jurassic Park'),
(6, '3', 'Dans un monde fantastique peuplé d’hommes, de nains, d’elfes et d’orcs, le seigneur du mal, Sauron, cherche à reprendre forme physique. Pour cela, il doit mettre la main sur son anneau de pouvoir, forgé des siècles auparavant. Un groupe d’habitants de la Terre du Milieu va tout faire pour détruire cet anneau, retrouvé il y a un siècle par un Hobbit, Bilbon Sacquet.', 'le-seigneur-des-anneaux.jpg', 'Le Seigneur des anneaux'),
(7, '4', 'Alors que le monde entier est en guerre, un policier, Max Rockatansky tente de faire régner l’ordre sur les routes, mais va perdre sa famille à cause des pirates de la route. Il va alors tout faire pour se venger, quitter la police et parcourir les routes à bord de sa voiture, la Pursuit Special, rencontrant différents groupes à travers le désert post-apocalyptique.', 'mad-max.jpg', 'Mad Max'),
(8, '3', 'Un beau jour, un jeune employé de bureau, Thomas Anderson, pirate informatique la nuit, est contacté par d’autres individus. Il va alors peu à peu réaliser que le monde dans lequel il vit n’est qu’une illusion, la Matrice, créée par des machines pour assouvir les humains, transformés en simples batteries. Éveillé, il va tout faire, dans le monde réel post-apocalyptique, pour mettre fin à l’empire des machines.', 'matrix.jpg', 'Matrix'),
(9, '3', 'Appartenant à une organisation chargée de surveiller les extraterrestres sur Terre, l’agent K recrute un policier du NYPD. Il devient l’agent J. Ensemble, et armés d’une ribambelle de gadgets futuristes, ils vont devoir contrôler et repousser les menaces aliens', 'men-In-Black.jpg', 'Men In Black'),
(10, '5', 'Le capitaine Jack Sparrow est un pirate sans vaisseau. Il va tout faire pour récupérer son navire, le Black Pearl, et naviguer sur les mers des Caraïbes à la recherche de reliques mystérieuses, affrontant fantômes, créatures mystérieuses et les effets désastreux du rhum', 'pirates-des-caraibes.jpg', 'Pirates des Caraibes'),
(11, '3', 'Jeune lycéen, Marty McFly est ami avec un scientifique fou, le Doc. Un jour, il va se retrouver embarqué dans les années 50, à l’époque où ses parents se sont rencontrés. Puis dans les années 2010, et enfin au XIXe siècle. À chaque fois, les deux compagnons vont tout faire pour retrouver leur année d’origine, 1985, en tâchant de ne pas modifier l’espace-temps.', 'retour-vers-le-futur.jpg', 'Retour vers le Futur'),
(12, '13', 'Le vaisseau USS Enterprise va accueillir deux nouveaux membres d’équipage : James Kirk et Spock. Deux êtres qui se vouent un respect mutuel, mais que tout oppose. Afin de sauvegarder la Terre et les intérêts de la Fédération, le vaisseau va, d’épisode en épisode, s’enfoncer jusqu’aux confins inexplorés de l’Espace.', 'star-trek.jpg', 'Star Trek'),
(13, '9', 'Il y a bien longtemps, dans une galaxie lointaine, un jeune homme, Anakin Skywalker va révéler de grands pouvoirs. Corrompu par Palpatine, il va cependant mettre sa puissance dans la volonté de pouvoir de l’Empereur et deviendra Dark Vador. Pour les rebelles, il n’y a qu’un seul espoir, Luke, qui se révélera être lui-même le fils de Vador.', 'star-wars.svg', 'Star Wars'),
(14, '6', 'Dans un futur proche, la guerre entre les humains et les machines a fini par éclater, et la résistance des humains est mené par leur figure emblématique John Connor. Dans une tentative de reprendre l’avantage, les machines envoient dans le passé un robot à forme humaine ayant pour mission de tuer la mère de John Connor afin de l’empêcher de mettre au monde leur pire ennemi.', 'terminator.jpg', 'Terminator'),
(15, '3', 'nfant, le jeune Bruce Wayne a vu ses parents assassinés devant lui. Il va tout faire pour se venger et tuer lui-même l’assassin de son père et sa mère. Cependant, après sa formation, il va finalement devenir Batman, un justicier qui combattra le crime sans relâche dans la ville de Gotham. Du moins, jusqu’à ce qu’une mystérieuse organisation terroriste cherche à annihiler toute la ville pour la purger de son vice.', 'dark-knight.jpg', 'The Dark Knight'),
(16, '12', 'Le professeur Charles Xavier, un mutant capable de lire dans les pensées, a créé une école spéciale afin d’accueillir tous les mutants et les protéger des persécutions que les humains leur font subir. Cette école refuge se remplit peu à peu, mais Erik Lensherr, dit Magneto, ne voit pas le même avenir pour les mutants : il souhaite au contraire les réunir pour organiser leur défense, et les retourner contre les humains qui les martyrisent. Les deux points de vue vont s’opposer, jusqu’à mener à l’affrontement entre les partisans des deux camps.', 'x-men.jpg', 'X-Men');

-- --------------------------------------------------------

--
-- Table structure for table `series`
--

CREATE TABLE `series` (
  `id` bigint(20) NOT NULL,
  `anneedebut` varchar(255) DEFAULT NULL,
  `anneefin` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `series`
--

INSERT INTO `series` (`id`, `anneedebut`, `anneefin`, `image`, `nom`) VALUES
(1, '2017', '2020', '13-reasons-why.jpg', '13 Reasons Why'),
(2, '2011', 'En cours', 'american-horror-story.jpg', 'American Horror Story'),
(3, '2011', '2019', 'black-mirror.jpg', 'Black Mirror'),
(4, '2008', '2013', 'breaking-bad.jpg', 'Breaking Bad'),
(5, '2013', 'En cours', 'brooklyn-99.png', 'Brooklyn 99'),
(6, '2006', '2013', 'dexter.jpg', 'Dexter'),
(7, '2005', 'En cours', 'doctor-who.jpg', 'Doctor Who'),
(8, '2014', 'En cours', 'flash.jpg', 'Flash'),
(9, '1994', '2004', 'friends.jpg', 'Friends'),
(10, '2011', '2019', 'game-of-thrones.jpg', 'Games of Thrones'),
(11, '2005', 'En cours', 'greys-anatomy.png', 'Greys Anatomy'),
(12, '2005', '2014', 'how-i-met-your-mother.jpg', 'How I Met your Mother'),
(13, '2005', '2009', 'kaamelott.png', 'Kaamelott'),
(14, '2017', 'En cours', 'la-casa-de-papel.jpg', 'La Casa de Papel'),
(15, '2004', '2010', 'lost.jpg', 'LOST'),
(16, '2000', '2006', 'malcolm.jpg', 'Malcolm'),
(17, '2015', '2019', 'mr-robot.jpg', 'MR Robot'),
(18, '2015', '2017', 'narcos.jpg', 'Narcos'),
(19, '2013', '2019', 'orange-is-the-new-black.jpg', 'Orange is the new Black'),
(20, '2013', 'En cours', 'peaky-blinders.jpg', 'Peaky Blinders'),
(21, '2005', 'En cours', 'prison-break.jpg', 'Prison Break'),
(22, '2017', 'En cours', 'riverdal.jpg', 'Riverdale'),
(23, '2015', '2018', 'sense-8.jpg', 'Sense8'),
(24, '2010', '2017', 'sherlock.jpg', 'Sherlock'),
(25, '2016', 'En cours', 'stranger-things.jpg', 'Stranger Things'),
(26, '2005', 'En cours', 'supernatural.jpg', 'SuperNatural'),
(27, '2011', '2017', 'teen-wolf.jpg', 'Teen Wolf'),
(28, '2014', 'En cours', 'the-100.jpg', 'The 100'),
(29, '2007', '2019', 'the-big-bang-theory.jpg', 'The Big Bang Theory'),
(30, '2010', 'En cours', 'the-walking-dead.jpg', 'The Walking Dead'),
(31, '2013', 'En cours', 'vikings.jpg', 'Vikings'),
(32, '2016', 'En cours', 'westworld.jpg', 'WestWorld');

-- --------------------------------------------------------

--
-- Table structure for table `seriesanimes`
--

CREATE TABLE `seriesanimes` (
  `id` bigint(20) NOT NULL,
  `anneedebut` varchar(255) DEFAULT NULL,
  `anneefin` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seriesanimes`
--

INSERT INTO `seriesanimes` (`id`, `anneedebut`, `anneefin`, `image`, `nom`) VALUES
(1, '2010', '2018', 'adventure_time.png', 'Adventure Time'),
(2, '2005', 'En cours', 'american-dad.jpg', 'American Dad!'),
(3, '2005', '2008', 'avatar-le-dernier-maitre-de-l-air.jpg', 'Avatar le dernier maître de l’air'),
(4, '1992', '1995', 'batman.jpg', 'Batman'),
(5, '2005', '2008', 'ben-10.jpg', 'Ben 10'),
(6, '2017', 'En cours', 'big-mouth.jpg', 'Big Mouth'),
(7, '1999', 'En cours', 'bob-leponge.png', 'Bob l’Eponge'),
(8, '2014', '2020', 'bojack-horseman.jpg', 'Bojack Horseman'),
(9, '2003', '2007', 'code-lyoko.jpg', 'Code Lyoko'),
(10, '2003', '2016', 'corneil-et-bernie.jpg', 'Corneil et Bernie'),
(11, '2005', '2010', 'foot-2-rue.jpg', 'Foot 2 Rue'),
(12, '1999', '2013', 'futurama.png', 'Futurama'),
(13, '2006', '2011', 'galactik-football.jpg', 'Galactik Football'),
(14, '2008', '2015', 'garfield-cie.jpg', 'Garfield et Cie'),
(15, '2011', 'En cours', 'le-monde-incroyable-de-gumball.jpg', 'Le monde incroyable de Gumball'),
(16, '1982', '1983', 'les-mysterieuses-cites-dor.jpg', 'Les mystérieuses cités d’or'),
(17, '1989', 'En cours', 'les-simpson.jpg', 'Les Simpson'),
(18, '1997', '2006', 'les-zinzins-de-lespace.jpg', 'Les zinzins de l’espace'),
(19, '2003', '2006', 'martin-mystere.jpg', 'Martin Mystère'),
(20, '1998', 'En cours', 'oggy-et-les-cafards.jpg', 'Oggy et les cafards'),
(21, '2007', '2015', 'phineas-et-ferb.jpg', 'Phinéas et Ferb'),
(22, '2003', '2006', 'ratz.jpg', 'Ratz'),
(23, '2013', 'En cours', 'rick-et-morty.jpg', 'Rick et Morty'),
(24, '1969', '1970', 'scooby-doo.jpg', 'Scooby-Doo'),
(25, '1997', 'En cours', 'south-park.jpg', 'South Park'),
(26, '2012', '2016', 'souvenirs-de-gravity-falls.jpg', 'Souvenirs de Gravity Falls'),
(27, '2013', '2019', 'steven-universe.jpg', 'Steven Universe'),
(28, '2001', 'En cours', 'titeuf.gif', 'Titeuf'),
(29, '1940', 'En cours', 'tom-et-jerry.jpg', 'Tom et Jerry'),
(30, '2001', '2013', 'totally-spies.jpg', 'Totally Spies!'),
(31, '2008', 'En cours', 'wakfu.png', 'Wakfu'),
(32, '2004', 'En cours', 'winx-club.jpg', 'Winx Club');

-- --------------------------------------------------------

--
-- Table structure for table `sports`
--

CREATE TABLE `sports` (
  `id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sports`
--

INSERT INTO `sports` (`id`, `image`, `nom`) VALUES
(1, 'athletisme.png', 'Athlétisme'),
(2, 'basketball.png', 'Basketball'),
(3, 'cyclisme.png', 'Cyclisme'),
(4, 'equitation.png', 'Equitation'),
(5, 'football.png', 'Football'),
(6, 'golf.png', 'Golf'),
(7, 'gymnastique.png', 'Gymnastique'),
(8, 'handball.png', 'Handball'),
(9, 'judo.png', 'Judo'),
(10, 'karaté.png', 'Karaté'),
(11, 'natation.png', 'Natation'),
(12, 'petanque.png', 'Pétanque'),
(13, 'rugby.png', 'Rugby'),
(14, 'tennis.png', 'Tennis'),
(15, 'tennis-de-table.png', 'Tennis de table'),
(16, 'voile.png', 'Voile');

-- --------------------------------------------------------

--
-- Table structure for table `superheros`
--

CREATE TABLE `superheros` (
  `id` bigint(20) NOT NULL,
  `pouvoir` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `adresse`, `date_naissance`, `email`, `nom`, `password`, `prenom`) VALUES
(1, 'string', '1999-12-31', 'app', 'string', '$2a$10$vJyvVLtjGFPkDwEBsVRCIeHjTS35MbDgfO.nGgtoRjjU2j8Sufmkm', 'string');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acteurs`
--
ALTER TABLE `acteurs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `actrices`
--
ALTER TABLE `actrices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `avengers`
--
ALTER TABLE `avengers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chansons`
--
ALTER TABLE `chansons`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dessinsanimes`
--
ALTER TABLE `dessinsanimes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `horreur`
--
ALTER TABLE `horreur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jeux`
--
ALTER TABLE `jeux`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mechants`
--
ALTER TABLE `mechants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rappeurs`
--
ALTER TABLE `rappeurs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `realisateur`
--
ALTER TABLE `realisateur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `saga`
--
ALTER TABLE `saga`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seriesanimes`
--
ALTER TABLE `seriesanimes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sports`
--
ALTER TABLE `sports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `superheros`
--
ALTER TABLE `superheros`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `acteurs`
--
ALTER TABLE `acteurs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `actrices`
--
ALTER TABLE `actrices`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `avengers`
--
ALTER TABLE `avengers`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `chansons`
--
ALTER TABLE `chansons`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dessinsanimes`
--
ALTER TABLE `dessinsanimes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `horreur`
--
ALTER TABLE `horreur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jeux`
--
ALTER TABLE `jeux`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `mechants`
--
ALTER TABLE `mechants`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `rappeurs`
--
ALTER TABLE `rappeurs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `realisateur`
--
ALTER TABLE `realisateur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `saga`
--
ALTER TABLE `saga`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `series`
--
ALTER TABLE `series`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `seriesanimes`
--
ALTER TABLE `seriesanimes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `sports`
--
ALTER TABLE `sports`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `superheros`
--
ALTER TABLE `superheros`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
