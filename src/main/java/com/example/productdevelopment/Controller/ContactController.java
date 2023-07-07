package com.example.productdevelopment.Controller;


import com.example.productdevelopment.Dao.ContactRepository;
import com.example.productdevelopment.Entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;

    }

    @PostMapping("/contact")
    public String contact(Contact contact, Model model) {
        model.addAttribute("title", "Contact Us");
        Contact contactModel = contactRepository.save(contact);
        return "user/contact";
    }

    @GetMapping("/deleteContact/{contactId}")
    public String deleteContact(@PathVariable Long contactId) {
        contactRepository.deleteById(contactId);
        return "redirect:/contactList";
    }
}
