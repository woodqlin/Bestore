package com.bestore.ecommerce.core.entity.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "address")
public class AddressEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int address_id;
	@ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference
    private UserEntity user;
	private String firstname;
	private String lastname;
	private String company;
	private String address_1;
	private String address_2;
	private String city;
	private String postcode;
	private int country_id;
	private int zone_id;
	/*
	 * 
	 */
	@Lob
	@Column(columnDefinition="TEXT")
	private String custom_field;
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public int getZone_id() {
		return zone_id;
	}
	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}
	public String getCustom_field() {
		return custom_field;
	}
	public void setCustom_field(String custom_field) {
		this.custom_field = custom_field;
	}
    public Integer getId() {
        return address_id;
    }
    public void setId(int id) {
        this.address_id = id;
    }
}
