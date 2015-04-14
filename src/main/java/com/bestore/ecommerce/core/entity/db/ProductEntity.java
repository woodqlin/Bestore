package com.bestore.ecommerce.core.entity.db;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "product")
public class ProductEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;

	// 商品型号
	private String model;
	// 库存单位
	private String sku;

	// 品牌商部分编码
	private String mpn;
	private String location;
	private int quantity;
	// 库存状态
	private int stock_status_id;
	private String image;
	// 品牌
	private int manufacturer_id;
	// 要求配送
	@Column(columnDefinition = "tinyint", length = 1)
	private boolean shipping;
	@Column(precision = 12, scale = 2)
	private BigDecimal price;
	// 积分换购，保留字段,v2
	private int points;
	// 商品税类，保留字段
	private int tax_class_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date_available;
	@Column(precision = 15, scale = 8)
	private BigDecimal weight;
	// 重量单位
	private int weight_class_id;
	@Column(precision = 15, scale = 8)
	private BigDecimal length;
	@Column(precision = 15, scale = 8)
	private BigDecimal width;
	@Column(precision = 15, scale = 8)
	private BigDecimal height;
	// 长度单位
	private int length_class_id;
	// 扣减库存
	@Column(columnDefinition = "tinyint", length = 1)
	private boolean subtract;
	// 最小起订数量?
	private int minimum;
	// 排序
	private int sort_order;
	// 启用/停用
	@Column(columnDefinition = "tinyint", length = 1)
	private boolean status;
	// 商品被浏览的次数
	private int viewed;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date_added;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date_modified;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private ProductDescriptionEntity productDescription;
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
		return product_id;
	}

	public void setId(int id) {
		this.product_id = id;
		if (productDescription != null)
			productDescription.setProduct_id(id);
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getMpn() {
		return mpn;
	}

	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStock_status_id() {
		return stock_status_id;
	}

	public void setStock_status_id(int stock_status_id) {
		this.stock_status_id = stock_status_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getManufacturer_id() {
		return manufacturer_id;
	}

	public void setManufacturer_id(int manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getTax_class_id() {
		return tax_class_id;
	}

	public void setTax_class_id(int tax_class_id) {
		this.tax_class_id = tax_class_id;
	}

	public Date getDate_available() {
		return date_available;
	}

	public void setDate_available(Date date_available) {
		this.date_available = date_available;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public int getWeight_class_id() {
		return weight_class_id;
	}

	public void setWeight_class_id(int weight_class_id) {
		this.weight_class_id = weight_class_id;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public int getLength_class_id() {
		return length_class_id;
	}

	public void setLength_class_id(int length_class_id) {
		this.length_class_id = length_class_id;
	}

	public boolean isSubtract() {
		return subtract;
	}

	public void setSubtract(boolean subtract) {
		this.subtract = subtract;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
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

	public int getViewed() {
		return viewed;
	}

	public void setViewed(int viewed) {
		this.viewed = viewed;
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

	public ProductDescriptionEntity getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(ProductDescriptionEntity productDescription) {
		this.productDescription = productDescription;
	}
	
}
