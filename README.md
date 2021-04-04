
# hibuddy-springboot2-webservice
## 소개
**관심사 기반 외국인 친구 매칭 웹 서비스**   
유저와 같은 취미와 관심사를 가진 사람을 친구로 추천    
외국어 학습을 위해 큰 비용을 지출하는 친구들을 보며, *‘학교에 있는 외국인 교환학생’과 내국인 학생들을 매칭*하는 서비스 착안   

### 서비스 프로세스   
**1. 소셜 로그인(구글, 네이버) 후 회원 가입**   
    회원 가입 시 모국어 및 제2 외국어, 취미 및 관심사 등 정보 입력   
**2. 친구 찾기**   
    같은 취미를 가진 사람들의 정보를 제공   
**3. 친구 요청**   
    마음에 드는 사람에게 친구 요청   
**4. 친구 수락**   
    친구 요청을 수락하면 친구 관계로 등록되고 서로에게 연락처 정보 공개   

### 데모
- **친구 찾기 & 친구 요청**
![hibuddy 친구 요청](https://user-images.githubusercontent.com/55947154/113508797-ff881300-958c-11eb-95b8-764397db208c.gif)   

- **친구 목록, 친구 요청 목록 조회 & 친구 요청 수락**
![hibuddy 요청 수락](https://user-images.githubusercontent.com/55947154/113508799-01ea6d00-958d-11eb-9ba4-ca238bf41111.gif)   

</br>

## 기술 스택
* Backend: Java8 / springboot2 / JPA(자바 ORM 표준), Querydsl(조회 프레임워크), DBCP / Spring security, OAUTH2 / Spirng test, JUnit test
* Frontend: Bootstrap, Javascript, JQuery, Mustache(server template engine)
* Build tool: gradle 4.2
* 배포: AWS-EC2,RDS / Travis CI & CodeDeploy로 push시 빌드-배포 자동화 / nginx를 이용한 무중단 배포
* IDE: IntelliJ IDEA Utilmate

- Server: springboot2 내장 tomcat
- DB: 개발은 MySQL, H2(test용 인메모리 DB) 사용,  배포는 AWS의 RDS DB는 MariaDB.

> *기술 선택 이유*
> - **Spring**: 유연하고 확장성 있는 구조를 설계하고자
> - **JPA**: Java(객체지향)와 RDB의 패러다임을 일치시키고자
> - **Querydsl**: JPA에서 다양한 조회 기능을 사용하지 못하는 문제를 보완하기 위해
> - **DBCP**: thread pool 처럼, 서버의 부하를 줄이기 위해 미리 Connection 객체를 만들어 놓고 사용
> - **Mustache**: 다른 템플릿 엔진보다 심플, 로직 코드를 사용할 수 없으므로 명확하게 View와 서버의 역할을 분리
> - **Spring Security OAuth2**: 고려해야할 부분이 많은 로그인을 믿을 수 있는 IT 서비스에 위임함으로써 서비스 개발에 집중
> - **Spring test, Junit**: 새로운 기능이 추가될 때, 기존 기능이 잘 작동되는 것을 보장, 톰캣을 재시작할 필요 없어 빠른 피드백 가능
> - **AWS의 EC2, RDS**: 트래픽이 몰릴 때만 유동적으로 사양을 늘릴 수 있으며, 하드웨어, 네트워크 관리 등을 지원하여 개발에만 집중 가능

</br>

## 구조   
**전체 시스템 구조도**   
![hibuddy 전체 시스템 구조도4](https://user-images.githubusercontent.com/55947154/113509531-1df00d80-9591-11eb-995d-cd295722927d.jpg)   
MVC 패턴 기반(Model, View, Controller, Service, Repository)

**인프라 구조**   
![hibuddy 인프라 구조](https://user-images.githubusercontent.com/55947154/113509780-5f34ed00-9592-11eb-8e9e-90dcf73f1189.png)   
- Github에 push하면 자동으로 EC2 서버로 배포되도록 Travis CI와 AWS CodeDeploy를 적용    
- 이렇게 하면 업데이트하여 배포할 때 일시적으로 중단되는 이슈가 발생했기 때문에 Nginx의 리버스 프록시 기능을 적용해 무중단 배포

> - Travis CI: 원격 저장소에 push 되면 자동으로 빌드와 테스트를 실행해 개발에만 집중케 함    
>   본 서비스는 규모가 작으므로 따로 인스턴스를 만들지 않고 오픈소스 웹 서비스(Travis CI)를 사용
> - CodeDeploy: EC2에 jar파일을 배포해주는 AWS의 배포 시스템
> - AWS S3: CodeDeploy는 저장 기능이 없으므로, Travis CI가 빌드한 결과물을 받아 CodeDeploy에 전달

