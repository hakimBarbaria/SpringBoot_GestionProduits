package com.iset.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role { 
 @Id
 @Column(name = "role_id") 
 @GeneratedValue(strategy = GenerationType.IDENTITY) 
 private Integer id; 
 private String name;
public Role(String name) {
	super();
	this.name = name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Role() {
	super();
} 
 
 
 
 
} 