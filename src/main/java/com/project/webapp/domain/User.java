package com.project.webapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.webapp.model.Matches;

@Entity
@Table(name = "Project_User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	@Column(unique = true)
	private String username;
	private String name;
	private String surname;
	@Column(unique = true)
	private String emailaddress;
	private double Account_Amount;
	private String password;
	private String confirmpassword;
	private int age;
	private String favouriteteam;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<UserMatches> orderList;

	public User() {

	}

	public User(String username, String name, String surname, String emailaddress, Double account_Amount,
			String password, String confirmpassword, int age, String favouriteteam) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.emailaddress = emailaddress;
		this.Account_Amount = account_Amount;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.age = age;
		this.favouriteteam = favouriteteam;
		this.orderList = new ArrayList<UserMatches>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFavouriteteam() {
		return favouriteteam;
	}

	public void setFavouriteteam(String favouriteteam) {
		this.favouriteteam = favouriteteam;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public double getAccount_Amount() {
		return Account_Amount;
	}

	public void setAccount_Amount(double account_Amount) {
		Account_Amount = account_Amount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<UserMatches> getBettingList() {
		return orderList;
	}

	public void setBettingList(List<UserMatches> bettingList) {
		this.orderList = bettingList;
	}

	public void addBettingOrder(UserMatches bettingOrder) {
		this.orderList.add(bettingOrder);
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", surname=" + surname + ", emailaddress="
				+ emailaddress + ", Account_Amount=" + Account_Amount + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", age=" + age + ", favouriteteam=" + favouriteteam + ", orderList"
				+ orderList.size() + "]";
	}

}
