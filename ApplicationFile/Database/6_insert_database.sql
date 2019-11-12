use toeiconline;
SELECT *
FROM user;
INSERT INTO user (name, password, fullname, createddate, roleid)
VALUES ('admin', '123456', 'admin', CURRENT_TIMESTAMP, 1);
INSERT INTO user (name, password, fullname, createddate, roleid)
VALUES ('minhtung', '123456', 'user', CURRENT_TIMESTAMP, 2);

