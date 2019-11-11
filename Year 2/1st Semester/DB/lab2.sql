INSERT INTO VENUE VALUES (1, 'Londoner', 'city centre', 200);
INSERT INTO VENUE VALUES (2, 'Form space', 'Central Park', 500);
INSERT INTO VENUE VALUES (3, 'Mates', 'Zorilor', 100);
INSERT INTO VENUE VALUES (4, 'Londoner', 'city centre', 200);
INSERT INTO VENUE VALUES (5, 'La Tevi', 'Potaissa', 150);
INSERT INTO VENUE VALUES (6, 'Sisters', 'str. Universitatii', 50);
INSERT INTO VENUE VALUES (7, 'Engels', 'str. Napoca', 300);
INSERT INTO VENUE VALUES (8, 'Cleo', 'str. Clinicilor', 175);
INSERT INTO VENUE VALUES (9, 'Makeba', 'Potaissa', 30);
INSERT INTO VENUE VALUES (10, 'Lalaland', 'Potaissa', 350);

INSERT INTO SPONSOR VALUES (1, 'person', 'John Wayne');
INSERT INTO SPONSOR VALUES (2, 'person', 'Alicia Wonder');
INSERT INTO SPONSOR VALUES (3, 'public institution', 'Town Hall');
INSERT INTO SPONSOR VALUES (4, 'person', 'Sam Spielberg');

INSERT INTO PRIZE VALUES (1, 'Free burgers', 100, 1);
INSERT INTO PRIZE VALUES (2, 'Drinks for the whole table', 200, 2);
INSERT INTO PRIZE VALUES (3, 'City break', 2000, 1);
INSERT INTO PRIZE VALUES (4, 'Laptop', 3500, 4);
INSERT INTO PRIZE VALUES (5, 'Phones for the whole team', 10000, 4);
INSERT INTO PRIZE VALUES (6, '2 plane tickets', 2000, 1);
INSERT INTO PRIZE(PrizeId, PValue, SponsorID) VALUES (7, 90, 1);
INSERT INTO PRIZE(PrizeId, PValue, SponsorID) VALUES (8, 2000, 1);

INSERT INTO QUIZ VALUES (1, 'F.R.I.E.N.D.S', 'How much do you know about your friends?', 2, 3);
INSERT INTO QUIZ VALUES (2, 'Halloween', 'Worldwide customs', 1, 3);
INSERT INTO QUIZ VALUES (3, 'War History', 'Questions regarding WW1 and WW2', 1, 2);
INSERT INTO QUIZ VALUES (4, 'Geography', 'World cities and capitals', 2, 3);
INSERT INTO QUIZ VALUES (5, 'General', 'Questions from any domain', 3, 2);
INSERT INTO QUIZ VALUES (6, 'General history', 'Facts you should know', 1, 6);
INSERT INTO QUIZ(QId, QType, QDescription, PrizeId) VALUES (7, 'Brands', 'About fashion', 3);

INSERT INTO ANSWER VALUES (1,'Reykjavic', 5);
INSERT INTO ANSWER VALUES (2, 'Frank Sinatra',9);
INSERT INTO ANSWER VALUES (3, 'Bottle', 4);
INSERT INTO ANSWER VALUES (4, 'Chlorine', 3);
INSERT INTO ANSWER VALUES (5, 'Ni', 7);
INSERT INTO ANSWER VALUES (6, 'DNA molecules', 6);

INSERT INTO QUESTION VALUES (1, 'What is the capital of Iceland?', 'easy', 1);
INSERT INTO QUESTION VALUES (2, 'Who sings New York New York', 'medium', 2);
INSERT INTO QUESTION VALUES (3, 'The most commonly used bleaching agent is..', 'easy', 4);
INSERT INTO QUESTION VALUES (4, 'Genie in a ..', 'easy', 3);
INSERT INTO QUESTION VALUES (5, 'The metal that is used as a catalyst in the hydrogenation of oil is ..', 'hard', 5);
INSERT INTO QUESTION VALUES (6, 'What molecules control the inherited traits of the organism?', 'medium', 6);



