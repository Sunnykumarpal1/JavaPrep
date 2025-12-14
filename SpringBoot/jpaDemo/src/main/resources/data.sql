INSERT INTO patient_tbl(Name, gender, birth_day, email, blood_group) VALUES
("Sun", "male", "2002-10-08", "ak2932534@gmail.com", "A_POSITIVE"),
("Ary", "male", "2007-08-14", "Aryan@gmail.com", "AB_POSITIVE"),
("Kus", "Female", "2005-11-27", "Kushi@gmail.com", "A_POSITIVE"),
("Arush", "male", "2018-10-18", "Arush@gmail.com", "AB_POSITIVE"),
("Ansh", "male", "2012-12-28", "Ansh@gmail.com", "AB_NEGATIVE"),
("Ashwini", "Female", "2010-12-28", "Ashwini@gmail.com", "O_POSITIVE");


INSERT INTO DOCTOR(NAME,SPECIALIZATION,EMAIL)VALUES("Aryu","teeth","akpal@gmail.com"),
("Sunny","brain","skpal@gmail.com"),
("Kushi","face","kushi@gmail.com");

INSERT INTO APPOINTMENT(appointment_time,reason,patient_id,doctor_id)values
("2025-12-15 05:06:45","General Checkup",1,2),
("2026-01-15 05:06:45","stomach pain",1,3),
("2026-02-15 05:06:45","fever",3,2),
("2026-12-15 05:06:45","chickenpox",3,3),
("2025-11-15 05:06:45","headache",2,2),
("2025-10-15 05:06:45","tooth pain",3,2);
