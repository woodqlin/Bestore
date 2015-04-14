package com.bestore.ecommerce.core.entity.db.cart;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

import com.bestore.ecommerce.core.entity.db.ProductEntity;
import com.bestore.ecommerce.core.entity.db.UserEntity;


@Entity
@Table(name = "shopingcart")
public class ShoppingCartEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    private int cart_id;
    
    @OneToOne()
    @JoinColumn(name="userid")
    private UserEntity user;
    
    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @IndexColumn(name="id")
    private List<CartProductItemEntity> products;
    /*
     * 
     */

	public UserEntity getUser() {
		return user;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CartProductItemEntity> getProducts() {
		return products;
	}

	public void setProducts(List<CartProductItemEntity> products) {
		this.products = products;
	}
}
