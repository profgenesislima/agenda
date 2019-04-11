package br.ds.uninassau.agenda.repository;

import java.util.List;

public interface Repository<T>{
	
	void save(T t);
	
	List<T> listAll();
	
	T getById(int id);
	
	void remove(int id);
	
	void remove(T t);

}
