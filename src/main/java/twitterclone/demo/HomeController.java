package twitterclone.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", "User Account Created");
        }
        return "login";
    }

    @GetMapping("/add")
    public String addMessage(Model model) {
        model.addAttribute("message", new Message());
        return "addmessages";
    }

    @PostMapping("/process")
    public String processMessage(@Valid Message message, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/addmessages";
        }
        messageRepository.save(message);
        return "redirect:/";
    }
}


