/**
 * If you really care for the license, look for the LICENSE.txt at the project root. Frankly, I 
 * really don't care.
 **/
package com.example.starter.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * This class represents a JPA entity which is used to store role details.
 * 
 * @author Roshan Amadoru
 **/
@Entity
@Table(name="APP_ROLE")
public class Role implements Serializable {

	/**
	 * Randomly generated serialVersionUID
	 **/
	private static final long serialVersionUID = 1314324262194219402L;
	
	/**
	 * The unique rolename
	 **/
	@Id
	@Column(name="ROLENAME", nullable=false)
	private String roleName;
	
	/**
	 * The collection of users who are associated with the role
	 **/
	@ManyToMany(
		fetch=FetchType.LAZY,
		cascade = CascadeType.ALL)
	@JoinTable(
		name="APP_USER_ROLE",
		joinColumns=@JoinColumn(name="ROLENAME"),
		inverseJoinColumns=@JoinColumn(name="USERNAME"))
	private Collection<User> users;
	
	/**
	 * Reutrns the name of the role
	 * @return name of the role
	 **/
	public String getRoleName() {
		return this.roleName;
	}
	
	/**
	 * Sets the name of the role
	 * @param roleName name of the role
	 **/
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	/**
	 * Returns the collection of users associated to this role
	 * @returns the collection of users
	 **/
	public Collection<User> getUsers() {
		return this.users;
	}
	
	/**
	 * Sets the collection of users associated to this role
	 * @param users Collection of users
	 **/
	public void setUsers(Collection<User> users) {
		this.users = users;
	}

}
