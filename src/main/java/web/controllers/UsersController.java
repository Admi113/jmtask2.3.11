package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.models.User;
import web.service.RoleService;
import web.service.UserServicee;

@Controller
@RequestMapping("/users")
public class UsersController {


    private UserServicee userServicee;

    @Autowired
    public UsersController(RoleService roleService, UserServicee userServicee) {
        this.userServicee = userServicee;
    }


    @GetMapping
    public String showUserInfo(Model model, Authentication authentication) {
        String userName = authentication.getName();
        User user = userServicee.getUserByName(userName);
        model.addAttribute("roles", user.getRolesList());
        model.addAttribute("user1", user);
        return "user/show";
    }


}
