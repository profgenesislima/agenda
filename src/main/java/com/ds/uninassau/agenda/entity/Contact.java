package com.ds.uninassau.agenda.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="CONTACT")
@Data
@ToString(exclude={"address"})
public class Contact {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	private String name;
	private String email;
	private String phone;
	private String cellPhone;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Address address;
}
