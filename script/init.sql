DROP TABLE IF EXISTS user;

CREATE TABLE user
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL,
  age VARCHAR(1000) NOT NULL,
  sex VARCHAR(5) NOT NULL,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  PRIMARY KEY (id)
) ENGINE = 'InnoDB', DEFAULT CHARSET=utf8mb4, ROW_FORMAT=DYNAMIC;

insert into user values (1, 'Kanta', 21, 'man',current_timestamp, current_timestamp);
insert into user values (2, 'Tomoka',  21, 'women', current_timestamp, current_timestamp);
