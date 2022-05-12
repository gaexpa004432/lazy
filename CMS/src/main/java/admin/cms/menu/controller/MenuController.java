package admin.cms.menu.controller;

import admin.cms.menu.domain.MenuVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

    @RequestMapping("/admin/menu")
    public String menuMain(MenuVO menuVO , Model model){

        return "menu/menu";
    }
}
