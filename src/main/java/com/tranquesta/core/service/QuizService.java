package com.tranquesta.core.service;

import java.util.List;

import com.tranquesta.core.model.hibernate.Contact;
import com.tranquesta.core.model.hibernate.Quiz;



public interface QuizService {
	
	public void addQuiz(Quiz quiz);
	public List<Quiz> listQuiz();
}
