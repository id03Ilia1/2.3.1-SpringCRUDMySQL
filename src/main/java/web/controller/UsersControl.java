package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UsersControl {
    private final UserService userService;
    @Autowired
    public UsersControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String all(Model model) {
        model.addAttribute("messages", userService.allread());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, ModelMap modelMap){
        modelMap.addAttribute("users",userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(ModelMap modelMap){
        modelMap.addAttribute("user",new User());
        return "new";
    }
    @PostMapping("/users")
    public String create(@ModelAttribute("users") User user) {
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/change")
    public String edit(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user",  userService.show(id));
        return "change";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}

