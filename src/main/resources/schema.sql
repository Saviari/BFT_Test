CREATE TABLE IF NOT EXISTS Person (
    id       SERIAL,
    "name"   CHARACTER VARYING(50) NOT NULL CHECK ( Person.name != '' ),
    lastName CHARACTER VARYING(50) NOT NULL CHECK ( lastName != '' ),
    CONSTRAINT person_id PRIMARY KEY(id)
    );