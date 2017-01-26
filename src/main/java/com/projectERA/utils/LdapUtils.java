package com.projectERA.utils;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LdapUtils {
    public static final String LDAP_BASE_DN = "DC=imie,DC=lan";
    public static final String ATTRIBUTE_LASTNAME = "sn";
    public static final String ATTRIBUTE_FIRSTNAME = "givenName";
    public static final String ATTRIBUTE_DISPLAYNAME = "displayName";
    public static final String ATTRIBUTE_EMAIL = "mail";
    public static final String ATTRIBUTE_GUID = "objectGUID";

	private Hashtable<String, String> env;

	
    public LdapContext getLdapContext() {
        LdapContext ctx = null;

		this.env = new Hashtable<String, String>();
		this.env.put(Context.INITIAL_CONTEXT_FACTORY, LdapConfig.getInstance().getLdapContextFactory());
		this.env.put(Context.PROVIDER_URL,
				LdapConfig.getInstance().getLdapServerURL());
		this.env.put(Context.SECURITY_AUTHENTICATION, LdapConfig.getInstance().getLdapAuthenticationMode());
		this.env.put(Context.SECURITY_PRINCIPAL, LdapConfig.getInstance().getLdapUser());
		this.env.put(Context.SECURITY_CREDENTIALS, LdapConfig.getInstance().getLdapPassword());
		this.env.put("java.naming.ldap.attributes.binary", "objectGUID");
		System.out.println(this.env);

        try {
            ctx = new InitialLdapContext(env, null);
            System.out.println(ctx == null);
        } catch (NamingException e) {
            System.err.println("Connection problem");
            e.printStackTrace();
        }

        return ctx;
    }
    
    public static String convertToByteString(byte[] objectGUID) {
        StringBuilder result = new StringBuilder();
 
        for (int i = 0; i < objectGUID.length; i++) {
            String transformed = prefixZeros((int) objectGUID[i] & 0xFF);
            result.append("\\");
            result.append(transformed);
        }
 
        return result.toString();
    }
 
    public static String convertToBindingString(byte[] objectGUID) {
        StringBuilder displayStr = new StringBuilder();
 
        displayStr.append("<GUID=");
        displayStr.append(convertToDashedString(objectGUID));
        displayStr.append(">");
 
        return displayStr.toString();
    }
 
    public static String convertToDashedString(byte[] objectGUID) {
        StringBuilder displayStr = new StringBuilder();
 
        displayStr.append(prefixZeros((int) objectGUID[3] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[2] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[1] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[0] & 0xFF));
        displayStr.append("-");
        displayStr.append(prefixZeros((int) objectGUID[5] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[4] & 0xFF));
        displayStr.append("-");
        displayStr.append(prefixZeros((int) objectGUID[7] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[6] & 0xFF));
        displayStr.append("-");
        displayStr.append(prefixZeros((int) objectGUID[8] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[9] & 0xFF));
        displayStr.append("-");
        displayStr.append(prefixZeros((int) objectGUID[10] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[11] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[12] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[13] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[14] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[15] & 0xFF));
 
        return displayStr.toString();
    }
 
    private static String prefixZeros(int value) {
        if (value <= 0xF) {
            StringBuilder sb = new StringBuilder("0");
            sb.append(Integer.toHexString(value));
 
            return sb.toString();
 
        } else {
            return Integer.toHexString(value);
        }
    }
}
