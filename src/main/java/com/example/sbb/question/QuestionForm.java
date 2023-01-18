package com.example.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "You must enter subject.")
    @Size(max = 200)
    private String subject;
    @NotEmpty(message = "You must enter content.")
    private String content;
}
