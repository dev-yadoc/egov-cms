package kr.co.yadoc.cms.domain;

import java.util.*;
import java.util.stream.Collectors;

public final class FeatureCatalog {
    private FeatureCatalog() {}
    public static final List<FeatureMeta> FEATURES = List.of(
        new FeatureMeta("dashboard","대시보드","운영 대시보드","CMS 핵심 지표와 최근 변경 현황"),
        new FeatureMeta("site-settings","기본설정","사이트 기본설정","사이트명, 도메인, 대표정보 관리"),
        new FeatureMeta("system-settings","기본설정","시스템 설정","시스템 공통 파라미터와 운영 옵션"),
        new FeatureMeta("environment","기본설정","환경 설정","개발/검수/운영 환경별 설정값"),
        new FeatureMeta("menus","메뉴","메뉴 관리","다단계 메뉴 등록, 수정, 노출 관리"),
        new FeatureMeta("menu-order","메뉴","메뉴 순서","메뉴 정렬 순서 관리"),
        new FeatureMeta("menu-visibility","메뉴","메뉴 노출","메뉴별 공개/비공개와 노출 조건"),
        new FeatureMeta("roles","권한","역할 관리","관리자/운영자 등 역할 정의"),
        new FeatureMeta("permissions","권한","권한 관리","기능 단위 접근 권한 정의"),
        new FeatureMeta("role-mapping","권한","역할-권한 매핑","역할별 기능 권한 연결"),
        new FeatureMeta("members","회원","회원 관리","회원 목록, 검색, 상태 관리"),
        new FeatureMeta("member-detail","회원","회원 상세","회원 기본정보와 활동정보"),
        new FeatureMeta("member-status","회원","회원 상태","정상/휴면/차단/탈퇴 상태 관리"),
        new FeatureMeta("password-reset","회원","비밀번호 초기화","관리자 비밀번호 초기화 이력"),
        new FeatureMeta("login-history","회원","로그인 이력","로그인 성공/실패 및 접속 이력"),
        new FeatureMeta("member-groups","회원","회원 그룹","회원 그룹과 분류 체계"),
        new FeatureMeta("profiles","회원","프로필 필드","추가 회원 프로필 항목 관리"),
        new FeatureMeta("board-categories","게시판","게시판 분류","게시판 카테고리 체계"),
        new FeatureMeta("boards","게시판","게시판 관리","게시판 생성과 운영정책"),
        new FeatureMeta("posts","게시판","게시글 관리","게시글 등록, 수정, 삭제, 공개"),
        new FeatureMeta("comments","게시판","댓글 관리","댓글 검수와 삭제"),
        new FeatureMeta("attachments","게시판","첨부파일","첨부파일 정책과 파일 메타데이터"),
        new FeatureMeta("notices","콘텐츠","공지사항","중요 공지와 상단 고정"),
        new FeatureMeta("faq","콘텐츠","FAQ","자주 묻는 질문 관리"),
        new FeatureMeta("qna","콘텐츠","Q&A","질문/답변 운영"),
        new FeatureMeta("popups","콘텐츠","팝업 관리","기간별 팝업 노출"),
        new FeatureMeta("banners","콘텐츠","배너 관리","배너 이미지/링크/순서"),
        new FeatureMeta("pages","콘텐츠","페이지 관리","정적 페이지와 랜딩 페이지"),
        new FeatureMeta("templates","콘텐츠","템플릿 관리","페이지/게시판 템플릿"),
        new FeatureMeta("widgets","콘텐츠","위젯 관리","화면 구성용 위젯"),
        new FeatureMeta("code-groups","공통코드","코드 그룹","공통코드 그룹 정의"),
        new FeatureMeta("codes","공통코드","공통코드","업무 공통코드 값 관리"),
        new FeatureMeta("terms","정책","이용약관","약관 버전과 시행일 관리"),
        new FeatureMeta("privacy","정책","개인정보처리방침","개인정보처리방침 버전 관리"),
        new FeatureMeta("email-templates","메시지","이메일 템플릿","발송 이메일 제목/본문 템플릿"),
        new FeatureMeta("sms-templates","메시지","SMS 템플릿","문자 메시지 템플릿"),
        new FeatureMeta("message-history","메시지","발송 이력","이메일/SMS 발송 결과"),
        new FeatureMeta("file-manager","파일","파일 관리","업로드 파일 탐색과 정리"),
        new FeatureMeta("media-library","파일","미디어 라이브러리","이미지/영상 리소스 메타데이터"),
        new FeatureMeta("search","검색","통합 검색","콘텐츠/회원/게시물 통합 검색 설정"),
        new FeatureMeta("access-logs","로그","접근 로그","관리자 화면 접근 기록"),
        new FeatureMeta("audit-logs","로그","감사 로그","중요 데이터 변경 이력"),
        new FeatureMeta("statistics","통계","운영 통계","운영지표 요약"),
        new FeatureMeta("visit-statistics","통계","방문 통계","일/월 방문과 유입 현황"),
        new FeatureMeta("content-statistics","통계","콘텐츠 통계","조회/등록/반응 지표"),
        new FeatureMeta("scheduler","운영","스케줄러","배치/예약 작업 관리"),
        new FeatureMeta("backup","운영","백업 설정","DB/파일 백업 정책"),
        new FeatureMeta("api-keys","API","API 키","외부연동용 키 발급과 상태"),
        new FeatureMeta("api-access-logs","API","API 접근 로그","API 호출 이력과 결과"),
        new FeatureMeta("maintenance","운영","점검 모드","서비스 점검 안내와 접근 제한")
    );
    public static Optional<FeatureMeta> find(String code) { return FEATURES.stream().filter(f -> f.code().equals(code)).findFirst(); }
    public static Map<String,List<FeatureMeta>> grouped() { return FEATURES.stream().collect(Collectors.groupingBy(FeatureMeta::group, LinkedHashMap::new, Collectors.toList())); }
}
