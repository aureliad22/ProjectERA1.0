package com.projectERA.utils;

import java.util.ArrayList;

public class LdapConfig {
	private String ldapContextFactory;
	private String ldapServerURL;
	private String ldapAuthenticationMode;
	private String ldapUser;
	private String ldapPassword;
	private String ldapBaseDN;

	/**
	 * Constructeur du singleton Ldap
	 */
	private LdapConfig() {
		
	}

	private static LdapConfig INSTANCE = null;

	public static synchronized LdapConfig getInstance() {
		if (INSTANCE == null) {
			ArrayList<LdapConfig> configs = JsonManager.getInstance().
					<LdapConfig>readFromFile("ldapConfig.json","./json/", LdapConfig.class);

			for (LdapConfig ldapConfig : configs) {
				INSTANCE = ldapConfig;
			}
		}
		return INSTANCE;
	}

	/**
	 * @return the ldapContextFactory
	 */
	public String getLdapContextFactory() {
		return ldapContextFactory;
	}

	/**
	 * @param ldapContextFactory the ldapContextFactory to set
	 */
	public void setLdapContextFactory(String ldapContextFactory) {
		this.ldapContextFactory = ldapContextFactory;
	}

	/**
	 * @return the ldapServerURL
	 */
	public String getLdapServerURL() {
		return ldapServerURL;
	}

	/**
	 * @param ldapServerURL the ldapServerURL to set
	 */
	public void setLdapServerURL(String ldapServerURL) {
		this.ldapServerURL = ldapServerURL;
	}

	/**
	 * @return the ldapAuthenticationMode
	 */
	public String getLdapAuthenticationMode() {
		return ldapAuthenticationMode;
	}

	/**
	 * @param ldapAuthenticationMode the ldapAuthenticationMode to set
	 */
	public void setLdapAuthenticationMode(String ldapAuthenticationMode) {
		this.ldapAuthenticationMode = ldapAuthenticationMode;
	}

	/**
	 * @return the ldapUser
	 */
	public String getLdapUser() {
		return ldapUser;
	}

	/**
	 * @param ldapUser the ldapUser to set
	 */
	public void setLdapUser(String ldapUser) {
		this.ldapUser = ldapUser;
	}

	/**
	 * @return the ldapPassword
	 */
	public String getLdapPassword() {
		return ldapPassword;
	}

	/**
	 * @param ldapPassword the ldapPassword to set
	 */
	public void setLdapPassword(String ldapPassword) {
		this.ldapPassword = ldapPassword;
	}

	/**
	 * @return the ldapBaseDN
	 */
	public String getLdapBaseDN() {
		return ldapBaseDN;
	}

	/**
	 * @param ldapBaseDN the ldapBaseDN to set
	 */
	public void setLdapBaseDN(String ldapBaseDN) {
		this.ldapBaseDN = ldapBaseDN;
	}
}