-- from here!!
INSERT INTO QUESTION VALUES (7, 'What is the capital of South Africa?', 'easy', 7);
INSERT INTO QUESTION VALUES (8, 'When did Romania join the UE', 'medium', 8);
INSERT INTO QUESTION VALUES (9, 'What is the line that Joey uses the most?', 'hard', 9);

INSERT INTO ANSWER VALUES (7,'Pretoria', 3);
INSERT INTO ANSWER VALUES (8, '2007', 6);
INSERT INTO ANSWER VALUES (9, 'How you doing?', 10);

INSERT INTO TEAM VALUES (1, 'Wolves', 0);
INSERT INTO TEAM VALUES (2, 'Fahrenheit', 200);
INSERT INTO TEAM VALUES (3, 'East High', 45);
INSERT INTO TEAM VALUES (4, 'Lollipop', 100);
INSERT INTO TEAM VALUES (5, 'Lions', 150);
INSERT INTO TEAM(TId ,TName) VALUES (6, 'Caterpillars');
INSERT INTO TEAM(TId ,TotalPoints) VALUES (7, 50);

INSERT INTO ATTENDS VALUES (1, 1);
INSERT INTO ATTENDS VALUES (1, 4);
INSERT INTO ATTENDS VALUES (1, 5);
INSERT INTO ATTENDS VALUES (2, 5);
INSERT INTO ATTENDS VALUES (4, 1);
INSERT INTO ATTENDS VALUES (4, 2);
INSERT INTO ATTENDS VALUES (5, 3);
INSERT INTO ATTENDS VALUES (5, 4);
INSERT INTO ATTENDS VALUES (5, 5);

INSERT INTO CONSISTS_OF VALUES (1, 4);
INSERT INTO CONSISTS_OF VALUES (7, 4);
INSERT INTO CONSISTS_OF VALUES (2, 5);
INSERT INTO CONSISTS_OF VALUES (3, 5);
INSERT INTO CONSISTS_OF VALUES (4, 5);
INSERT INTO CONSISTS_OF VALUES (5, 5);
INSERT INTO CONSISTS_OF VALUES (6, 5);
INSERT INTO CONSISTS_OF VALUES (9, 1);

INSERT INTO PARTICIPANT VALUES (1, 'John', 'Mayers', 33, 'Berlin', 1);
INSERT INTO PARTICIPANT VALUES (2, 'Sarah', 'Smith', 20, 'Cluj', 2);
INSERT INTO PARTICIPANT VALUES (3, 'Luke', 'Mayers', 17, 'London', 2);
INSERT INTO PARTICIPANT VALUES (4, 'Lisa', 'Loo', 42, 'Paris', 1);
INSERT INTO PARTICIPANT VALUES (5, 'Ian', 'Grey', 23, 'Cluj', 3);
INSERT INTO PARTICIPANT VALUES (6, 'Mary', 'Mayers', 22, 'Ottawa', 1);
INSERT INTO PARTICIPANT VALUES (7, 'July', 'Robbinson', 19, 'Rome', 1);
INSERT INTO PARTICIPANT VALUES (8, 'Sandra', 'Wilson', 39, 'Rome', 1);
INSERT INTO PARTICIPANT VALUES (9, 'Sandra', 'Wilson', 28, 'Cluj', 3);
INSERT INTO PARTICIPANT VALUES (10, 'Larry', 'Shell', 28, 'Cluj', 3);
INSERT INTO PARTICIPANT(PId, PFirstName, PLastName, Age, City) VALUES (11, 'Salsa', 'Mill', 14, 'Bruxelles');
INSERT INTO PARTICIPANT(PId, PFirstName, PLastName, Age, City) VALUES (12, 'George', 'Yang', 21, 'Tokyo');
INSERT INTO PARTICIPANT VALUES (13, 'test', 'test', 33, 'Test', 1);


-- UPDATE

UPDATE PARTICIPANT
SET City = 'Rome'
WHERE PLastName LIKE 'Ma%' AND Age > 20;

UPDATE PRIZE
SET PType = 'Surprize'
WHERE PType IS NULL OR PValue < 150;

UPDATE ANSWER
SET APoints = 2
WHERE AText LIKE '__';

-- DELETE

DELETE FROM PARTICIPANT
WHERE Age BETWEEN 40 AND 45;

DELETE FROM VENUE
WHERE NOT CAPACITY > 80;

