package com.gs.springAnnotations.example;


import java.util.ArrayList;

import com.gs.example.model.User;
import com.gs.springAnnotations.example.DAL.FileObjectWriter;


//TODO:
public class UserGenerator {
	// TODO:
	private ArrayList<String> userNameList;
	// TODO:
	private FileObjectWriter fileObjectWriter;
	private ArrayList<User> userList = new ArrayList<User>();


	public UserGenerator(ArrayList<String> userNameList) {
		super();
		this.userNameList = userNameList;
	}
	
	public UserGenerator() {
		super();
	}

	// TODO:
	public void generateUsers(){	
		System.out.println("Init Users");
		this.initUsers();
		System.out.println("Writing Users to File");
		this.printUsers();
		
		fileObjectWriter.close();
		System.out.println("See " + fileObjectWriter.getFileName()+" for list of users.");
		
	}

	private void printUsers() {
		
		if (fileObjectWriter !=null){
			for (User user: this.getUserList()){
				fileObjectWriter.write(user);
				
			}
		}
		
	}

	private void initUsers() {

		int userAccountId=1;
		userList = new ArrayList<User>();
		
		for (String userName: getUserNameList()){
			userList.add(new User(userAccountId,userName, 0.0, (int)(Math.random()*7)*1000));
			userAccountId++;
		}
	}
	
	/**
	 * @return the userList
	 */
	private ArrayList<User> getUserList() {
		return userList;
	}


	/**
	 * @param userNameList the userNameList to set
	 */
	void setUserNameList(ArrayList<String> userNameList) {
		this.userNameList = userNameList;
	}

	/**
	 * @return the userNameList
	 */
	ArrayList<String> getUserNameList() {
		return userNameList;
	}
}
