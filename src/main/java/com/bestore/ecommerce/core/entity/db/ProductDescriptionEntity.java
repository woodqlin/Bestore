package com.bestore.ecommerce.core.entity.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "oc_product_description")
public class ProductDescriptionEntity implements Serializable{
    @Id
	private int product_id;

    private int language_id;
    private String name;
    @Lob
	@Column(columnDefinition="TEXT")
    private String description;
    @Lob
	@Column(columnDefinition="TEXT")
    private String tag;
    private String meta_title;
    private String meta_description;
    private String meta_keyword;
    /*
     * 
     */
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getMeta_title() {
		return meta_title;
	}
	public void setMeta_title(String meta_title) {
		this.meta_title = meta_title;
	}
	public String getMeta_description() {
		return meta_description;
	}
	public void setMeta_description(String meta_description) {
		this.meta_description = meta_description;
	}
	public String getMeta_keyword() {
		return meta_keyword;
	}
	public void setMeta_keyword(String meta_keyword) {
		this.meta_keyword = meta_keyword;
	}
}
