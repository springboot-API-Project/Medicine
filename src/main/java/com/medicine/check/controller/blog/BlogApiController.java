package com.medicine.check.controller.blog;

import com.medicine.check.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("api/blog/save")
    public ModelAndView save() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("blog");

        return mav;
    }
}
