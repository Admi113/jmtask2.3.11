package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.models.User;
import web.service.UserServicee;


import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {


    UserServicee userServicee;

    @Autowired
    public UsersController(UserServicee userServicee) {
        this.userServicee = userServicee;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userServicee.getAllUsers());
        return "users/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServicee.getById(id));
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

        userServicee.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model
            , @PathVariable("id") int id) {
        model.addAttribute("user1", userServicee.getById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")
                         @Valid User user, BindingResult result
            , @PathVariable("id") int id) {
        if (result.hasErrors())
            return "users/edit";

        userServicee.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userServicee.delete(id);
        return "redirect:/users";
    }


}
