package com.tranquesta.core.service;

import java.util.List;

import com.tranquesta.core.model.hibernate.Contact;



public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
