package admin.cms.test;

import admin.cms.menu.domain.MenuVO;
import admin.cms.token.JwtTokenProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class TestController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    private static final ObjectMapper objectMapper = new ObjectMapper();


    @RequestMapping("/admin/test")
    @ResponseBody
    public String menuMain(Model model, MenuVO menuVO, HttpServletRequest request, HttpSession session){

        String token = jwtTokenProvider.makeJwtToken();
        // 세션에 저장?
        session.setAttribute("token",token);
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("result","true");
        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    @RequestMapping("/admin/tokenRequest")
    public String token(Model model, HttpServletRequest request){
        return "test/token";
    }

}
