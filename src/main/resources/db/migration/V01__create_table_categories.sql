CREATE TABLE TB_CATEGORY(
  ID          BIGINT AUTO_INCREMENT NOT NULL,
  NAME        VARCHAR(30) NOT NULL,
  DESCRIPTION VARCHAR(100),
  CREATED_AT  TIMESTAMP,
  UPDATED_AT  TIMESTAMP
);