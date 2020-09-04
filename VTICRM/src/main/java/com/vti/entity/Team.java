package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Team", catalog = "vtiCRM")
//@Getter
//@Setter
//@AllArgsConstructor

public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TeamId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TeamName", length = 50, nullable = false, unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "LeaderId", nullable = false)
	private User leader;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
	private List<TeamUser> users;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<TeamUser> getUsers() {
		return users;
	}

	public void setUsers(List<TeamUser> users) {
		this.users = users;
	}

	public Team() {
	}

	public Team(int id, String name, User leader, Date createDate, List<TeamUser> users) {
		this.id = id;
		this.name = name;
		this.leader = leader;
		this.createDate = createDate;
		this.users = users;
	}

	@Override
	public String toString() {
		return "Team [user=" + users + "]";
	}
}
