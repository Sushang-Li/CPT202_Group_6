INSERT INTO user_info (stu_id, username, password, phone_num, intro, re_date)
SELECT * FROM (
                  SELECT 1234567 AS stu_id, 'user1', 'password1', '1234567890', 'Introduction for user1', '2024-04-28'
                  UNION ALL
                  SELECT 2345678 AS stu_id, 'user2', 'password2', '0987654321', 'Introduction for user2', '2024-04-28'
                  UNION ALL
                  SELECT 3456789 AS stu_id, 'user3', 'password3', '1112223333', 'Introduction for user3', '2024-04-28'
                  UNION ALL
                  SELECT 4567890 AS stu_id, 'user4', 'password4', '4445556666', 'Introduction for user4', '2024-04-28'
                  UNION ALL
                  SELECT 5678901 AS stu_id, 'user5', 'password5', '7778889999', 'Introduction for user5', '2024-04-28'
              ) AS tmp
WHERE NOT EXISTS (
    SELECT 1 FROM user_info WHERE stu_id = tmp.stu_id
) LIMIT 5;
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

