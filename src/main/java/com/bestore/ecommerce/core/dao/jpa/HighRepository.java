package com.bestore.ecommerce.core.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bestore.ecommerce.core.entity.db.CategoryEntity;
import com.bestore.ecommerce.core.entity.db.highlight.HighModuleEntity;

@Repository
public interface HighRepository extends CrudRepository<HighModuleEntity, Integer>{
	
}