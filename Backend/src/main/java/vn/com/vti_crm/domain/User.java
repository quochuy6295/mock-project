package vn.com.vti_crm.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.com.vti_crm.domain.enumerate.Role;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;

	@JsonIgnore
	// bi-directional many-to-one association to Student
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Student> students;

	// bi-directional many-to-one association to Team
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id")
	private Team team;

	public User() {
	}

	/**
	 * @param email
	 * @param name
	 * @param password
	 * @param role
	 */
	public User(String email, String name, String password, Role role) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param password
	 * @param role
	 * @param team
	 */
	public User(int id, String email, String name, String password, Role role, Team team) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.team = team;
	}

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param password
	 * @param role
	 * @param students
	 * @param team
	 */
	public User(int id, String email, String name, String password, Role role, List<Student> students, Team team) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.students = students;
		this.team = team;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setUser(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setUser(null);

		return student;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}