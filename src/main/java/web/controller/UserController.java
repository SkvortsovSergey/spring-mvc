package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String index (Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "index";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

//    @GetMapping(value = "/user")
//    public String addUser (Model model) {
//        return "user";
//    }
//
//    @GetMapping(value = "/update")
//    public String updateUser (Model model) {
//        return "update";
//    }

}
