package com.bestore.ecommerce.core.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bestore.ecommerce.core.entity.db.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
	public UserEntity findByEmail(String email);
} 
