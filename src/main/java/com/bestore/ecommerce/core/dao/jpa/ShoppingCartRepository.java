package com.bestore.ecommerce.core.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bestore.ecommerce.core.entity.db.cart.ShoppingCartEntity;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCartEntity, Integer>{
//	public ShoppingCartEntity findByCart__id(int user_id);
}
