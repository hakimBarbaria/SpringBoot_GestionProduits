package com.iset.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	public Role findByName(String name);
}
