package vn.com.vti_crm.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@Table(name = "team")
@NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", nullable = false, length = 50, unique = true)
	private String name;
	
	@Column(name = "team_lead_id", nullable = false, unique = true)
	private int teamLeadId;

	@JsonIgnore
	// bi-directional many-to-one association to Student
	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
	private List<Student> students;

	@JsonIgnore
	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User> users;

	public Team() {
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param teamLeadId
	 * @param students
	 * @param users
	 */
	public Team(int id, String name, int teamLeadId, List<Student> students, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.teamLeadId = teamLeadId;
		this.students = students;
		this.users = users;
	}


	/**
	 * @param id
	 * @param name
	 * @param teamLeadId
	 * @param users
	 */
	public Team(int id, String name, int teamLeadId, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.teamLeadId = teamLeadId;
		this.users = users;
	}


	/**
	 * @param name
	 * @param teamLeadId
	 */
	public Team(String name, int teamLeadId) {
		super();
		this.name = name;
		this.teamLeadId = teamLeadId;
	}


	public int getTeamLeadId() {
		return teamLeadId;
	}

	public void setTeamLeadId(int teamLeadId) {
		this.teamLeadId = teamLeadId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setTeam(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setTeam(null);

		return student;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setTeam(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setTeam(null);

		return user;
	}

}