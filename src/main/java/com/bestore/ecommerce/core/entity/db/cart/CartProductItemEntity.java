package com.bestore.ecommerce.core.entity.db.cart;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bestore.ecommerce.core.entity.db.ProductEntity;


@Entity
@Table(name = "shoppingcart_item")
public class CartProductItemEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
	@OneToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	private int quantity;
	@Column(name="user_id")
	private int userid;
	/*
	 * 
	 */
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
