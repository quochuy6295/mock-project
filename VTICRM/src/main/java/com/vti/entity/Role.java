package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vti.entity.enumerate.RoleName;
import com.vti.entity.enumerate.RoleNameConvert;

@Entity
@Table(name = "`Role`", catalog = "vtiCRM")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "RoleId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short roleId;

	@Column(name = "RoleName", nullable = false, unique = true)
	@Convert(converter = RoleNameConvert.class)
	private RoleName name;

	@OneToMany(mappedBy = "role")
	private List<User> users;

	public short getRoleId() {
		return roleId;
	}

	public void setRoleId(short roleId) {
		this.roleId = roleId;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName roleName) {
		name = roleName;
	}
	
	@Override
	public String toString() {
		return "Role [RoleName=" + name + "]";
	}

}
