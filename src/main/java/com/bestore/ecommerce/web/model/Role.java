package com.bestore.ecommerce.web.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Role implements Serializable {

	private Long id;
	private String roleName;
	private String roleSign;
	private String description;
	private boolean enabled;
	private Date createDate;
	
	public Long getId() {
		return id;
	}
	public String getRoleSign() {
		return roleSign;
	}
	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}