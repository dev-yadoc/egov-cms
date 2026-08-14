package kr.co.yadoc.cms.config;

import kr.co.yadoc.cms.service.CmsItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoDataConfig {
    @Bean CommandLineRunner demoData(CmsItemService service){
        return args -> {
            if(service.count("site-settings")==0){
                service.create("site-settings","사이트명","eGovFrame CMS Demo",true,1);
                service.create("menus","서비스 소개","/about",true,10);
                service.create("menus","공지사항","/board/notice",true,20);
                service.create("roles","SUPER_ADMIN","전체 관리자 권한",true,1);
                service.create("members","홍길동","hong@example.com / 정상",true,1);
                service.create("boards","공지사항","공지 게시판 / 댓글 OFF / 첨부 ON",true,1);
                service.create("posts","CMS 데모 오픈","전자정부프레임워크 기반 CMS 데모가 준비되었습니다.",true,1);
            }
        };
    }
}
