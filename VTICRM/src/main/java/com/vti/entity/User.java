package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Formula;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

@Entity
@Table(name = "`User`", catalog = "vtiCRM")
@Inheritance(strategy = InheritanceType.JOINED)
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "UserId")
	private int userId;

	@Column(name = "UserName", length = 50, nullable = false, unique = true)
	@NotBlank(message = "userName is not null")
	private String userName;

	@Column(name = "`Password`", length = 50, nullable = false)
	@NotBlank(message = "Password is not null")
	private String password;

	@Column(name = "FirstName", length = 50, nullable = false)
	@NotBlank(message = "FirstName is not null")
	private String firstName;

	@Column(name = "LastName", length = 50, nullable = false)
	@NotBlank(message = "LastName is not null")
	private String lastName;

	@Formula(" concat(FirstName, ' ' , LastName)")
	private String fullName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RoleId", nullable = false)
	private Role role;

	@OneToMany(mappedBy = "leader", fetch = FetchType.LAZY)
	private List<Team> leaders;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<TeamUser> users;

	public User(String userName) {
		this.userName = userName;
	}

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(String userName, String password, String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String userName, String password, String fullName, Role role) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
	}

	public User(String userName, String password, String firstName, String lastName, int roleId) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", Role=" + role + "]";
	}

}
