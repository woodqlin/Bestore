package com.bestore.ecommerce.core.dao.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bestore.ecommerce.core.entity.db.cart.CartProductItemEntity;

@Repository
public interface ShoppingCartRepository extends CrudRepository<CartProductItemEntity, Integer>{
	public List<CartProductItemEntity> findByUserid(int user_id);
	
}
