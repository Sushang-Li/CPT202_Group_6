Use sport_centre;
INSERT INTO user_info (stu_id, email, first_name, last_name, dob, address, gender, username, position, password, phone_num, intro, re_date)
SELECT * FROM (
                  SELECT 1234567 AS stu_id, 'user1@example.com' AS email, 'John' AS first_name, 'Doe' AS last_name, '1990-01-01' AS dob, '123 Main St' AS address, 1 AS gender, 'user1' AS username, 'Student' AS position, 'password1' AS password, '1234567890' AS phone_num, 'Introduction for user1' AS intro, '2024-04-28' AS re_date
                  UNION ALL
                  SELECT 2345678, 'user2@example.com', 'Jane', 'Smith', '1992-02-02', '456 Elm St', 2, 'user2', 'Instructor', 'password2', '0987654321', 'Introduction for user2', '2024-04-28'
                  UNION ALL
                  SELECT 3456789, 'user3@example.com', 'Alice', 'Johnson', '1993-03-03', '789 Maple St', 1, 'user3', 'Assistant', 'password3', '1112223333', 'Introduction for user3', '2024-04-28'
                  UNION ALL
                  SELECT 4567890, 'user4@example.com', 'Bob', 'Brown', '1994-04-04', '101 Oak St', 2, 'user4', 'Manager', 'password4', '4445556666', 'Introduction for user4', '2024-04-28'
                  UNION ALL
                  SELECT 5678901, 'user5@example.com', 'Carol', 'Davis', '1995-05-05', '202 Pine St', 1, 'user5', 'Director', 'password5', '7778889999', 'Introduction for user5', '2024-04-28'
              ) AS tmp
WHERE NOT EXISTS (
    SELECT 1 FROM user_info WHERE stu_id = tmp.stu_id
);

INSERT INTO admin_info (username, password)
SELECT * FROM (
                  SELECT 'admin1' AS username, 'password1' AS password
                  UNION ALL
                  SELECT 'admin2' AS username, 'password2' AS password
                  UNION ALL
                  SELECT 'admin3' AS username, 'password3' AS password
                  UNION ALL
                  SELECT 'admin4' AS username, 'password4' AS password
                  UNION ALL
                  SELECT 'admin5' AS username, 'password5' AS password
              ) AS tmp
WHERE NOT EXISTS (
    SELECT 1 FROM admin_info WHERE username = tmp.username
) LIMIT 5;


INSERT INTO sport_activity (name, date, start_time, end_time, coach, stadium, price, ticket_number)
SELECT * FROM (SELECT 'basketball', '2024-05-02', '09:00:00', '11:00:00', 'Coach1', 'GM102A', 20, 100) AS tmp
WHERE NOT EXISTS (
    SELECT name, date, start_time, end_time, coach, stadium, price FROM sport_activity WHERE name = 'basketball' AND date = '2024-05-02' AND start_time = '09:00:00' AND end_time = '11:00:00' AND coach = 'Coach1' AND stadium = 'GM102A' AND price = 20
) LIMIT 1;

INSERT INTO sport_activity (name, date, start_time, end_time, coach, stadium, price, ticket_number)
SELECT * FROM (SELECT 'archery', '2024-05-02', '09:00:00', '11:00:00', 'Coach2', 'GM123A', 20, 100) AS tmp
WHERE NOT EXISTS (
    SELECT name, date, start_time, end_time, coach, stadium, price FROM sport_activity WHERE name = 'archery' AND date = '2024-05-02' AND start_time = '09:00:00' AND end_time = '11:00:00' AND coach = 'Coach2' AND stadium = 'GM123A' AND price = 20
) LIMIT 1;

INSERT INTO sport_activity (name, date, start_time, end_time, coach, stadium, price, ticket_number)
SELECT * FROM (SELECT 'billiard', '2024-05-02', '09:00:00', '11:00:00', 'Coach1', 'GM102A', 20, 100) AS tmp
WHERE NOT EXISTS (
    SELECT name, date, start_time, end_time, coach, stadium, price FROM sport_activity WHERE name = 'billiard' AND date = '2024-05-02' AND start_time = '09:00:00' AND end_time = '11:00:00' AND coach = 'Coach1' AND stadium = 'GM102A' AND price = 20
) LIMIT 1;

INSERT INTO sport_activity (name, date, start_time, end_time, coach, stadium, price, ticket_number)
SELECT * FROM (SELECT 'football', '2024-05-02', '09:00:00', '11:00:00', 'Coach1', 'GM102A', 20, 100) AS tmp
WHERE NOT EXISTS (
    SELECT name, date, start_time, end_time, coach, stadium, price FROM sport_activity WHERE name = 'football' AND date = '2024-05-02' AND start_time = '09:00:00' AND end_time = '11:00:00' AND coach = 'Coach1' AND stadium = 'GM102A' AND price = 20
) LIMIT 1;

INSERT INTO sport_activity (name, date, start_time, end_time, coach, stadium, price, ticket_number)
SELECT * FROM (SELECT 'pingpong', '2024-05-02', '09:00:00', '11:00:00', 'Coach1', 'GM102A', 20, 100) AS tmp
WHERE NOT EXISTS (
    SELECT name, date, start_time, end_time, coach, stadium, price FROM sport_activity WHERE name = 'pingpong' AND date = '2024-05-02' AND start_time = '09:00:00' AND end_time = '11:00:00' AND coach = 'Coach1' AND stadium = 'GM102A' AND price = 20
) LIMIT 1;

INSERT INTO sport_activity (name, date, start_time, end_time, coach, stadium, price, ticket_number)
SELECT * FROM (SELECT 'shuttlecock', '2024-05-02', '09:00:00', '11:00:00', 'Coach1', 'GM102A', 20, 100) AS tmp
WHERE NOT EXISTS (
    SELECT name, date, start_time, end_time, coach, stadium, price FROM sport_activity WHERE name = 'shuttlecock' AND date = '2024-05-02' AND start_time = '09:00:00' AND end_time = '11:00:00' AND coach = 'Coach1' AND stadium = 'GM102A' AND price = 20
) LIMIT 1;

INSERT INTO sport_activity (name, date, start_time, end_time, coach, stadium, price, ticket_number)
SELECT * FROM (SELECT 'tennis', '2024-05-02', '09:00:00', '11:00:00', 'Coach1', 'GM102A', 20, 100) AS tmp
WHERE NOT EXISTS (
    SELECT name, date, start_time, end_time, coach, stadium, price FROM sport_activity WHERE name = 'tennis' AND date = '2024-05-02' AND start_time = '09:00:00' AND end_time = '11:00:00' AND coach = 'Coach1' AND stadium = 'GM102A' AND price = 20
) LIMIT 1;

INSERT INTO sport_activity (name, date, start_time, end_time, coach, stadium, price, ticket_number)
SELECT * FROM (SELECT 'workout', '2024-05-02', '09:00:00', '11:00:00', 'Coach1', 'GM102A', 20, 100) AS tmp
WHERE NOT EXISTS (
    SELECT name, date, start_time, end_time, coach, stadium, price FROM sport_activity WHERE name = 'workout' AND date = '2024-05-02' AND start_time = '09:00:00' AND end_time = '11:00:00' AND coach = 'Coach1' AND stadium = 'GM102A' AND price = 20
) LIMIT 1;




