--Creating MPTIME Table
CREATE TABLE MPTIME(mosque_id INT, fajr VARCHAR, dhuhr VARCHAR, asr VARCHAR, maghrib VARCHAR, isha VARCHAR, PRIMARY KEY (mosque_id));

--Inserting test values into MPTIME table
INSERT INTO MPTIME(mosque_id, fajr, dhuhr, asr, maghrib, isha) VALUES (1, '5:00', '13:00', '17:30', '19:30', '21:00');