-- WARNING: delete all data from numerous tables

DELETE FROM round_score_scores;

DELETE FROM round_score;

DELETE FROM score;

DELETE FROM competition_rounds;

DELETE FROM round;

DELETE FROM competition;

DELETE FROM course;

DELETE FROM player;

INSERT INTO player
(id, birthday,email,gender,hcp,name,surname)
VALUES
(-1,'1975-12-30','t-woodsitch@mail.test',0,6.5,'Tiger','Woodsitch'),
(-2,'1996-06-21','s-scheffleritch@mail.test',0,7.0,'Scottie','Scheffleritch'),
(-3,'1998-08-05','borg123@mail.test',1,3.0,'Celine','Borgitch');

INSERT INTO course
(id, location, name)
VALUES
(-1,'5500 140th Ave NE, Bellevue, WA','Bellevue Golf Course'),
(-2,'4611 Tumwater Valley Dr SE, Tumwater, WA','Tumwater Valley Golf Club'),
(-3,'4002 Pennsylvania St, Longview, WA','Mint Valley Golf Course');

INSERT INTO competition
(id, end_date, name, start_date, course_id)
VALUES
(-1,'2024-03-01','Test0004','2024-03-01',-1);

INSERT INTO round 
(id, date, competition_id, name, round_number)
VALUES 
(-1,'2024-03-01',-1,'01',0);

INSERT INTO competition_rounds
(competition_id,rounds_id)
VALUES
(-1,-1);

INSERT INTO round_score
(id,date,sum_stableford,competition_id,player_id,score_card_id,round_id,
sum_gross_score,sum_net_score,sum_net_score_par,sum_penalty,sum_par,sum_stroke,sum_score_subtract_par,sum_score_subtract_par_hcp
)
VALUES
(-1,'2024-04-02',18,-1,-1,NULL,-1,126,90,18,0,72,126,NULL,NULL);

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
(-1,0,-1,2,5,4,0,1,NULL),
(-2,0,-1,2,6,5,0,1,NULL),
(-3,0,-1,2,4,3,0,1,NULL),
(-4,0,-1,2,5,4,0,1,NULL),
(-5,0,-1,2,5,4,0,1,NULL),
(-6,0,-1,2,5,4,0,1,NULL),
(-7,0,-1,2,4,3,0,1,NULL),
(-8,0,-1,2,5,4,0,1,NULL),
(-9,0,-1,2,6,5,0,1,NULL),
(-10,0,-1,2,5,4,0,1,NULL),
(-11,0,-1,2,4,3,0,1,NULL),
(-12,0,-1,2,5,4,0,1,NULL),
(-13,0,-1,2,6,5,0,1,NULL),
(-14,0,-1,2,5,4,0,1,NULL),
(-15,0,-1,2,5,4,0,1,NULL),
(-16,0,-1,2,4,3,0,1,NULL),
(-17,0,-1,2,6,5,0,1,NULL),
(-18,0,-1,2,5,4,0,1,NULL);

INSERT INTO round_score_scores
(round_score_id,scores_id)
--  UNIQUE KEY `UK_nj02s8cc3ndg6lglm9n4tomx5` (`scores_id`),
--  KEY `FKcnm5851y75pbu0lvxx0vhs6li` (`round_score_id`),
--  CONSTRAINT `FK9m5xd7mno1bpxo7qbt5h6a3s6` FOREIGN KEY (`scores_id`) REFERENCES `score` (`id`),
--  CONSTRAINT `FKcnm5851y75pbu0lvxx0vhs6li` FOREIGN KEY (`round_score_id`) REFERENCES `round_score` (`id`)
VALUES
(-1,-1),
(-1,-2),
(-1,-3),
(-1,-4),
(-1,-5),
(-1,-6),
(-1,-7),
(-1,-8),
(-1,-9),
(-1,-10),
(-1,-11),
(-1,-12),
(-1,-13),
(-1,-14),
(-1,-15),
(-1,-16),
(-1,-17),
(-1,-18);