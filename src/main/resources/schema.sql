DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id int(10) unsigned NOT NULL auto_increment,
    name char(100) NOT NULL default '',
    PRIMARY KEY  (id)
);

INSERT INTO USERS (name) VALUES ('User01'), ('User02'), ('User03');
