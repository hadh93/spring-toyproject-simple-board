package com.example.sbb.answer;

import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerservice;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable Integer id, @RequestParam String content){
        Question question = this.questionService.getQuestion(id);
        this.answerservice.create(question, content);
        return String.format("redirect:/question/detail/%s", id);

    }

}
