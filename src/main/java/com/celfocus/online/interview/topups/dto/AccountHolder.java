package com.celfocus.online.interview.topups.dto;

public class AccountHolder {
	
	private String id;
	private String name;
	private String number;
	//private String displayName;
	
	public AccountHolder(String id, String name, String number) {
		this.id=id;
		this.name=name;
		this.number=number;
		//this.displayName = id +" - "+name;
	}
	
	public AccountHolder(){}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	/*public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}*/

}
