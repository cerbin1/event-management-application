DROP TABLE IF EXISTS events;

CREATE TABLE events
(
    id                          serial PRIMARY KEY,
    name                        VARCHAR(30) NOT NULL,
    status                      CHAR(2),
    category                    CHAR(2),
    place                       CHAR(2),
    organizationName            VARCHAR(30),
    dateOfTheEvent              VARCHAR(10),
    description                 VARCHAR(1000),
    plannedNumberOfParticipants INTEGER,
    comments                    VARCHAR(1000),
    regulations                 BOOLEAN,
    rodoClause                  BOOLEAN,
    promotionalCampaign         BOOLEAN,
    photograph                  BOOLEAN,
    personId                    INTEGER
);

DROP TABLE IF EXISTS persons;

CREATE TABLE persons
(
    id          serial PRIMARY KEY,
    personName  VARCHAR(30) NOT NULL,
    surname     VARCHAR(30),
    phoneNumber VARCHAR(10),
    email       VARCHAR(30)
);

DROP TABLE IF EXISTS dictionaries;

CREATE TABLE dictionaries
(
    id    serial PRIMARY KEY,
    key   CHAR(2),
    value VARCHAR(50),
    name  VARCHAR(30)
);

INSERT INTO dictionaries (key, value, name)
VALUES ('01', 'Uroczystość', 'eventCategory');
INSERT INTO dictionaries (key, value, name)
VALUES ('02', 'Spotkanie', 'eventCategory');
INSERT INTO dictionaries (key, value, name)
VALUES ('03', 'Naukowe', 'eventCategory');
INSERT INTO dictionaries (key, value, name)
VALUES ('04', 'Kulturalne', 'eventCategory');
INSERT INTO dictionaries (key, value, name)
VALUES ('05', 'Sportowe', 'eventCategory');

INSERT INTO dictionaries (key, value, name)
VALUES ('01', 'Sala wykładowa', 'eventPlace');
INSERT INTO dictionaries (key, value, name)
VALUES ('02', 'Pokój biurowy', 'eventPlace');
INSERT INTO dictionaries (key, value, name)
VALUES ('03', 'Hala sportowa', 'eventPlace');
INSERT INTO dictionaries (key, value, name)
VALUES ('04', 'Biblioteka', 'eventPlace');
INSERT INTO dictionaries (key, value, name)
VALUES ('05', 'Laboratorium', 'eventPlace');
INSERT INTO dictionaries (key, value, name)
VALUES ('06', 'Sala komputerowa', 'eventPlace');
INSERT INTO dictionaries (key, value, name)
VALUES ('07', 'Nie określono', 'eventPlace');

INSERT INTO dictionaries (key, value, name)
VALUES ('01', 'Nowy', 'eventStatus');
INSERT INTO dictionaries (key, value, name)
VALUES ('02', 'Zaakceptowany', 'eventStatus');
INSERT INTO dictionaries (key, value, name)
VALUES ('03', 'Odrzucony', 'eventStatus');
