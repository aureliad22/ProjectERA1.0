package com.projectERA.utils;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import com.projectERA.model.User;

public class UserLdap {
	private LdapContext ctx;

    public UserLdap() {
    	LdapUtils ldu= new LdapUtils();
        this.ctx = ldu.getLdapContext();
        System.out.println(ctx == null);
    }

    public List<User> getUsers() {
        ArrayList<User> users = null;
        try {
            SearchControls constraints = new SearchControls();
            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);

            String search = "(ObjectClass=User)";

            NamingEnumeration<SearchResult> userAnswer = ctx.search(LdapUtils.LDAP_BASE_DN, search, constraints);

            users = new ArrayList<User>();
            while (userAnswer.hasMoreElements()) {
                SearchResult result = (SearchResult) userAnswer.next();
                Attributes attrs = result.getAttributes();

                if (attrs != null) {
                    users.add(this.attToUser(attrs));
                }
            }
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return users;
    }

    private User attToUser(Attributes attributes) {
        User user = null;
        try {
            user = new User();

            Attribute guid = attributes.get(LdapUtils.ATTRIBUTE_GUID);
            Attribute firstname = attributes.get(LdapUtils.ATTRIBUTE_FIRSTNAME);
            Attribute lastname = attributes.get(LdapUtils.ATTRIBUTE_LASTNAME);
            Attribute displayName = attributes.get(LdapUtils.ATTRIBUTE_DISPLAYNAME);
            Attribute email = attributes.get(LdapUtils.ATTRIBUTE_EMAIL);

            if (guid != null) {
                user.setLdapGUID(LdapUtils.convertToBindingString( (byte[])guid.get(0)));
            }

            if (firstname != null) {
                user.setFirstName(firstname.get().toString());
            }

            if (lastname != null) {
                user.setLastName(lastname.get().toString());
            }

            if (displayName != null) {
                user.setDisplayName(displayName.get().toString());
            }

            if (email != null) {
                user.setEmail(email.get().toString());
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return user;
    }
}
