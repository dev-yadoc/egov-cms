package kr.co.yadoc.cms.web;

import kr.co.yadoc.cms.domain.FeatureCatalog;
import kr.co.yadoc.cms.domain.FeatureMeta;
import kr.co.yadoc.cms.service.CmsItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    private final CmsItemService service;
    public AdminController(CmsItemService service){this.service=service;}
    @GetMapping("/") public String root(){return "redirect:/admin";}
    @GetMapping("/login") public String login(){return "login";}
    @GetMapping("/admin") public String dashboard(Model model){
        model.addAttribute("groups",FeatureCatalog.grouped());
        model.addAttribute("featureCount",FeatureCatalog.FEATURES.size());
        model.addAttribute("menuCount",service.count("menus"));
        model.addAttribute("memberCount",service.count("members"));
        model.addAttribute("postCount",service.count("posts"));
        return "dashboard";
    }
    @GetMapping("/admin/features/{code}") public String feature(@PathVariable String code,Model model){
        FeatureMeta feature=FeatureCatalog.find(code).orElseThrow();
        model.addAttribute("feature",feature);model.addAttribute("groups",FeatureCatalog.grouped());model.addAttribute("items",service.list(code));return "feature";
    }
    @PostMapping("/admin/features/{code}") public String create(@PathVariable String code,@RequestParam String title,@RequestParam(required=false) String content,@RequestParam(defaultValue="false") boolean enabled,@RequestParam(defaultValue="0") int sortOrder){
        FeatureCatalog.find(code).orElseThrow();service.create(code,title,content,enabled,sortOrder);return "redirect:/admin/features/"+code;
    }
    @PostMapping("/admin/features/{code}/{id}/update") public String update(@PathVariable String code,@PathVariable Long id,@RequestParam String title,@RequestParam(required=false) String content,@RequestParam(defaultValue="false") boolean enabled,@RequestParam(defaultValue="0") int sortOrder){
        service.update(id,code,title,content,enabled,sortOrder);return "redirect:/admin/features/"+code;
    }
    @PostMapping("/admin/features/{code}/{id}/delete") public String delete(@PathVariable String code,@PathVariable Long id){service.delete(id,code);return "redirect:/admin/features/"+code;}
}
