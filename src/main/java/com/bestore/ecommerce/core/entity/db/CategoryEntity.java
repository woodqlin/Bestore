package com.bestore.ecommerce.core.entity.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int category_id;
	private String image;
	private int parent_id;
	@Column(columnDefinition = "tinyint", length = 1)
	private boolean top;
	@Column(name = "\"column\"")
	private int column;
	private int sort_order;
	@Column(columnDefinition = "tinyint", length = 1)
	private boolean status;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date_added;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date_modified;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	public CategoryDescriptionEntity categoryDescription;

	/*
	 * 
	 */
	@PrePersist
	protected void onCreate() {
		date_added = new Date();
		date_modified = date_added;
	}

	@PreUpdate
	protected void onUpdate() {
		date_modified = new Date();
	}

	public Integer getId() {
		return category_id;
	}

	public void setId(int id) {
		this.category_id = id;
		if (categoryDescription != null)
			categoryDescription.setCategory_id(id);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getSort_order() {
		return sort_order;
	}

	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public Date getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}

	public CategoryDescriptionEntity getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(
			CategoryDescriptionEntity categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
}