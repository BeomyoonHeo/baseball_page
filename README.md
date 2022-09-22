baseball# MyBatis DB연결 세팅

### 테이블 chracter set => utf-8로 통일하기
- alter table 테이블명 convert to character set utf8;

### 설정방법


### MariaDB 사용자 생성 및 권한 주기
```sql
CREATE USER 'baseball'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'baseball'@'%';
CREATE DATABASE baseball;
```

### 테이블 생성
```sql
##야구장
CREATE TABLE stadium(
	id int auto_increment primary key,
    name varchar(100) unique not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;

##팀
CREATE TABLE team(
	id int auto_increment primary key,
    stadiumId int,
    name varchar(100) unique not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;

##선수
CREATE TABLE player(
	id int auto_increment primary key,
    name varchar(100) unique not null,
    teamId int,
    position varchar(100) not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;

#퇴출
CREATE TABLE expulsion(
	id int auto_increment primary key,
    reason varchar(100) unique not null,
    playerId int,
    createDate timestamp
) engine=InnoDB default charset=utf8;

##제약조건
alter table team add constraint foreign key
(stadiumId) references stadium (id)
on delete cascade;

alter table player add constraint foreign key
(teamId) references team (id)
on delete cascade;

alter table expulsion add constraint foreign key
(playerId) references player (id)
on delete cascade;
```

### 더미데이터 추가
```sql
INSERT into stadium(name,createDate)
VALUES("사직야구장",now());
INSERT into stadium(name,createDate)
VALUES("구덕야구장",now());
INSERT into stadium(name,createDate)
VALUES("잠실야구장",now());

INSERT into team(stadiumId,name,createDate)
VALUES("1","두산",now());
INSERT into team(stadiumId,name,createDate)
VALUES("2","NC",now());
INSERT into team(stadiumId,name,createDate)
VALUES("3","롯데",now());

INSERT into player(name,teamId,position,createDate)
VALUES("김민재",1,"타자",now());
INSERT into player(name,teamId,position,createDate)
VALUES("채지선",1,"투수",now());
INSERT into player(name,teamId,position,createDate)
VALUES("알칸타라",1,"외야수",now());


INSERT into player(name,teamId,position,createDate)
VALUES("손민한",2,"타자",now());
INSERT into player(name,teamId,position,createDate)
VALUES("루친스키",2,"투수",now());
INSERT into player(name,teamId,position,createDate)
VALUES("박석민",2,"내야수",now());


INSERT into player(name,teamId,position,createDate)
VALUES("오윤석",3,"타자",now());
INSERT into player(name,teamId,position,createDate)
VALUES("박세웅",3,"투수",now());
INSERT into player(name,teamId,position,createDate)
VALUES("오태근",3,"내야수",now());
```
