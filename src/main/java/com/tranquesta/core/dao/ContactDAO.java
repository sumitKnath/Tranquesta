package com.tranquesta.core.dao;

import java.util.List;

import com.tranquesta.core.model.hibernate.Contact;



public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
