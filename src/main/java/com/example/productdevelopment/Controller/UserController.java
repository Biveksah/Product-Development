package com.example.productdevelopment.Controller;


import com.example.productdevelopment.Dao.CommentRepository;
import com.example.productdevelopment.Entity.Comment;
import com.example.productdevelopment.Entity.User;
import com.example.productdevelopment.Service.UserServices;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private final UserServices userServices;
    private final CommentRepository commentRepository;

    public UserController(UserServices userServices, CommentRepository commentRepository) {
        this.userServices = userServices;
        this.commentRepository = commentRepository;
    }


    // Register the user
    @PostMapping("/register")
    public String doRegister(@Valid User user, BindingResult result, Model model) {
        model.addAttribute("user", user);
        User resultUser = userServices.findByEmail(user.getEmail());
        if (resultUser != null) {
            result.rejectValue("email", "error", "There is already a user registered with that email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "user/register";
        }
        userServices.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String doLogin(User user, BindingResult result, Model model) {
        model.addAttribute("user", user);
        User resultUser = userServices.findByEmail(user.getEmail());
        System.out.println(resultUser);
        return "redirect:/";
    }

    @PostMapping("/comment")
    public String doComments(Comment comment, Model model) {
        model.addAttribute("comment", comment);
        commentRepository.save(comment);
        return "user/liveVideo";
    }


}
