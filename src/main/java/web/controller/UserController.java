package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {


    private final UserService userService;
    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = {"/", "/index"})
    public String index (Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "index";
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable(value = "id") long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser (@PathVariable(value = "id") long id, @ModelAttribute("User") User user) {
        userService.update(user, id);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String getUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/update";
    }

    @GetMapping("/user")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "user";
    }
    @PostMapping("/user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
}
