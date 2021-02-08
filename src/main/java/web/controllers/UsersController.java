package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAOImpl;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;


//    public UsersController(UserServiceImpl userService) {
//        this.userService = userService;
//    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }



    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {

        return "users/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user")
                             @Valid User user, BindingResult result) {
        if (result.hasErrors())
            return "users/new";

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model
            , @PathVariable("id") int id) {
        model.addAttribute("user1", userService.getById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")
                         @Valid User user,BindingResult result
            , @PathVariable("id") int id) {
        if(result.hasErrors())
            return "users/edit";

        userService.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }


}
