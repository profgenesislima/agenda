package br.ds.uninassau.agenda.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.ds.uninassau.agenda.entity.Contact;

@org.springframework.stereotype.Repository
@Transactional
public class ContactRepository implements Repository<Contact> {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public void save(Contact contact) {
		entityManager.merge(contact);
		
	}


	@Override
	public List<Contact> listAll() {
		
		return entityManager.createQuery("select c from Contact c", Contact.class).getResultList();
	}


	@Override
	public Contact getById(int id) {		
		return entityManager.createQuery("select c from Contact c where c.id = "+id, Contact.class).getSingleResult();

	}


	@Override
	public void remove(int id) {
		entityManager.remove(getById(id));
		
	}


	@Override
	public void remove(Contact t) {
		// TODO Auto-generated method stub
		
	}

}
