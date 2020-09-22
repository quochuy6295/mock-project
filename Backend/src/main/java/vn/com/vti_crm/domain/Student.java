package vn.com.vti_crm.domain;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.com.vti_crm.domain.enumerate.Gender;
import vn.com.vti_crm.domain.enumerate.Source;
import vn.com.vti_crm.domain.enumerate.Status;
import vn.com.vti_crm.domain.enumerate.Target;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name = "student")
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "full_name", nullable = false, length = 30)
	private String fullName;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;

	@Column(name = "phone_number", nullable = false, length = 15, unique = true)
	private String phoneNumber;

	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "birthday", nullable = true)
	private Date birthday;

	@Column(name = "school", nullable = true, length = 50)
	private String school;

	@Column(name = "address", nullable = true, length = 50)
	private String address;

	@Column(name = "social_info", nullable = true, length = 50)
	private String socialInfo;

	@Enumerated(EnumType.STRING)
	@Column(name = "target", nullable = false)
	private Target target;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 20)
	private Status status;

	@Column(name = "history_transaction", nullable = true, length = 100)
	private String historyTransaction;

	@Enumerated(EnumType.STRING)
	@Column(name = "source", nullable = false)
	private Source source;

	@JsonIgnore
	// bi-directional many-to-one association to Team
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id")
	private Team team;

	@JsonIgnore
	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "created_date")
	private Date createdDate;

	public Student() {
	}

	public Student(String fullName, Gender gender, String phoneNumber, String email, Date birthday, String school,
			String address, String socialInfo, Target target, Status status, String historyTransaction, Source source) {
		super();

		this.fullName = fullName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthday = birthday;
		this.school = school;
		this.address = address;
		this.socialInfo = socialInfo;
		this.target = target;
		this.status = status;
		this.historyTransaction = historyTransaction;
		this.source = source;
	}
	
	public Student(String fullName, Gender gender, String phoneNumber, String email, Date birthday, String school,
			String address, String socialInfo, Target target, Status status, String historyTransaction, Source source, Date createdDate) {
		super();

		this.fullName = fullName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthday = birthday;
		this.school = school;
		this.address = address;
		this.socialInfo = socialInfo;
		this.target = target;
		this.status = status;
		this.historyTransaction = historyTransaction;
		this.source = source;
		this.createdDate = createdDate;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSocialInfo() {
		return this.socialInfo;
	}

	public void setSocialInfo(String socialInfo) {
		this.socialInfo = socialInfo;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getHistoryTransaction() {
		return this.historyTransaction;
	}

	public void setHistoryTransaction(String historyTransaction) {
		this.historyTransaction = historyTransaction;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhonenumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Target getTarget() {
		return this.target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}