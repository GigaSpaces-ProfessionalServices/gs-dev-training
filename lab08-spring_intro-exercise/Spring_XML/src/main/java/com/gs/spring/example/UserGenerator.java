package com.gs.spring.example;


import java.util.ArrayList;

import com.gs.example.model.User;
import com.gs.spring.example.DAL.FileObjectWriter;


public class UserGenerator {

	private ArrayList<String> userNameList = null;
	private FileObjectWriter fileObjectWriter= null;
	private ArrayList<User> userList = null;


	public UserGenerator(ArrayList<String> userNameList) {
		super();
		this.userNameList = userNameList;
	}

	public UserGenerator() {
		super();
	}
		
	public  void generateUsers(){	
		System.out.println("Init Users");
		this.initUsers();
		System.out.println("Writing Users to File");
		this.printUsers();
		
		this.getFileObjectWriter().close();
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
	 * @param userList the userList to set
	 */
	public void setUserList(ArrayList<User> userList) {
		this.userList =  userList;
	}


	/**
	 * @return the userList
	 */
	public ArrayList<User> getUserList() {
		return userList;
	}


	/**
	 * @param fileObjectWriter the fileObjectWriter to set
	 */
	public void setFileObjectWriter(FileObjectWriter fileObjectWriter) {
		this.fileObjectWriter = fileObjectWriter;
	}


	/**
	 * @return the fileObjectWriter
	 */
	public FileObjectWriter getFileObjectWriter() {
		return fileObjectWriter;
	}

	/**
	 * @param userNameList the userNameList to set
	 */
	public void setUserNameList(ArrayList<String> userNameList) {
		this.userNameList = userNameList;
	}

	/**
	 * @return the userNameList
	 */
	public ArrayList<String> getUserNameList() {
		return userNameList;
	}
}
