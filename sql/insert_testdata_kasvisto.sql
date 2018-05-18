-- henkilot, pakotetut id-arvot, ei auto-increment
INSERT INTO henkilo (id, kayttajaTunnus, etuNimi, sukuNimi)
VALUES
(1, 'maija@gmail.com', 'Maija', 'Nieminen'), 
(2, 'hello@mail.fi', 'Bruno', 'L�s�nen'),
(3, 'leppis@gmail.com', 'Liisa', 'Lepp�nen');

-- kasvit, pakotetut id-arvot, ei auto-increment
INSERT INTO kasvi
(id, nimi, kuvaus, kastelu, valo, henkiloId)
VALUES
(1,'Peikonlehti', 'Suuret tummanvihre�t lehdet joissa paljon reiki�. Lehdet voivat olla jopa 60cm halkaisijaltaan', 'Kerran viikossa', 'Puolivarjo',2),
(2,'Pylv�styr�kki', 'Piikik�s varsi, jossa pieni� lehti�', 'Kerran kuukaudessa', 'Aurinko',2),
(3,'KilpiPiilea', 'Hauskat y�re�t lehdet, jotka muistuttavat sateenvarjoa', 'Kerran viikossa', 'Varjo',3),
(4,'R�nsylilja', 'Ohuet pitk�t lehdet. Viihtyess��n kasvattaa r�nsyj� joista voi juurruttaa uusia kasveja. Kukkii pienill� kukilla', 'pidet��n tasaisen kosteana', 'Puolivarjo',3),
(5,'Anopinkieli', 'Paksut vahamaiset lehdet, jotka voivat kasvaa yli metrin korkuisiksi', 'Kerran kuukaudessa', 'Aurinko',3);


