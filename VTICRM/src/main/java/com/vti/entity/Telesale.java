package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

@Entity
@Table(name = "Telesale", catalog = "vtiCRM")
@PrimaryKeyJoinColumn(name = "UserId")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Telesale extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Permission")
	private String permission;

	public String getPermission() {
		return permission;
	}

	public Telesale() {
		super();
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
