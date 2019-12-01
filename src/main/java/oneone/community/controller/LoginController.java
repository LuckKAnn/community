package oneone.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : lkk
 * @date : 13:46 2019/12/1
 * @creed: Talk is cheap,show me the code
 */
@Controller
public class LoginController {

    @GetMapping("/loginup")
    public String loginUp(){
        return  "loginup";
    }
}
