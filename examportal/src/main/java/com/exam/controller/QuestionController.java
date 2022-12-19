package com.exam.controller;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Question;
import com.exam.model.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;


@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService Service;
	
	@Autowired
	private QuizService quizservice;
	
	
@PostMapping("/")
public ResponseEntity<Question> add(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.Service.addQuestion(question));
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.Service.updateQuestion(question));
		
	}
	
@GetMapping("/quiz/{qid}")
public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") long qid)
	{
	Quiz quiz = this.quizservice.getQuiz(qid);
		Set<Question> questions = quiz.getQuestions();
		List list=new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()));
		{
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
		
	}
	
@GetMapping("/{quesid}")
public  Question get(@PathVariable("quesid") long quesid)
		{
			return  this.Service.getQuestion( quesid);
		}
	
	@DeleteMapping("/{quesid}")
	public void delete(@PathVariable("quesid") long quesid)
	{
		this.Service.deleteQuestion(quesid);
	}
	
	
}
