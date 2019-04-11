package br.ds.uninassau.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ds.uninassau.agenda.entity.Contact;
import br.ds.uninassau.agenda.repository.ContactRepository;


@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	public void saveContact(Contact contact){
		contactRepository.save(contact);
	}
	
	public List<Contact> getAllContacts(){
		
		return contactRepository.listAll();
	}

	public Contact getContactById(int id){
		return contactRepository.getById(id);
	}
	
	public void removeContact(int id){
		contactRepository.remove(id);
	}
	
}