-- SELECT

--a
-- questions that have answers with 6 or 10 points
SELECT QuText
FROM QUESTION Q1, ANSWER A1
WHERE Q1.AnId = A1.AId AND A1.APoints = 6
UNION
SELECT QuText
FROM QUESTION Q2, ANSWER A2
WHERE Q2.AnId = A2.AId AND A2.APoints = 10

-- venues that are located on Potaissa or have capacity greater than 450
SELECT VName
FROM VENUE V
WHERE V.VLocation = 'Potaissa' OR V.Capacity > 450
ORDER BY VName


--b
-- questions that have answers with points greater than 3 and smaller than 6
SELECT QuText
FROM QUESTION Q1, ANSWER A1
WHERE Q1.AnId = A1.AId AND A1.APoints > 3
INTERSECT
SELECT QuText
FROM QUESTION Q2, ANSWER A2
WHERE Q2.AnId = A2.AId AND A2.APoints < 6

-- participants from Rome that are older than 20
SELECT PFirstName, PLastName, City
FROM PARTICIPANT P
WHERE P.City = 'Rome' AND PId IN (
								SELECT P1.PId
								FROM PARTICIPANT P1
								WHERE P1.Age > 20)

--c
-- participants from Cluj that are not younger than 26
SELECT DISTINCT PFirstName
FROM PARTICIPANT P1
WHERE P1.City = 'Cluj'
EXCEPT
SELECT PFirstName, PLastName
FROM PARTICIPANT P2
WHERE P2.Age < 26

-- participants from Cluj that are in team3, ordered by first and last name
SELECT P.PFirstName, P.PLastName
FROM PARTICIPANT P
WHERE P.City = 'Cluj' AND P.PId NOT IN (
											SELECT P1.PId
											FROM PARTICIPANT P1
											WHERE P1.TeamId = 3)
ORDER BY P.PFirstName, P.PLastName

--d
-- inner join
SELECT *
FROM QUIZ Q INNER JOIN CONSISTS_OF C ON Q.QId = C.QId INNER JOIN QUESTION QU ON C.QuesId = QU.QuId

-- left join with top 5
SELECT TOP 5 *
FROM PARTICIPANT P LEFT JOIN TEAM T ON P.TeamId = T.TId
WHERE P.Age < 30
ORDER BY T.TotalPoints DESC

-- full join with top 8
SELECT TOP 8 *
FROM QUIZ Q FULL JOIN VENUE V ON Q.VenueId = V.VId
WHERE V.Capacity < 300 OR Q.PrizeId = 3
ORDER BY V.Capacity

-- 2 many to many relationships
SELECT *
FROM TEAM T INNER JOIN ATTENDS A ON T.TId = A.TeamId
	INNER JOIN QUIZ Q ON A.QuizId = Q.QId
	INNER JOIN CONSISTS_OF C ON C.QId = Q.QId
	RIGHT JOIN QUESTION QU ON QU.QuId = C.QuesId
WHERE QU.QDifficulty = 'easy'

-- e

-- location of quizes where the prize values more than 1000

SELECT V.VName, V.VLocation
FROM VENUE V
WHERE V.VId IN ( 
				SELECT Q.VenueId
				FROM QUIZ Q
				WHERE PrizeId IN ( 
									SELECT P.PrizeId
									FROM PRIZE P
									WHERE P.PValue > 100 )
				)

-- distinct last names of participants who are in teams that have more than 100 points

SELECT DISTINCT P.PLastName AS LastName
FROM PARTICIPANT P
WHERE P.TeamId IN (
					SELECT T.TId
					FROM TEAM T
					WHERE T.TotalPoints > 100
					)

-- f
-- sponsors that have given a prize that values more than 500
SELECT S.SponsorId, SName, S.SType
FROM SPONSOR S
WHERE EXISTS (
				SELECT P.PrizeId
				FROM PRIZE P
				WHERE S.SponsorId = P.SponsorId AND P.PValue < 500 )

-- quizes that have at least one question with medium difficulty
SELECT Q.QType, Q.QDescription
FROM QUIZ Q
WHERE EXISTS (
				SELECT QU.QuId
				FROM QUESTION QU, CONSISTS_OF C
				WHERE Q.QId = C.QId AND C.QuesId = QU.QuId AND QU.QDifficulty = 'medium' )


