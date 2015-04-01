package com.bestore.ecommerce.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Permission implements Serializable{
	private Long id;
	private String permissionSign;
	public String getPermissionSign() {
		return permissionSign;
	}
	public void setPermissionSign(String permissionSign) {
		this.permissionSign = permissionSign;
	}
	private String rescName;
	private String rescType;
	private String content;
	private boolean enabled;
	private Date createDate;
	private List<Role> Roles;
	
	public List<Role> getRoles() {
		return Roles;
	}
	public void setRoles(List<Role> roles) {
		Roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRescName() {
		return rescName;
	}
	public void setRescName(String rescName) {
		this.rescName = rescName;
	}
	public String getRescType() {
		return rescType;
	}
	public void setRescType(String rescType) {
		this.rescType = rescType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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