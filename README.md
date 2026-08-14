# eGovFrame CMS Demo

전자정부 표준프레임워크 **5.0** 계열을 기준으로 만든 CMS 스타터입니다. 50개 관리 기능을 카탈로그로 정의하고, 동일한 공통 CRUD 엔진으로 모든 기능에서 등록/조회/수정/삭제를 수행할 수 있게 구성했습니다.

## 기술 스택

- eGovFrame 5.0.0 Boot parent
- Spring Boot 3.x 계열 / Spring Framework 6.2 계열
- Java 17+
- Spring MVC + Thymeleaf
- Spring Security
- Spring Data JPA + H2
- Maven

## 데모 계정

- 관리자: `admin / admin1234`
- 운영자: `operator / operator1234`

> 데모 편의를 위해 인메모리 계정과 CSRF 비활성화를 사용합니다. 운영 전환 시 DB 사용자/권한, 비밀번호 인코딩, CSRF, 감사로그를 운영 정책에 맞게 적용하세요.

## 실행

```bash
mvn clean spring-boot:run
```

브라우저에서 `http://localhost:8080` 접속.

Docker 사용 시:

```bash
docker compose up --build
```

## 50개 기능

1. 운영 대시보드
2. 사이트 기본설정
3. 시스템 설정
4. 환경 설정
5. 메뉴 관리
6. 메뉴 순서
7. 메뉴 노출
8. 역할 관리
9. 권한 관리
10. 역할-권한 매핑
11. 회원 관리
12. 회원 상세
13. 회원 상태
14. 비밀번호 초기화
15. 로그인 이력
16. 회원 그룹
17. 프로필 필드
18. 게시판 분류
19. 게시판 관리
20. 게시글 관리
21. 댓글 관리
22. 첨부파일
23. 공지사항
24. FAQ
25. Q&A
26. 팝업 관리
27. 배너 관리
28. 페이지 관리
29. 템플릿 관리
30. 위젯 관리
31. 코드 그룹
32. 공통코드
33. 이용약관
34. 개인정보처리방침
35. 이메일 템플릿
36. SMS 템플릿
37. 발송 이력
38. 파일 관리
39. 미디어 라이브러리
40. 통합 검색
41. 접근 로그
42. 감사 로그
43. 운영 통계
44. 방문 통계
45. 콘텐츠 통계
46. 스케줄러
47. 백업 설정
48. API 키
49. API 접근 로그
50. 점검 모드

## 구조

- `FeatureCatalog`: 50개 기능 정의
- `CmsItem`: 기능별 공통 데이터 모델
- `CmsItemService`: eGovFrame `EgovAbstractServiceImpl` 기반 공통 서비스
- `AdminController`: 50개 기능의 공통 CRUD 라우팅
- `templates`: 관리자 UI
- `demo-static/index.html`: 서버 없이 열어보는 정적 인터랙티브 데모

## 운영 확장 권장

실제 납품형 CMS에서는 `members`, `roles`, `permissions`, `menus`, `boards`, `posts` 등 핵심 도메인을 별도 테이블/서비스로 분리하고, MySQL/PostgreSQL 전환, 파일 스토리지, 감사로그, 개인정보 마스킹, 승인 워크플로, 배포 환경별 설정을 추가하는 구성을 권장합니다.
