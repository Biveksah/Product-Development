package com.example.productdevelopment.Controller;


import com.example.productdevelopment.Dao.ContactRepository;
import com.example.productdevelopment.Entity.User;
import com.example.productdevelopment.Service.UserServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
    private final UserServices userServices;
    private final ContactRepository contactRepository;

    public AdminPageController(UserServices userServices, ContactRepository contactRepository) {
        this.userServices = userServices;
        this.contactRepository = contactRepository;
    }


    @GetMapping("/adminDashboard")
    public String adminDashboard(Model model, User user) {
        model.addAttribute("title","Admin Dashboard");
        System.out.println(userServices.findByEmail(user.getEmail()));
        return "admin/adminDashboard";
    }

    @GetMapping("/uploadVideo")
    public String uploadVideo(Model model ) {
        model.addAttribute("title","Upload Video");
        return "admin/uploadVideo";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/account")
    public String account(Model model ) {
        model.addAttribute("title","Account");
        return "admin/account";
    }
    @RequestMapping ("/login")
    public String login(Model model){
        model.addAttribute("title","Login");
        return "user/login";
    }

    @GetMapping("/404")
    public String error(Model model){
        model.addAttribute("title","404");
        return "user/404";
    }
    @GetMapping("/userList")
    public String userList(Model model){
        model.addAttribute("title","User List");
        model.addAttribute("userList", userServices.getALLUsers());
        return "admin/userList";
    }
    @GetMapping("/forgotPassword")
    public String forgotPassword(Model model){
        model.addAttribute("title","Forgot Password");
        return "admin/forgotPassword";
    }

    @GetMapping("/contactList")
    public String contactList(Model model){
        model.addAttribute("title","Contact List");
        model.addAttribute("contactList", contactRepository.findAll());
        return "admin/contactList";
    }


    @GetMapping("/admin/contact")
    public String contact(){
        return "admin/contactList";
    }




}
