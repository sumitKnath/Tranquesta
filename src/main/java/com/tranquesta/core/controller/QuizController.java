package com.tranquesta.core.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;


import com.google.gson.Gson;

import com.tranquesta.core.model.hibernate.Contact;
import com.tranquesta.core.model.hibernate.Quiz;
import com.tranquesta.core.service.ContactService;
import com.tranquesta.core.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@RequestMapping(value="/addByRequestParam", method = RequestMethod.GET)
	public String addByRequestParam(@RequestParam("quizName") String quizName,ModelMap model) {
 
		Quiz q = new Quiz();
		q.setQuizName(quizName);
		quizService.addQuiz(q);
		model.addAttribute("message", quizName + " Added successfully");
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
//		return "mobile/added";
		return "redirect:/quiz/listQuestion";
 
	}
	
	@RequestMapping("/addByPathVariable/{quizName}")
	public String addByPathVariable(@PathVariable("quizName")
	String quizName,ModelMap model) {
		Quiz q = new Quiz();
		q.setQuizName(quizName);
		quizService.addQuiz(q);
		model.addAttribute("message", quizName + " Added successfully");
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
//		return "mobile/added";
		return "redirect:/quiz/listQuestion";
		
		

		//return "redirect:/index";
	}
	@RequestMapping(value="/listQuestion", method = RequestMethod.GET)
	public String listQuestion(ModelMap model) {
 		Gson gson = new Gson();
		String json = gson.toJson(quizService.listQuiz());
		model.addAttribute("message", json);
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "/mobile/list";
 
	}
//	
//	
//	@RequestMapping(value = "/hi", method = RequestMethod.GET)
//	  public String hi(@RequestParam("name") String name, ModelMap model) {
//	    String message = "Hi " + name + "!";
//	    model.addAttribute("message", message);
//	    return "hi";
//	  }
//	
//	@RequestMapping(value="/welcomehttp", method = RequestMethod.GET)
//	public String welcomehttp(@RequestParam("name") String name,ModelMap model) {
// 
//		Contact contact  = new Contact();
//		contact.setAddress("Address1");
//		contact.setDob(new java.util.Date());
//		contact.setEmail("snath@amdocs.com");
//		contact.setMobile("8983741507");
//		contact.setName("SUMIT");
//		
//		contactService.addContact(contact);
//		
//		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
// 
//		//Spring uses InternalResourceViewResolver and return back index.jsp
//		return "index";
// 
//	}
//
//	
//	@RequestMapping("/index")
//	public String listContacts(Map<String, Object> map) {
//
//		map.put("contact", new Contact());
//		map.put("contactList", contactService.listContact());
//
//		return "contact";
//	}
//
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addContact(@ModelAttribute("contact")
//	Contact contact, BindingResult result) {
//
//		contactService.addContact(contact);
//
//		return "redirect:/index";
//	}
//
//	@RequestMapping("/delete/{contactId}")
//	public String deleteContact(@PathVariable("contactId")
//	Integer contactId) {
//
//		contactService.removeContact(contactId);
//
//		return "redirect:/index";
//	}
//	
	
}
