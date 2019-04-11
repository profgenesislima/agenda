package com.ds.uninassau.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ds.uninassau.agenda.entity.Contact;
import com.ds.uninassau.agenda.repository.ContactRepositoryImpl;

@Controller
public class ContactController {
	
	
	@Autowired
	private ContactRepositoryImpl repo;
	

	@RequestMapping(path="/contato",method=RequestMethod.GET)
	public String setContact(Contact contact){
		
		return "contato";
	}
	
	
	@RequestMapping(path="/contatos", method=RequestMethod.POST)
	public ModelAndView addContact( Contact contato, ModelAndView modelAndView, RedirectAttributes redirectAttributes){		
		
		redirectAttributes.addAttribute("message", "Contato "+ contato.getName()+" adicionado com sucesso" );
			
		redirectAttributes.addFlashAttribute("contact", contato);		
	
		modelAndView.setViewName("redirect:/");
		
		repo.add(contato);
		
		return modelAndView;
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView listContacts(ModelAndView modelAndView){	
		
		List<Contact> contacts = this.repo.listAll();
		
		modelAndView.addObject("contacts",contacts);
		modelAndView.setViewName("lista-contatos");
		
		return modelAndView;	
	}
	
	@RequestMapping("/contato/editar/{id}")
	public ModelAndView editContact(@PathVariable(value="id", required=false) Integer id, ModelAndView modelAndView){
		modelAndView.addObject("contact", repo.findById(id));		
		modelAndView.setViewName("contato");
		return modelAndView;
	}
	
	@RequestMapping("/contato/remover/{id}")	
	public ModelAndView removeContact(@PathVariable("id") Integer id, ModelAndView modelAndView){	
		repo.removeById(id);
		modelAndView.addObject("message", "Contato removido com sucesso!");
		modelAndView.setViewName("redirect:/");
		return modelAndView;
		
	}
}
