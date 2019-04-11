package com.ds.uninassau.agenda.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.uninassau.agenda.entity.Contact;
import com.ds.uninassau.agenda.repository.Repository;

@RestController
@RequestMapping("/api")
public class RestContactController {

	
	private Repository repository; 
	
	
      public RestContactController(Repository repository) {
		this.repository = repository;
	} 
      


	
	@GetMapping("/contacts")
	public @ResponseBody List<Contact> getContactAPI(){
               System.out.println("LIST CONTACTS REST");
		return repository.listAll();
}
	
}
