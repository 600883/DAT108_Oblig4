DROP SCHEMA IF EXISTS deltager_new CASCADE;
CREATE SCHEMA deltager_new;
SET search_path TO deltager_new;

CREATE TABLE deltager
(
             mobil VARCHAR (8) PRIMARY KEY,
             fornavn VARCHAR  (40),
             etternavn VARCHAR (40),
             kjonn VARCHAR (6),
             hash VARCHAR (64) NOT NULL,
             salt VARCHAR (32) NOT NULL
);