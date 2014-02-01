package com.tranquesta.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tranquesta.core.dao.QuizDAO;
import com.tranquesta.core.model.hibernate.Contact;
import com.tranquesta.core.model.hibernate.Quiz;
import com.tranquesta.core.service.ContactService;
import com.tranquesta.core.service.QuizService;


@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDAO quizDAO;
	
	@Transactional
	public void addQuiz(Quiz quiz) {
		quizDAO.addContact(quiz);
		
	}

	@Transactional
	public List<Quiz> listQuiz() {
		return quizDAO.listQuiz();
	}
}
