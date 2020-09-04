package com.vti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.vti.entity.primarykey.TeamUserKey;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
@Table(name = "TeamUser")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class TeamUser {

	@EmbeddedId
	private TeamUserKey key;

	@ManyToOne
	@MapsId("UserId")
	@JoinColumn(name = "UserId")
	private User user;

	@ManyToOne
	@MapsId("id")   // property trong java
	@JoinColumn(name = "TeamId")  // property trong database
	private Team team;

	@Column(name = "JoinDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date JoinDate;

	public TeamUser(TeamUserKey key, User user, Team team, Date joinDate) {
		this.key = key;
		this.user = user;
		this.team = team;
		JoinDate = joinDate;
	}

	public TeamUserKey getKey() {
		return key;
	}

	public void setKey(TeamUserKey key) {
		this.key = key;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Date getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}

	public TeamUser() {
	}

	@Override
	public String toString() {
		return "TeamUser [key=" + key.getTeamId() + ", user=" + user.getFullName() + ", team=" + team.getName() + ", JoinDate=" + JoinDate + "]";
	}
	
	
}
