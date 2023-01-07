package com.example.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SbbApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa(){
		Question q = this.questionRepository.findBySubject("What is sbb?");
		assertEquals(1, q.getId());
		/*
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
