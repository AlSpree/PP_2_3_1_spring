package al.spree.spring_mvc_jpa_hib.controllers;

import al.spree.spring_mvc_jpa_hib.models.User;
import al.spree.spring_mvc_jpa_hib.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "show-all";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        User ourUser = userService.findUser(id);
        model.addAttribute("foundIdUser", ourUser);
        return "user-info";
    }

    @GetMapping("/new")
    public String newUSer(@ModelAttribute("newUser") User user) {
        return "create";
    }

    @PostMapping()
    public String create(@ModelAttribute("myUser") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("myUser", userService.findUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("myUserUpdate") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
