package model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegUser {

	private int idRegUser;
	@NotEmpty
	@Size(min = 5, max = 15 )
	private String name;
	@NotEmpty
	@Size(min = 5, max = 15 )
	private String password;
	@Email
	private String email;

	private String age;

	private String experience ;
	public int getIdRegUser() {
		return idRegUser;
	}
	public void setIdRegUser(int idRegUser) {
		this.idRegUser = idRegUser;
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
	public RegUser() {
		super();
	}
	public RegUser(int idRegUser, String name, String password, String email, String age, String experience) {
		super();
		this.idRegUser = idRegUser;
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
		this.experience = experience;
	}
	public RegUser(String name, String password, String email, String age, String experience) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "RegUser [idRegUser=" + idRegUser + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", age=" + age + ", experience=" + experience + "]";
	}
	
	
	
}
