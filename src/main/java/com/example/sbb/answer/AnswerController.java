package com.example.sbb.answer;

import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionService;
import com.example.sbb.user.SiteUser;
import com.example.sbb.user.SiteUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerservice;

    private final SiteUserService userService;

    @PostMapping("/create/{id}")
    @PreAuthorize("isAuthenticated()")
    public String createAnswer(Model model, @PathVariable Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult,
                               Principal principal){
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()){
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerservice.create(question, answerForm.getContent(), siteUser);
        return String.format("redirect:/question/detail/%s", id);

    }

}
