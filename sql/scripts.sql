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

insert into events
values (1,
        'Nazwa wydarzenia',
        '01',
        '01',
        '01',
        'Nazwa organizatora',
        '01-01-2019',
        'Opis wydarzenia',
        150,
        'Uwagi',
        TRUE,
        TRUE,
        TRUE,
        TRUE,
        1);
