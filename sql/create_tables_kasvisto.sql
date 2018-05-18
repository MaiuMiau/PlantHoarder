
CREATE TABLE henkilo(
id int auto_increment not null,
kayttajaTunnus varchar(30),
etuNimi varchar(30),
sukuNimi varchar(30),
primary key(id)
)engine=InnoDB;

CREATE TABLE kasvi(
id int auto_increment not null,
nimi varchar(30),
kuvaus varchar(200),
kastelu varchar(30),
valo varchar(30),
henkiloId int not null,
primary key(id),
FOREIGN KEY (henkiloId) REFERENCES henkilo(id)
)engine=InnoDB;