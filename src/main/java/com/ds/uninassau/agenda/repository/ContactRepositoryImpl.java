package com.ds.uninassau.agenda.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.ds.uninassau.agenda.entity.Contact;

@Repository
@Transactional
public class ContactRepositoryImpl implements com.ds.uninassau.agenda.repository.Repository<Contact> {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public void add(Contact t) {
		entityManager.merge(t);		
		
	}




	@Override
	public List<Contact> listAll() {
		
		return entityManager.createQuery("select c from Contact c").getResultList();
		
	}




	@Override
	public Contact findById(int id) {
		return (Contact) entityManager.createQuery("select c from Contact c where c.id = "+id).getSingleResult();
	}




	@Override
	public void remove(Contact t) {
		entityManager.remove(t);
		
	}




	@Override
	public void removeById(int id) {
		entityManager.createQuery("delete from Contact c where c.id = "+id).executeUpdate();		
		
	}
	
	

	
	
	
}
