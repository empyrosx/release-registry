DROP TABLE IF EXISTS releases;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE releases
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR NOT NULL,
  url      VARCHAR NOT NULL,
  released TIMESTAMP
);