package com.bestore.ecommerce.core.entity.db.highlight;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bestore.ecommerce.core.entity.db.ProductEntity;

@Entity
@Table(name = "highmodule")
public class HighModuleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int order;
	private int layout_id;
	@OneToMany(fetch = FetchType.EAGER)
	private List<ProductEntity> products;
	/*
	 * 
	 */
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getLayout_id() {
		return layout_id;
	}
	public void setLayout_id(int layout_id) {
		this.layout_id = layout_id;
	}
	public List<ProductEntity> getProducts() {
		return products;
	}
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
