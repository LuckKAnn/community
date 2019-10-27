package oneone.community.controller;

import oneone.community.mapper.QuestionMapper;
import oneone.community.model.Question;
import oneone.community.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }


    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value="title",required=false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            HttpServletRequest request,
            Model model
                            ){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if (title == null||title==""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (tag == null||tag==""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        if (description == null||description==""){
            model.addAttribute("error","描述不能为空");
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        if (user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }else {
            question.setCreator(Integer.parseInt(user.getAccountId()));
        }
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";
    }
}