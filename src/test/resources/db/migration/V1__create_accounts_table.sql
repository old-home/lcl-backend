CREATE TABLE accounts
(
  id       BIGINT AUTO_INCREMENT PRIMARY KEY,
  email    VARCHAR(256) NOT NULL,
  password VARCHAR(64)  NOT NULL
);
