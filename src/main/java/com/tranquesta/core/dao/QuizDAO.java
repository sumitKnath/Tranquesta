package com.tranquesta.core.dao;

import java.util.List;

import com.tranquesta.core.model.hibernate.Quiz;



public interface QuizDAO {
	
	public void addContact(Quiz quiz);
	public List<Quiz> listQuiz();
}
