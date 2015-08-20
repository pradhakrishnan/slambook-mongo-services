package org.slambook.mongoservices.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Document(collection = "slambookusers")
public class SlamBookUser implements SlamBookData, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String username;

	private String firstname;

	private String lastname;

	private String email;

	private String role;

	private String password;
	
	private String gender;
	
	private Date lastLoginDt;

	@DBRef
	private Set<SlamBookUser> friends;

	public Set<SlamBookUser> getFriends() {
		return friends;
	}

	public void setFriends(Set<SlamBookUser> friends) {
		this.friends = friends;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString(){
		return "User with firstname "+ firstname + " and lastname "+ lastname + " with email "+ email;
	}
}
