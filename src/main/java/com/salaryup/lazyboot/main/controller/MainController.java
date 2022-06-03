package com.salaryup.lazyboot.main.controller;

import com.salaryup.lazyboot.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping("/main")
    public String main(Model model, HttpServletRequest request, HttpSession session){

        return "main/main";
    }

}
