package com.bestore.ecommerce.core.entity.db.cart;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.bestore.ecommerce.core.entity.db.ProductEntity;
import com.bestore.ecommerce.core.entity.db.UserEntity;

public class CartEntity implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//	private int cart_id;
//    
//    @OneToOne(mappedBy = "user")
//    private UserEntity user;
//    
//    @OneToMany(mappedBy = "cart")
//    private List<ProductEntity> products;
//    
//    private int quantity;
//    
//    @OneToOne(mapppedBy = "product_attr")
}
