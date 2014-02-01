package com.tranquesta.core.dao.hibernateimpl;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.tranquesta.core.dao.QuizDAO;
import com.tranquesta.core.model.hibernate.Contact;
import com.tranquesta.core.model.hibernate.Quiz;

@Repository
public class QuizDAOImpl implements QuizDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addContact(Quiz quiz) {
		sessionFactory.getCurrentSession().save(quiz);
	}

	@Override
	public List<Quiz> listQuiz() {
		return sessionFactory.getCurrentSession().createQuery("from Quiz").list();
	}	
}
