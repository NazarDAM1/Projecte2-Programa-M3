

import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class App {

	DirContext connection;

	/* create connection during object creation */
	public void newConnection() {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://192.168.18.105:389");
		env.put(Context.SECURITY_PRINCIPAL, "CN=Administrador,CN=Users,DC=Tarrega,DC=gim");
		env.put(Context.SECURITY_CREDENTIALS, "Fat/3232");
		try {
			connection = new InitialDirContext(env);
			System.out.println("Hello World!" + connection);
		} catch (AuthenticationException ex) {
			System.out.println(ex.getMessage());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public void addUser() {
		Attributes attributes = new BasicAttributes();
		Attribute attribute = new BasicAttribute("objectClass");
		
				
		attribute.add("inetOrgPerson");
		attributes.put(attribute);
		attributes.put("sn", "Ricky");
		attributes.put("uid", "nazar34");
		attributes.put("userPassword", "Fat/3232");
		attributes.put("givenName", "nazar34");
		attributes.put(attribute);
		// attributes.put("principalName", "nazar34");
		try {
			connection.createSubcontext("cn=nazar33222,CN=Users,DC=Tarrega,DC=gim", attributes);
			System.out.println("success");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
