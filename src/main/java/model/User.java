package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "idUser")
	private int idUser;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "age")
	private String age;
	@Column(name = "experience")
	private String experience;
	@Column(name = "role")
	private String role;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(int idUser, String name, String password, String email, String age, String experience, String role) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
		this.experience = experience;
		this.role = role;
	}
	public User() {
		super();
	}
	public User(String name, String password, String email, String age, String experience, String role) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
		this.experience = experience;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", password=" + password + ", email=" + email + ", age="
				+ age + ", experience=" + experience + ", role=" + role + "]";
	}
	

	
	
}
