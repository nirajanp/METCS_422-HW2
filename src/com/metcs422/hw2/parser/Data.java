package com.metcs422.hw2.parser;

// This is a class to store the values of the
// keywords searched by user and time. 

import java.time.LocalTime;

public class Data {
	
	// variable of type String
	private String searchList;
	
	// variable of type LocalTime
	private LocalTime time;
	
	// Constructor to initialize created objects.
	public Data(String searchList, LocalTime time) {
		this.searchList = searchList;
		this.time = time;
	}

	// getter method for variable searchList 
	public String getSearchList() {
		return searchList;
	}

	// setter method for variable searchList
	public void setSearchList(String searchList) {
		this.searchList = searchList;
	}

	// getter method for variable getTime
	public LocalTime getTime() {
		return time;
	}
	
	// setter method for variable setTime
	public void setTime(LocalTime time) {
		this.time = time;
	}

	// This prints out the information there are in an 
	// ArrayList object.
	public String toString() {
		return  searchList  + " | " +time ;
	}
	
}
