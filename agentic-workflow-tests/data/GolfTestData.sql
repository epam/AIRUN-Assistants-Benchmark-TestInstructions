INSERT INTO player
(id, birthday,email,gender,hcp,name,surname)
VALUES
(1,'1975-12-30','t-woodsitch@mail.test',0,6.5,'Tiger','Woodsitch'),
(2,'1996-06-21','s-scheffleritch@mail.test',0,7.0,'Scottie','Scheffleritch'),
(3,'1998-08-05','borg123@mail.test',1,3.0,'Celine','Borgitch'),
(4,'1992-08-05','sarah.williams@mail.test',0,5.3,'Sarah','Williams');

INSERT INTO judge
(id, name, surname)
VALUES 
(1, 'Michael', 'Brown'),
(2, 'Patricia', 'Davis');

INSERT INTO marker
(id, name, surname)
VALUES 
(1, 'David', 'Miller'),
(2, 'Elizabeth', 'Wilson');

INSERT INTO team
(id)
VALUES 
(1), 
(2);

INSERT INTO team_players
(team_id, players_id)
VALUES 
(1, 1),
(1, 3),
(2, 2),
(2, 4);

INSERT INTO course
(id, location, name)
VALUES
(1,'5500 140th Ave NE, Bellevue, WA','Bellevue Golf Course'),
(2,'4611 Tumwater Valley Dr SE, Tumwater, WA','Tumwater Valley Golf Club'),
(3,'4002 Pennsylvania St, Longview, WA','Mint Valley Golf Course');

INSERT INTO hole
(id, hole_number, stroke_index, par)
VALUES 
(1, 1, 7, 4),
(2, 2, 15, 4),
(3, 3, 17, 3),
(4, 4, 3, 4),
(5, 5, 9, 5), 
(6, 6, 13, 3),
(7, 7, 1, 4),
(8, 8, 11, 4),
(9, 9, 5, 5),
(10, 10, 8, 4),
(11, 11, 16, 4),
(12, 12, 18, 3),
(13, 13, 4, 4),
(14, 14, 10, 4),
(15, 15, 6, 5),
(16, 16, 2, 4),
(17, 17, 14, 3),
(18, 18, 12, 4);

INSERT INTO course_holes
(course_id, holes_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18);

INSERT INTO tee
(id, tee_colour, length)
VALUES
-- BLUE colour
(1, 3, 420),
(2, 3, 380),
(3, 3, 180),
(4, 3, 440),
(5, 3, 550),
(6, 3, 210),
(7, 3, 460),
(8, 3, 400),
(9, 3, 520),
(10, 3, 430),
(11, 3, 390),
(12, 3, 190),
(13, 3, 450),
(14, 3, 410),
(15, 3, 540),
(16, 3, 470),
(17, 3, 200),
(18, 3, 420),
-- WHITE colour
(19, 1, 400),
(20, 1, 360),
(21, 1, 160),
(22, 1, 420),
(23, 1, 530),
(24, 1, 190),
(25, 1, 440),
(26, 1, 380),
(27, 1, 500),
(28, 1, 410),
(29, 1, 370),
(30, 1, 170),
(31, 1, 430),
(32, 1, 390),
(33, 1, 520),
(34, 1, 450),
(35, 1, 180),
(36, 1, 400),
-- RED colour
(37, 4, 370),
(38, 4, 330),
(39, 4, 140),
(40, 4, 390),
(41, 4, 490),
(42, 4, 170),
(43, 4, 410),
(44, 4, 350),
(45, 4, 470),
(46, 4, 380),
(47, 4, 340),
(48, 4, 150),
(49, 4, 400),
(50, 4, 360),
(51, 4, 480),
(52, 4, 420),
(53, 4, 160),
(54, 4, 370);


