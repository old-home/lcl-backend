CREATE TABLE accounts
(
  id       BIGSERIAL PRIMARY KEY,
  email    VARCHAR(256) NOT NULL,
  password VARCHAR(64)  NOT NULL
);
