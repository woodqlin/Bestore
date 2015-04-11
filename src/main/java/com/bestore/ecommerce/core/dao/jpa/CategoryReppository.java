package com.bestore.ecommerce.core.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bestore.ecommerce.core.entity.db.CategoryEntity;


@Repository
public interface CategoryReppository extends CrudRepository<CategoryEntity, Integer>{
	
}
