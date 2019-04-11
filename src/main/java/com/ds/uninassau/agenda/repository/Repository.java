package com.ds.uninassau.agenda.repository;

import java.util.List;

public interface Repository<T> {

	public void add(T t);
	public List<T> listAll();
	public T findById(int id);
	public void remove(T t);
	public void removeById(int id);
	
}
