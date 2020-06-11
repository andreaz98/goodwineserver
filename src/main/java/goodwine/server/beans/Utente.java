package goodwine.server.beans;


import javax.persistence.*;

import java.io.Serializable;
/**
 * 
 * goodwine.beans contiene i bean per Hibernate
 *
 */

@Entity(name="UTENTI")
public class Utente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5351902087336563885L;

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	
	//accessors
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
