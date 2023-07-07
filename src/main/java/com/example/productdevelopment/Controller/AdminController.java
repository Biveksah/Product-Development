package com.example.productdevelopment.Controller;

import com.example.productdevelopment.Dao.UserRepository;
import com.example.productdevelopment.Entity.User;

import com.example.productdevelopment.Service.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    private final UserServices userServices;
    private final UserRepository userRepository;

    public AdminController(UserServices userServices, UserRepository userRepository) {
        this.userServices = userServices;
        this.userRepository = userRepository;

    }

   // delete user bu user id
    @GetMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userServices.deleteUser(userId);
        return "redirect:/userList";
    }
    @GetMapping("/editUser/{userId}")
    public String editUser(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userServices.getUserById(userId));
        model.addAttribute("title", "Edit User");
        return "admin/editForm";
    }
    @PostMapping("/updateUser")
    public String updateUser(User user, Model model) {
        model.addAttribute("user", new User());
        // print email
        System.out.println(userServices.findByEmail(user.getEmail()));
        userServices.updateUser(user);
        return "redirect:/userList";
    }

}

