CREATE TABLE TB_ACCOUNT(
  ID          VARCHAR(255) NOT NULL,
  CATEGORY_ID VARCHAR(255) NOT NULL,
  NAME        VARCHAR(30)  NOT NULL,
  CREATED_AT  TIMESTAMP,
  UPDATED_AT  TIMESTAMP
);