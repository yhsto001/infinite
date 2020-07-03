/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.6-MariaDB : Database - dambeetech
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dambeetech` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dambeetech`;

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `BOARDNO` int(11) NOT NULL COMMENT '게시글 번호',
  `BOARDTITLE` varchar(100) NOT NULL COMMENT '게시글 제목',
  `BOARDCONTENT` varchar(500) NOT NULL COMMENT '게시글 내용',
  `BOARDDATE` datetime NOT NULL COMMENT '게시글 작성날짜',
  `BOARDREADCOUNT` int(11) NOT NULL COMMENT '게시글 조회수',
  `USERNAME` varchar(100) NOT NULL COMMENT '작성자명',
  `BOARDORIGINALFILE` varchar(200) DEFAULT NULL COMMENT '원본파일명',
  `BOARDRENAMEFILE` varchar(200) DEFAULT NULL COMMENT '서버저장파일명',
  `BOARDGROUP` int(11) NOT NULL DEFAULT 1 COMMENT '게시글 리플 그룹',
  `BOARDGROUPNO` int(11) NOT NULL DEFAULT 0 COMMENT '게시글 리플 그룹내 순서',
  `BOARDDEPTH` int(11) NOT NULL DEFAULT 0 COMMENT '게시글 리플 깊이',
  `BOARDKEY` int(11) NOT NULL COMMENT '게시글 번호키',
  `BOARDPARENT` int(11) NOT NULL DEFAULT 0 COMMENT '부모 게시글',
  `BOARDDELETESTATE` varchar(5) NOT NULL DEFAULT 'N' COMMENT '게시글 삭제여부',
  `USERNO` int(11) NOT NULL,
  PRIMARY KEY (`BOARDNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `board` */

insert  into `board`(`BOARDNO`,`BOARDTITLE`,`BOARDCONTENT`,`BOARDDATE`,`BOARDREADCOUNT`,`USERNAME`,`BOARDORIGINALFILE`,`BOARDRENAMEFILE`,`BOARDGROUP`,`BOARDGROUPNO`,`BOARDDEPTH`,`BOARDKEY`,`BOARDPARENT`,`BOARDDELETESTATE`,`USERNO`) values (27,'안녕하세요','1121','2020-05-14 17:55:05',7,'홍길동',NULL,NULL,2,0,0,4,0,'N',2),(28,'안녕하세요22','22','2020-05-14 17:55:09',2,'홍길동',NULL,NULL,1,1,1,4,27,'Y',2),(29,'안녕하세요','ㄴㅁㅇㅁㄴㅇㅁㄴ','2020-05-14 17:55:17',1,'홍길동','1.PNG','20200514175517.PNG',1,2,2,4,28,'N',2),(1001,'안녕하세요2','222','2020-05-15 10:01:37',0,'홍길동',NULL,NULL,3,0,0,1001,0,'N',2),(1002,'안녕하세요','sdsa','2020-05-15 10:01:44',0,'홍길동',NULL,NULL,1,1,1,1001,1001,'N',2),(1003,'asdfa','sdfafa','2020-05-15 10:01:48',1,'홍길동',NULL,NULL,2,1,1,1001,1001,'Y',2),(1004,'asdfads','fafafd','2020-05-15 10:01:51',0,'홍길동',NULL,NULL,2,2,2,1001,1003,'N',2);

/*Table structure for table `boardcomment` */

DROP TABLE IF EXISTS `boardcomment`;

CREATE TABLE `boardcomment` (
  `COMMENTNO` int(11) NOT NULL COMMENT '답글 글번호',
  `COMMENTNAME` varchar(50) NOT NULL COMMENT '답글 작성자',
  `COMMENTDATE` datetime NOT NULL COMMENT '답글 작성날짜',
  `COMMENTCONTENT` varchar(200) NOT NULL COMMENT '답글 내용',
  `BOARDNO` int(11) NOT NULL,
  `USERNO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `boardcomment` */

insert  into `boardcomment`(`COMMENTNO`,`COMMENTNAME`,`COMMENTDATE`,`COMMENTCONTENT`,`BOARDNO`,`USERNO`) values (1,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요',1,2),(2,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요안녕하세요',1,2),(3,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요',1,2),(4,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요',1,2),(5,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요',1,2),(6,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요',1,2),(7,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요',1,2),(8,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요안녕하세요',1,2),(9,'양호성','2020-05-14 17:29:23','안녕하세요안녕하세요안녕하세요',1,2),(10,'홍길동','2020-05-14 17:52:22','ㄴ',19,2),(11,'홍길동','2020-05-14 17:55:46','ㅁㅁㅁ',27,2);

/*Table structure for table `boardreply` */

DROP TABLE IF EXISTS `boardreply`;

CREATE TABLE `boardreply` (
  `REPLYNO` int(11) NOT NULL COMMENT '댓글 번호',
  `REPLYGROUP` int(11) NOT NULL COMMENT '댓글 그룹',
  `REPLYGROUPNO` int(11) NOT NULL COMMENT '댓글 그룹내 순서',
  `REPLYDEPTH` int(11) NOT NULL COMMENT '댓글 깊이',
  `REPLYNAME` varchar(100) NOT NULL COMMENT '댓글 작성자',
  `REPLYDATE` datetime NOT NULL COMMENT '댓글 작성일자',
  `REPLYCONTENT` varchar(200) NOT NULL COMMENT '댓글 내용',
  `REPLYDELETE` varchar(10) NOT NULL DEFAULT 'N' COMMENT '댓글 삭제여부',
  `BOARDNO` int(11) NOT NULL,
  `USERNO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `boardreply` */

insert  into `boardreply`(`REPLYNO`,`REPLYGROUP`,`REPLYGROUPNO`,`REPLYDEPTH`,`REPLYNAME`,`REPLYDATE`,`REPLYCONTENT`,`REPLYDELETE`,`BOARDNO`,`USERNO`) values (1,1,1,1,'양호성','2020-05-14 17:29:23','안녕하세요1','N',1,1),(2,2,1,1,'양호성','2020-05-14 17:29:23','안녕하세요2','N',1,1),(3,3,1,1,'양호성','2020-05-14 17:29:23','안녕하세요3','N',1,1),(4,4,1,1,'양호성','2020-05-14 17:29:23','안녕하세요4','N',1,1),(5,5,1,1,'양호성','2020-05-14 17:29:23','안녕하세요5','N',1,1),(6,6,1,1,'양호성','2020-05-14 17:29:23','안녕하세요6','N',1,1),(7,7,1,1,'양호성','2020-05-14 17:29:23','안녕하세요7','N',1,1),(8,8,1,1,'양호성','2020-05-14 17:29:23','안녕하세요8','N',1,1),(9,9,1,1,'양호성','2020-05-14 17:29:23','안녕하세요9','N',1,1),(10,3,2,2,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1','N',1,1),(11,3,3,2,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 ','N',1,1),(12,3,4,2,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1','N',1,1),(13,3,5,3,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 RE1','N',1,1),(14,3,6,3,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 RE1','N',1,1),(15,3,7,3,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 RE1','N',1,1),(16,3,8,4,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 RE1 RE1','N',1,1),(17,3,9,4,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 RE1 RE1','N',1,1),(18,3,10,4,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 RE1 RE1','N',1,1),(19,3,11,4,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 RE1 RE1','N',1,1),(20,3,12,4,'양호성','2020-05-14 17:29:23','안녕하세요3 RE1 RE1 RE1','N',1,1),(21,6,2,2,'양호성','2020-05-14 17:29:23','안녕하세요6 re1','N',1,1),(22,6,3,3,'양호성','2020-05-14 17:29:23','안녕하세요6 re1 re1','N',1,1),(23,6,4,4,'양호성','2020-05-14 17:29:23','안녕하세요6 re1 re1 re1','N',1,1),(24,6,8,3,'양호성','2020-05-14 17:29:23','안녕하세요6 re1 re2','N',1,1),(25,6,6,4,'양호성','2020-05-14 17:29:23','안녕하세요6 re1 re1 re2','N',1,1),(26,6,7,4,'양호성','2020-05-14 17:29:23','안녕하세요6 re1 re1 re3','N',1,1),(27,6,5,5,'양호성','2020-05-14 17:29:23','안녕하세요6 re1 re1 re1 re1','N',1,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `USERNO` int(11) NOT NULL COMMENT '사용자번호',
  `USERID` varchar(30) NOT NULL COMMENT '사용자 아이디',
  `USERPW` varchar(70) NOT NULL COMMENT '사용자 비밀번호',
  `USERNAME` varchar(50) NOT NULL COMMENT '사용자 이름',
  `USERPHONE` varchar(20) NOT NULL COMMENT '사용자 전화번호',
  `USERMAIL` varchar(100) NOT NULL COMMENT '사용자 이메일',
  PRIMARY KEY (`USERNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`USERNO`,`USERID`,`USERPW`,`USERNAME`,`USERPHONE`,`USERMAIL`) values (1,'dambee1','00000000','양호성','010-1234-1234','dambee1@gmail.com'),(2,'dambee2','00000000','홍길동','010-1234-1234','dambee2@gmail.com'),(3,'dambee3','00000000','김단비','010-1234-1234','dambee3@gmail.com'),(4,'dambee4','00000000','이순신','010-1234-1234','dambee4@gmail.com'),(5,'dambee5','00000000','세종대왕','010-1234-1234','dambee5@gmail.com'),(6,'dambee6','00000000','양호성','010-1234-1234','dambee6@gmail.com'),(7,'dambee7','00000000','양호성','010-1234-1234','dambee7@gmail.com'),(8,'dambee8','00000000','양호성','010-1234-1234','dambee8@gmail.com'),(9,'dambee9','00000000','양호성','010-1234-1234','dambee9@gmail.com'),(10,'dambee11','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(11,'dambee12','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(12,'dambee13','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(13,'dambee14','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(14,'dambee15','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(15,'dambee16','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(16,'dambee17','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(17,'dambee18','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(18,'dambee19','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(19,'dambee20','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(20,'dambee21','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(21,'dambee22','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(22,'dambee23','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(23,'dambee24','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(24,'dambee25','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(25,'dambee26','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(26,'dambee27','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(27,'dambee28','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(28,'dambee29','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(29,'dambee30','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(30,'dambee31','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(31,'dambee32','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(32,'dambee33','00000000','양호성','010-1234-1234','dambee10@gmail.com'),(33,'dambee34','00000000','양호성','010-1234-1234','dambee10@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
