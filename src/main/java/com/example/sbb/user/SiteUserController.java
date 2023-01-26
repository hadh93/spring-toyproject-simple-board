package com.example.sbb.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class SiteUserController {
    private final SiteUserService userService;


    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("userCreateForm", new SiteUserCreateForm());

        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("userCreateForm") SiteUserCreateForm userCreateForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup_form";
        }

        if(!userCreateForm.getPassword().equals(userCreateForm.getPasswordConfirmation())){
            bindingResult.rejectValue("passwordConfirmation", "passwordIncorrect",
                    "Password and password confirmation does not match.");
            return "signup_form";
        }

        userService.create(userCreateForm.getUsername(),
                userCreateForm.getEmail(), userCreateForm.getPassword());

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }

}
