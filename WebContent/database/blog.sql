drop database if exists blog;
create database if not exists blog;

use blog;

drop table if exists admin;
create table admin(
	`username` varchar(16) default NULL,
	`password` varchar(16) default NULL
)ENGINE=InnoDB default CHARSET=utf8;
insert into admin(`username`,`password`) values ('admin','admin');


DROP TABLE IF EXISTS article;
CREATE TABLE article(
  `id` int(8) NOT NULL auto_increment,
  `title` varchar(60) default NULL,
  `path` varchar(100) default NULL,
  `datetime` varchar(60) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS IT;
CREATE TABLE IT(
  `id` int(8) NOT NULL auto_increment,
  `title` varchar(60) default NULL,
  `path` varchar(100) default NULL,
  `datetime` varchar(60) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS news;
CREATE TABLE news (
  `id` int(8) NOT NULL auto_increment,
  `title` varchar(60) default NULL,
  `path` varchar(100) default NULL,
  `datetime` varchar(60) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS book;
CREATE TABLE book (
  `id` int(8) NOT NULL auto_increment,
  `email` varchar(60) default NULL,
  `path` varchar(100) default NULL,
  `datetime` varchar(60) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
