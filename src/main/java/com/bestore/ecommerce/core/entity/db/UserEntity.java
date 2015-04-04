package com.bestore.ecommerce.core.entity.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "oc_customer")
public class UserEntity extends BaseEntity<Integer>{
	/*
	 * 
	 */
	private int customer_group_id;
	private int store_id;
	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	private String fax;
	private String password;
	private String salt;
	@Lob
	@Column(columnDefinition="TEXT")
	private String cart;
	@Lob
	@Column(columnDefinition="TEXT")
	private String wishlist;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
	private List<AddressEntity> addresses;
	private String ip;
	@Column(columnDefinition = "BIT", length = 1)
	private boolean status;
	@Column(columnDefinition = "BIT", length = 1)
	private boolean approved;
	@Column(columnDefinition = "BIT", length = 1)
	private boolean safe;
	private String token;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date_added;
	
	public int getCustomer_group_id() {
		return customer_group_id;
	}
	public void setCustomer_group_id(int customer_group_id) {
		this.customer_group_id = customer_group_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCart() {
		return cart;
	}
	public void setCart(String cart) {
		this.cart = cart;
	}
	public String getWishlist() {
		return wishlist;
	}
	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}
	public List<AddressEntity> getAddresses() {
		if (addresses == null){
			addresses = new ArrayList<AddressEntity>();
		}
		return addresses;
	}
	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public boolean isSafe() {
		return safe;
	}
	public void setSafe(boolean safe) {
		this.safe = safe;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
}