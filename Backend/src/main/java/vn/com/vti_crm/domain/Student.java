package vn.com.vti_crm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fullName", nullable = false, length = 30)
	private String fullName;

	@Column(name = "gender", length = 30, nullable = false) // chua mapping duoc enum
	private String gender;

	@Column(name = "phone_number", nullable = false, length = 15, unique = true)
	private String phonenumber;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Column(name = "birthday", length = 50)
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreationTimestamp
	private String birthday; // chua mapping duoc birthday

	@Column(name = "school", length = 50)
	private String school;

	@Column(name = "address", length = 50)
	private String address;

	@Column(name = "social_info", length = 50)
	private String social_info;

	@Column(name = "target", length = 20)
	private String target;

	@Column(name = "status", length = 20)
	private String status;

	@Column(name = "history_transaction", length = 100)
	private String historyTrasacition;

	@Column(name = "source", length = 20) // chua mapping duoc enum
	private String source;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Student() {
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSocial_info() {
		return social_info;
	}

	public void setSocial_info(String social_info) {
		this.social_info = social_info;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHistoryTrasacition() {
		return historyTrasacition;
	}

	public void setHistoryTrasacition(String historyTrasacition) {
		this.historyTrasacition = historyTrasacition;
	}

	public Student(String fullName, String gender, String phonenumber, String email, String birthday, String school,
			String address, String social_info, String target, String status, String historyTrasacition,
			String source) {
		this.fullName = fullName;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.email = email;
		this.birthday = birthday;
		this.school = school;
		this.address = address;
		this.social_info = social_info;
		this.target = target;
		this.status = status;
		this.historyTrasacition = historyTrasacition;
		this.source = source;

	}

}
