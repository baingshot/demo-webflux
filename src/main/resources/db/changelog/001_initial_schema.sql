CREATE sequence IF NOT EXISTS employees_id_seq;

CREATE TABLE IF NOT EXISTS employees
(
    id          bigint             NOT NULL DEFAULT employees_id_seq.nextval,
    name        varchar(32)        NOT NULL
);

ALTER TABLE IF EXISTS employees ADD CONSTRAINT IF NOT EXISTS employees_pkey PRIMARY KEY (id);