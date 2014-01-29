package com.tranquesta.core.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tranquesta.core.dao.ContactDAO;
import com.tranquesta.core.model.hibernate.Contact;
import com.tranquesta.core.service.ContactService;

@Controller
@RequestMapping("/")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
 
		Contact contact  = new Contact();
		contact.setAddress("Address1");
		contact.setDob(new java.util.Date());
		contact.setEmail("snath@amdocs.com");
		contact.setMobile("8983741507");
		contact.setName("SUMIT");
		
		contactService.addContact(contact);
		
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
 
	}
	
	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "contact";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")
	Contact contact, BindingResult result) {

		contactService.addContact(contact);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId")
	Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/index";
	}
}
