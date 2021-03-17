package com.medicine.check.controller.blog;

import com.medicine.check.service.blog.BlogService;
import com.medicine.check.domain.blog.Blog;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller     // Bean 주입
@RequiredArgsConstructor    // 생성자
public class BlogController {
    // DI - 생성자 주입
    private final BlogService blogService;

    @RequestMapping("blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("blog-detail")
    public String blog_detail(@Param("blog_id") Long blog_id, Model model) {
        Blog blog = blogService.findById(blog_id);

        model.addAttribute("blog", blog);

        return "blog-details";
    }

    @RequestMapping("blog/save")
    public String save_form() {
        // Todo: 블로그 게시 폼 페이지 만들기
        return "";
    }
}
