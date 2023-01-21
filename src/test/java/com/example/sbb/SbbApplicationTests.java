package com.example.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.sbb.answer.Answer;
import com.example.sbb.answer.AnswerRepository;
import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionRepository;
import com.example.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionService questionService;

	@Test
	void generateTestCases(){
		for (int i = 1; i<= 300; i++){
			String subject = String.format("Test data : [%03d]", i);
			String content = "blank";
			this.questionService.create(subject, content);
		}
	}

	@Test
	void testJpa(){

		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("Yes, Ids are auto-generated in Spring Boot.");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);

		/*
		Question q = this.questionRepository.findBySubject("What is sbb?");
		assertEquals(1, q.getId());

		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("What is sbb?", q.getSubject());

		Question q1 = new Question();
		q1.setSubject("What is sbb?");
		q1.setContent("I would like to know what it is.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1); // save first question

		Question q2 = new Question();
		q2.setSubject("Question about Spring Boot model");
		q2.setContent("Are Ids auto-generated?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2); // save second question
		 */

	}

}
