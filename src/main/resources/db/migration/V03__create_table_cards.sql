CREATE TABLE TB_CARD(
  ID              BIGINT AUTO_INCREMENT NOT NULL,
  NAME            VARCHAR(30)  NOT NULL,
  CARD_TYPE       VARCHAR(10)  NOT NULL,
  FLAG            VARCHAR(20)  NOT NULL,
  CLOSING_DAY     INTEGER,
  PAY_DAY         INTEGER,
  EXPIRATION_DATE DATE         NOT NULL,
  CREATED_AT      TIMESTAMP,
  UPDATED_AT      TIMESTAMP
);