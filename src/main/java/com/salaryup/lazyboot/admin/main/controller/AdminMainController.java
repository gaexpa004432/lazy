package com.salaryup.lazyboot.admin.main.controller;

import com.salaryup.lazyboot.board.domain.BoardVO;
import com.salaryup.lazyboot.board.service.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminMainController {

    @RequestMapping("/admin/main")
    public String adminMain(Model model){

        return "admin/main/main";
    };

}
