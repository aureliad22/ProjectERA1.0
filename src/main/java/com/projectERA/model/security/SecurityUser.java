package com.projectERA.model.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name = "securityUser")
@Inheritance
public class SecurityUser {
	@Id
	private String userName;
	
	private String password;
	private Boolean enabled;

	/**
	 * @return the username
	 */
	protected String getUserName() {
		return userName;
	}
	/**
	 * @param username the username to set
	 */
	protected void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	protected String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	protected void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the enabled
	 */
	protected Boolean getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	protected void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
