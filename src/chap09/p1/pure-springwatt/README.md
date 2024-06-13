# 스프링 MVC 프레임워크 실행(Spring Boot 사용 안하기) 

## 로컬환경에서 springwatt 프로젝트 실행 해보기(파비앙의 가이드)

### (1) Intellij Community Edition(무료 버전) 설치

### (2) 톰캣 설치

### (3) `Smart Tomcat` Plugin 설치

1. Intellij IDEA > Settings > Plugins 진입
2. Marketplace 탭으로 진입
3. Smart Tomcat 검색
4. 설치

### (4) build 실행

![IMAGE3.png](images%2FIMAGE3.png)

1. 우측 상단에 Gradle 탭 진입
2. Run Configurations에서 차례대로 clean -> build -> explodedWar 실행
3. (만약 잘 안되는 경우) 아이콘 중 Reload All Gradle Projects 실행

### (5) `Run / Debug Configurations` > `Edit Configurations...`

![IMAGE1.png](images%2FIMAGE1.png)
![IMAGE2.png](images%2FIMAGE2.png)

1. 팝업 좌측 목록 중 Smart Tomcat 클릭
2. 내용 채우고 OK 클릭

### (6) Run

1. 우측 `Run / Debug Configurations` 오른쪽에 실행 버튼으로 서버 실행
2. 브라우저 또는 Postman으로 http://localhost:8080/springwatt/hello-world 실행
