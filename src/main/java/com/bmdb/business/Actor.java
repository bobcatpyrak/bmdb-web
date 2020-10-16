package com.bmdb.business;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Actor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String firstName;
	String lastName;
	String gender;
	LocalDate birthdate;
	
	public Actor()
	{
		
	}
	
	public Actor(int id, String firstName, String lastName,	String gender, LocalDate birthdate)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
	}
	
	public String displaySummary()
	{
		return id + ". " + firstName + " " + lastName + ", " + gender + ", " + birthdate;
	}
	
	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
