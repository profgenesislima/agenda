package br.ds.uninassau.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ds.uninassau.agenda.entity.Contact;
import br.ds.uninassau.agenda.service.ContactService;

@Controller
public class ContactController {
	
	
	@Autowired
	private ContactService service;

	@RequestMapping("/")
	public ModelAndView getContacts(ModelAndView modelAndView){
		modelAndView .addObject("contacts", service.getAllContacts());
		modelAndView.setViewName("lista-contatos");
		System.out.println("LISTA CONTATO");
	return modelAndView;	
	
	}
	
	@RequestMapping(value="/contato", method=RequestMethod.POST)
	public ModelAndView setContact(Contact contact, ModelAndView modelAndView){		
		service.saveContact(contact);
		modelAndView.addObject("message", "Contato "+ contact.getName()+" salvo com sucesso!");
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	@RequestMapping("/contato")
	public ModelAndView setContact(ModelAndView modelAndView, Contact contact){
		modelAndView.addObject("contact", contact);
		modelAndView.setViewName("contato");
		return modelAndView;
	}
	
	@RequestMapping(value="/contato/editar/{id}")
	public ModelAndView editContact(ModelAndView modelAndView, @PathVariable int id){	
		modelAndView.addObject("contact", service.getContactById(id));
		modelAndView.setViewName("/contato");
		return modelAndView;
	}
	
	@RequestMapping("/api/contatos")
	public @ResponseBody List<Contact> getRestContacts(){		
	return service.getAllContacts();	
	
	}
	
	@RequestMapping("/contato/remover/{id}")
	public String removeContact(@PathVariable int id){
		service.removeContact(id);
		return "redirect:/";
	} 
	
//	@RequestMapping("/angular/contato")
//	public String angularContact(){	
//		return "/angular/main";
//	}
	
	
}
