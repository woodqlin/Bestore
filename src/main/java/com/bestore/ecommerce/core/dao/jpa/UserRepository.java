package com.bestore.ecommerce.core.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bestore.ecommerce.core.entity.db.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	public UserEntity findByEmail(String email);
} 
