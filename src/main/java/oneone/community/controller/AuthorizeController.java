package oneone.community.controller;

import oneone.community.dto.AccessTokenDTO;
import oneone.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                    @RequestParam(name = "state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("83e7ee42167f84d10160");
        accessTokenDTO.setClient_secrit("34137539e5db91a99369d85c2fd9555ec74a871b");

        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
