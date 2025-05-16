Use sport_centre;
ALTER TABLE user_info MODIFY COLUMN balance DOUBLE NOT NULL DEFAULT 0;

INSERT INTO user_info (stu_id, email, first_name, last_name, dob, address, gender, username, position, password, phone_num, intro, re_date, balance)
SELECT * FROM (
                  SELECT 1234567 AS stu_id, 'user1@example.com' AS email, 'John' AS first_name, 'Doe' AS last_name, '1990-01-01' AS dob, '123 Main St' AS address, 1 AS gender, 'user1' AS username, 'Student' AS position, 'password1' AS password, '1234567890' AS phone_num, 'Introduction for user1' AS intro, '2024-04-28' AS re_date, '2000' AS balance
                  UNION ALL
                  SELECT 2345678, 'user2@example.com', 'Jane', 'Smith', '1992-02-02', '456 Elm St', 2, 'user2', 'Instructor', 'password2', '0987654321', 'Introduction for user2', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 3456789, 'user3@example.com', 'Alice', 'Johnson', '1993-03-03', '789 Maple St', 1, 'user3', 'Assistant', 'password3', '1112223333', 'Introduction for user3', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 4567890, 'user4@example.com', 'Bob', 'Brown', '1994-04-04', '101 Oak St', 2, 'user4', 'Manager', 'password4', '4445556666', 'Introduction for user4', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 5678901, 'user5@example.com', 'Carol', 'Davis', '1995-05-05', '202 Pine St', 1, 'user5', 'Director', 'password5', '7778889999', 'Introduction for user5', '2024-04-28', '2000'
                  UNION ALL
                  -- 新增数据开始 --
                  SELECT 6789012, 'user6@example.com', 'David', 'Wilson', '1996-06-06', '303 Cedar St', 2, 'user6', 'Student', 'password6', '2223334444', 'Introduction for user6', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 7890123, 'user7@example.com', 'Emma', 'Martinez', '1997-07-07', '404 Birch St', 1, 'user7', 'Instructor', 'password7', '5556667777', 'Introduction for user7', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 8901234, 'user8@example.com', 'Frank', 'Garcia', '1998-08-08', '505 Redwood St', 2, 'user8', 'Assistant', 'password8', '8889990000', 'Introduction for user8', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 9012345, 'user9@example.com', 'Grace', 'Rodriguez', '1999-09-09', '606 Spruce St', 1, 'user9', 'Manager', 'password9', '1212121212', 'Introduction for user9', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 1123456, 'user10@example.com', 'Henry', 'Lopez', '2000-10-10', '707 Sequoia St', 2, 'user10', 'Director', 'password10', '3434343434', 'Introduction for user10', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 2234567, 'user11@example.com', 'Ivy', 'Hernandez', '2001-11-11', '808 Fir St', 1, 'user11', 'Student', 'password11', '5656565656', 'Introduction for user11', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 3345678, 'user12@example.com', 'Jack', 'Gonzalez', '2002-12-12', '909 Cypress St', 2, 'user12', 'Instructor', 'password12', '7878787878', 'Introduction for user12', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 4456789, 'user13@example.com', 'Karen', 'Perez', '2003-01-13', '1010 Willow St', 1, 'user13', 'Assistant', 'password13', '9090909090', 'Introduction for user13', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 5567890, 'user14@example.com', 'Leo', 'Sanchez', '2004-02-14', '1111 Aspen St', 2, 'user14', 'Manager', 'password14', '1231231234', 'Introduction for user14', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 6678901, 'user15@example.com', 'Mia', 'Ramirez', '2005-03-15', '1212 Palm St', 1, 'user15', 'Director', 'password15', '4564564567', 'Introduction for user15', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 7789012, 'user16@example.com', 'Noah', 'Flores', '2006-04-16', '1313 Juniper St', 2, 'user16', 'Student', 'password16', '7897897890', 'Introduction for user16', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 8890123, 'user17@example.com', 'Olivia', 'Torres', '2007-05-17', '1414 Mahogany St', 1, 'user17', 'Instructor', 'password17', '3213213210', 'Introduction for user17', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 9901234, 'user18@example.com', 'Peter', 'Rivera', '2008-06-18', '1515 Sycamore St', 2, 'user18', 'Assistant', 'password18', '6546546543', 'Introduction for user18', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 1012345, 'user19@example.com', 'Quinn', 'Gomez', '2009-07-19', '1616 Magnolia St', 1, 'user19', 'Manager', 'password19', '9879879876', 'Introduction for user19', '2024-04-28', '2000'
                  UNION ALL
                  SELECT 1223456, 'user20@example.com', 'Ryan', 'Diaz', '2010-08-20', '1717 Poplar St', 2, 'user20', 'Director', 'password20', '1357911131', 'Introduction for user20', '2024-04-28', '2000'
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

INSERT INTO coupon_info (name, face_value, start_time, end_time, status, user_id)
VALUES
    ('Jun', 100, '2023-06-01', '2023-08-31', 'Expired', 1),
    ('October', 50, '2023-10-01', '2024-10-13', 'ACTIVE', 1),
    ('May', 100, '2023-10-01', '2024-05-01', 'ACTIVE', 1),
    ('May', 75, '2023-05-01', '2023-05-15', 'EXPIRED', 1);


