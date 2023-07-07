package com.example.productdevelopment.Controller;

import com.example.productdevelopment.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title","Olympic Games");
        return "user/index";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title","Contact Us");
        return "user/contact";
    }
    @GetMapping("/gameNews")
    public String gameSchedule(Model model) {
        model.addAttribute("title","Game & Schedule");
        return "user/gameNews";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title","About Us");
        return "user/about";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title","Login");
        model.addAttribute("user", new User());
        return "user/login";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("title","Register");
        model.addAttribute("user", new User());
        return "user/register";
    }
    @GetMapping("/live")
    public String live(Model model) {
        model.addAttribute("title","G0 Live");
        return "user/live";
    }

    @GetMapping("/liveVideo")
    public String liveVideo(Model model) {
        model.addAttribute("title","Live Streaming");
        return "user/liveVideo";
    }
    @GetMapping("/footballLive")
    public String footballLive(Model model) {
        model.addAttribute("title","Football Live");
        return "user/footballLive";
    }
    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("title","Logout");
        return "user/index";
    }

}
