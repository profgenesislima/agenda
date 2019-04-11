package com.ds.uninassau.agenda.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ADDRESS")
@Data
public class Address {

	@Id
	private int id;
	private String streetName;
	private String zipCode;
	
	
	
	
}
