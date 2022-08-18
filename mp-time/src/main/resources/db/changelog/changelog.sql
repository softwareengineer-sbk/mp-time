-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE MPTIME (mosque_id INT, fajr VARCHAR, dhuhr VARCHAR, asr VARCHAR, maghrib VARCHAR, isha VARCHAR, PRIMARY KEY (mosque_id));
-- changeset liquibase:2
INSERT INTO MPTIME(mosque_id, fajr, dhuhr, asr, maghrib, isha) VALUES (1, '5:00', '13:00', '17:30', '19:30', '21:00');