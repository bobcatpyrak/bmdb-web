package com.bmdb.business;

import javax.persistence.*;

@Entity
public class Movie 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String title;
	int year;
	String rating;
	String director;
	
	public Movie()
	{
		
	}
	
	public Movie(int id, String title, int year, String rating, String director)
	{
		this.id = id;
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.director = director;
	}
	
	public String displaySummary()
	{
		return id + ". " + title + " " + year + ", " + rating + ", " + director;
	}
	
	// Getters and Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