-- g
-- questions and answers that value more than 3 points
SELECT *
FROM QUESTION Q INNER JOIN (
					SELECT A.AId, A.AText
					FROM ANSWER A
					WHERE A.APoints > 3 ) T ON Q.AnId = T.AId

-- participants and their teams, where teams don't have null totalpoints
SELECT *
FROM PARTICIPANT P RIGHT JOIN ( 
		SELECT T.TId, TName, T.TotalPoints
		FROM TEAM T
		WHERE T.TotalPoints IS NOT NULL ) T1 ON P.TeamId = T1.TId


-- h

-- members in each team
SELECT COUNT(P.PId) AS NrParticipants, P.TeamId
FROM PARTICIPANT P
GROUP BY P.TeamId

-- sponsors and the nr of prizes given, starting from at least 2 prizes
SELECT COUNT(P.PrizeId) AS NrPrizes, P.SponsorId
FROM PRIZE P
GROUP BY P.SponsorId
HAVING COUNT(P.PrizeId) > 1

-- nr of quizes held in each venue
SELECT COUNT(Q.VenueId), V.VName
FROM QUIZ Q INNER JOIN VENUE V ON Q.VenueId = V.VId
WHERE Q.VenueId IS NOT NULL
GROUP BY V.VName

-- nr of participants of each age where the age is greater than the average
SELECT COUNT(*) AS Nr, P.Age
FROM PARTICIPANT P
GROUP BY P.Age
HAVING P.Age > (
					SELECT AVG(P.Age)
					FROM PARTICIPANT P
				)
ORDER BY P.Age

-- maximum capacity of each location where it is bigger than the average capacity
SELECT MAX(V.Capacity) , V.VLocation, COUNT(*)
FROM VENUE V
GROUP BY V.VLocation
HAVING MAX(V.Capacity) > (
					SELECT AVG(V.Capacity)
					FROM VENUE V
				)

-- i

-- Venues with capacity greater than any of the venues from location Potaissa
SELECT V.VName
FROM VENUE V
WHERE V.Capacity > ANY (
					SELECT V1.Capacity
					FROM VENUE V1
					WHERE V1.VLocation LIKE '%Potaissa%' )

-- with aggregation operator MIN
SELECT V.VName
FROM VENUE V
WHERE V.Capacity > (
					SELECT MIN(V1.Capacity)
					FROM VENUE V1
					WHERE V1.VLocation LIKE '%Potaissa%' )

-- Select prizes with a value less than any of the prizes offered by sponsor 1
SELECT P.PrizeId, P.PType
FROM PRIZE P
WHERE P.PValue < ANY (
						SELECT P1.PValue
						FROM PRIZE P1
						WHERE P1.SponsorId = 1 )

-- with aggregation operator MAX
SELECT P.PrizeId, P.PType
FROM PRIZE P
WHERE P.PValue < (
					SELECT MAX(P1.PValue)
					FROM PRIZE P1
					WHERE P1.SponsorId = 1 )

-- participants with city different from all participants from team 1

SELECT P.PFirstName, P.PLastName
FROM PARTICIPANT P
WHERE P.City <> ALL (
						  SELECT P.City
						  FROM PARTICIPANT P1
						  WHERE P.TeamId = 1)

-- with NOT IN

SELECT P.PFirstName, P.PLastName
FROM PARTICIPANT P
WHERE P.City NOT IN (
						  SELECT P.City
						  FROM PARTICIPANT P1
						  WHERE P.TeamId = 1)

-- participant which are not in team 1 but have their last name as on eof the players from team1 
SELECT P.PId, P.PFirstName, P.PLastName
FROM PARTICIPANT P
WHERE P.TeamId <> 1 AND P.PLastName = ANY (
							SELECT P1.PLastName
							FROM PARTICIPANT P1
							WHERE P1.TeamId = 1 )

-- rewrite with IN
SELECT P.PId, P.PFirstName, P.PLastName
FROM PARTICIPANT P
WHERE P.TeamId <> 1 AND P.PLastName IN (
							SELECT P1.PLastName
							FROM PARTICIPANT P1
							WHERE P1.TeamId = 1 )