-- Connect tees to holes
INSERT INTO hole_tees
(hole_id, tees_id)
VALUES 
-- Hole 1 tees
(1, 1), (1, 19), (1, 37),
-- Hole 2 tees
(2, 2), (2, 20), (2, 38),
-- Hole 3 tees
(3, 3), (3, 21), (3, 39),
-- Hole 4 tees
(4, 4), (4, 22), (4, 40),
-- Hole 5 tees
(5, 5), (5, 23), (5, 41),
-- Hole 6 tees
(6, 6), (6, 24), (6, 42),
-- Hole 7 tees
(7, 7), (7, 25), (7, 43),
-- Hole 8 tees
(8, 8), (8, 26), (8, 44),
-- Hole 9 tees
(9, 9), (9, 27), (9, 45),
-- Hole 10 tees
(10, 10), (10, 28), (10, 46),
-- Hole 11 tees
(11, 11), (11, 29), (11, 47),
-- Hole 12 tees
(12, 12), (12, 30), (12, 48),
-- Hole 13 tees
(13, 13), (13, 31), (13, 49),
-- Hole 14 tees
(14, 14), (14, 32), (14, 50),
-- Hole 15 tees
(15, 15), (15, 33), (15, 51),
-- Hole 16 tees
(16, 16), (16, 34), (16, 52),
-- Hole 17 tees
(17, 17), (17, 35), (17, 53),
-- Hole 18 tees
(18, 18), (18, 36), (18, 54);

INSERT INTO competition
(id, name, start_date, end_date, course_id)
VALUES 
(1, 'Spring Championship 2025', '2025-04-15', '2025-04-17', 1);

INSERT INTO competition_judges
(competition_id, judges_id)
VALUES 
(1, 1),
(1, 2);

INSERT INTO competition_players
(competition_id, players_id)
VALUES 
(1, 1),
(1, 2),
(1, 3),
(1, 4);

INSERT INTO competition_teams
(competition_id, teams_id)
VALUES 
(1, 1),
(1, 2);

INSERT INTO round
(id, competition_id, round_number, date, name)
VALUES 
(1, 1, 1, '2025-04-15', 'Round 1'),
(2, 1, 2, '2025-04-16', 'Round 2'),
(3, 1, 3, '2025-04-17', 'Round 3');

INSERT INTO competition_rounds
(competition_id, rounds_id)
VALUES 
(1, 1),
(1, 2),
(1, 3);

INSERT INTO round_roundplayers
(round_id, roundplayers_id)
VALUES 
-- Round 1
(1, 1),
(1, 2),
(1, 3),
(1, 4),
-- Round 2
(2, 1),
(2, 2),
(2, 3),
(2, 4),
-- Round 3
(3, 1),
(3, 2),
(3, 3),
(3, 4);


INSERT INTO round_score
(id,date,sum_stableford,competition_id,player_id,score_card_id,round_id,
sum_gross_score,sum_net_score,sum_net_score_par,sum_penalty,sum_par,sum_stroke,sum_score_subtract_par,sum_score_subtract_par_hcp
)
VALUES
(1,'2025-04-15',18,1,1,NULL,1,126,90,18,0,72,126,NULL,NULL);

--INSERT INTO round_roundscores
--(round_id,roundscores_id)
--VALUES
--(1,67),
--(1,68),
--(1,69),
--(1,70),
--(1,71),
--(1,63),
--(1,58),
--(1,59),
--(1,60),
--(1,61),
--(1,62);

INSERT INTO score
(id,score_subtract_par,score_subtract_par_hcp,stableford,gross_score,net_score,net_score_par,penalty,stroke)
VALUES
(1,0,1,2,5,4,0,1,NULL),
(2,0,1,2,6,5,0,1,NULL),
(3,0,1,2,4,3,0,1,NULL),
(4,0,1,2,5,4,0,1,NULL),
(5,0,1,2,5,4,0,1,NULL),
(6,0,1,2,5,4,0,1,NULL),
(7,0,1,2,4,3,0,1,NULL),
(8,0,1,2,5,4,0,1,NULL),
(9,0,1,2,6,5,0,1,NULL),
(10,0,1,2,5,4,0,1,NULL),
(11,0,1,2,4,3,0,1,NULL),
(12,0,1,2,5,4,0,1,NULL),
(13,0,1,2,6,5,0,1,NULL),
(14,0,1,2,5,4,0,1,NULL),
(15,0,1,2,5,4,0,1,NULL),
(16,0,1,2,4,3,0,1,NULL),
(17,0,1,2,6,5,0,1,NULL),
(18,0,1,2,5,4,0,1,NULL);

INSERT INTO round_score_scores
(round_score_id,scores_id)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(1,9),
(1,10),
(1,11),
(1,12),
(1,13),
(1,14),
(1,15),
(1,16),
(1,17),
(1,18);