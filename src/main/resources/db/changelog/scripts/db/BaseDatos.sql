DROP TABLE IF EXISTS Person;

CREATE TABLE IF NOT EXISTS Person
(
    id             SERIAL PRIMARY KEY NOT NULL,
    name           VARCHAR(100)       NOT NULL,
    lastname       VARCHAR(100)       NOT NULL,
    dateofbirth    TIMESTAMP          NOT NULL,
    gender         VARCHAR(50)        NOT NULL,
    identification VARCHAR(20)        NOT NULL
        CONSTRAINT person_unique_identification_constraint
            UNIQUE,
    address        VARCHAR(200)       NOT NULL,
    phone          VARCHAR(20)        NOT NULL,
    photo          BYTEA              NOT NULL
);


