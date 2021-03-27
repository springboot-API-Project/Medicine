package com.medicine.check.controller.list;

import com.medicine.check.service.list.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor    // 생성자 주입
public class ListController {

    private final ListService listService;

    @RequestMapping("list")
    public String list() {
        return "listing";
    }

    @RequestMapping("list-detail")
    public String list_detail() {
        return "listing-details";
    }
}
