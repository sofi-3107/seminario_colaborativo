package com.uesiglo21.demo.entities;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
@ToString
public class Usuario {
	
	@Id @GeneratedValue
	private Integer id;
	
	@Column(length=20)
	private String userName;
	
	@Column(length=250)
	private String password;
	
	@Column
	private Role rol;
	
	

}
