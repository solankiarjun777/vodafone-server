package com.celfocus.online.interview.topups.dto;

/**
 * The class represents attrbiutes of account holder
 * 
 * @author Arjun solanki
 *
 */
public class AccountHolder {
	
	/**
	 * unique identifier for Account holder
	 */
	private String id;
	
	/**
	 * Name for account holder
	 */
	private String name;
	
	/**
	 * mobile for account holder
	 */
	private String number;
	
	public AccountHolder(String id, String name, String number) {
		this.id=id;
		this.name=name;
		this.number=number;
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
