package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("user") User user){
        return "/new";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.get(id));
        return "/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.get(id));
        return "/edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }
}
