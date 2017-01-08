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
  `content` varchar(500) default NULL,
  `datetime` varchar(60) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert  into article(`id`,`title`,`content`,`datetime`) values('1','如果我住在江南','如果我住在江南，一定要看遍江南的黛瓦青墙，绿竹潇湘。那屋檐下的青苔，房顶上的碧草，推开窗可以看见的船水人家，都是一副副动人的风景画，江南就是那么迷人，所到所见的每一处，都可以入画，都可以勾勒出优美的诗篇。伫立窗前，风中会传来阵阵淡淡的花香，或许猜不到是什么花的香气，但它就是那样大胆地闯入了我的鼻子，如水般蔓延，将我环绕，让我翩翩欲仙。','2016-5-31 09:21:00');


DROP TABLE IF EXISTS IT;
CREATE TABLE IT(
  `id` int(8) NOT NULL auto_increment,
  `title` varchar(60) default NULL,
  `content` varchar(500) default NULL,
  `datetime` varchar(60) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert  into IT(`id`,`title`,`content`,`datetime`) values('1','漫谈Cookie安全','在Web应用中，Cookie很容易成为安全问题的一部分。从以往的经验来看，对Cookie在开发过程中的使用，很多开发团队并没有形成共识或者一定的规范，这也使得很多应用中的Cookie成为潜在的易受攻击点。','2016-5-31 09:25:15');


DROP TABLE IF EXISTS news;
CREATE TABLE news (
  `id` int(8) NOT NULL auto_increment,
  `title` varchar(60) default NULL,
  `content` varchar(500) default NULL,
  `datetime` varchar(60) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert  into news(`id`,`title`,`content`,`datetime`) values (1,'美队都黑化了，我们还能相信谁？','当漫威宣布了惊天消息：美国队长其实是九头蛇的卧底特工的时候，整个漫画界哀嚎声一片。各路人马向漫威洒下了落英缤纷的反对，甚至死亡威胁都传递给了主创。','2016-5-31 09:22:00');
