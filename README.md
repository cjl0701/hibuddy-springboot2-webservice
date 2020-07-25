# hibuddy-springboot2-webservice
### 소개
##### 관심사 기반 외국인 친구 매칭 플랫폼
###### 본 프로그램은 어학 및 문화교류, 사교활동 등을 위해 취미와 관심사를 기반으로 친구를 매칭 해주는 서비스이다.
###### 회원 가입 후 취미를 입력하면, 같은 취미를 가진 친구의 정보를 조회해볼 수 있고 친구 요청을 보낼 수 있다.
###### 상대방의 친구 요청을 수락하면 친구 관계가 되고 서로의 연락처 정보가 공개된다.

#
### 사용한 기술 스택
* Server: springboot2 내장 tomcat
* DB: 개발은 MySQL, H2(test용 인메모리 DB) 사용,  배포는 AWS의 RDS DB는 MariaDB.
* Backend: Java8(springboot2) / JPA(자바 ORM 표준), Querydsl(조회 프레임워크), DBCP / Spring security, OAUTH2 / Spirng test, JUnit test
* Frontend: Bootstrap, Javascript, JQuery, Mustache(server template engine)
* Build tool: gradle 4.2
* 배포: AWS-EC2/RDS. Travis CI & CodeDeploy로 push시 빌드-배포 자동화, 무중단 배포
* IDE: IntelliJ IDEA Utilmate
