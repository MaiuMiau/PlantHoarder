-- henkilot, pakotetut id-arvot, ei auto-increment
INSERT INTO henkilo (id, kayttajaTunnus, etuNimi, sukuNimi)
VALUES
(1, 'maija@gmail.com', 'Maija', 'Nieminen'), 
(2, 'hello@mail.fi', 'Bruno', 'Lösönen'),
(3, 'leppis@gmail.com', 'Liisa', 'Leppänen');

-- kasvit, pakotetut id-arvot, ei auto-increment
INSERT INTO kasvi
(id, nimi, kuvaus, kastelu, valo, henkiloId)
VALUES
(1,'Peikonlehti', 'Suuret tummanvihreät lehdet joissa paljon reikiä. Lehdet voivat olla jopa 60cm halkaisijaltaan', 'Kerran viikossa', 'Puolivarjo',2),
(2,'Pylvästyräkki', 'Piikikäs varsi, jossa pieniä lehtiä', 'Kerran kuukaudessa', 'Aurinko',2),
(3,'KilpiPiilea', 'Hauskat yöreät lehdet, jotka muistuttavat sateenvarjoa', 'Kerran viikossa', 'Varjo',3),
(4,'Rönsylilja', 'Ohuet pitkät lehdet. Viihtyessään kasvattaa rönsyjä joista voi juurruttaa uusia kasveja. Kukkii pienillä kukilla', 'pidetään tasaisen kosteana', 'Puolivarjo',3),
(5,'Anopinkieli', 'Paksut vahamaiset lehdet, jotka voivat kasvaa yli metrin korkuisiksi', 'Kerran kuukaudessa', 'Aurinko',3);


