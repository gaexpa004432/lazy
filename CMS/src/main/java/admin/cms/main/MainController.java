package admin.cms.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/admin/main")
    public String adminMain(Model model){

        return "main/main";
    };

}
