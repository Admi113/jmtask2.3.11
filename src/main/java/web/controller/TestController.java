package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;

@Controller
public class TestController {

    @RequestMapping("/1")
    public String startPageView(){
        return "index";
    }
     @RequestMapping("/")
    public String viewTestPage(Model model){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("testview");
        User user = new User("Name","Surname",123);
        model.addAttribute("data",user);

        return "testview";
    }

}
