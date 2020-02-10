package com.c123.nospring.example;

import java.util.ArrayList;

import com. c123.example.model.User;
import com.c123.nospring.example.DAL.FileObjectWriter;


public class UserGenerator {

	private ArrayList<String> userNameList = null;
	private FileObjectWriter fileObjectWriter= null;
	private ArrayList<User> userList = new ArrayList<User>();
	private String fileName = "TEMP/USER_LIST_FILE.txt";

	public UserGenerator(ArrayList<String> userNameList) {
		super();
		this.userNameList = userNameList;
	}

		
	public  void generateUsers(){	
		System.out.println("Init Users");
		this.initUsers();
		System.out.println("Writing Users to File");
		fileObjectWriter = new FileObjectWriter(this.getFileName());
		this.printUsers();
		
		this.getFileObjectWriter().close();
		System.out.println("See " + this.getFileName()+" for list of users.");
		
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
	
	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the userList
	 */
	private ArrayList<User> getUserList() {
		return userList;
	}


	/**
	 * @return the fileObjectWriter
	 */
	private FileObjectWriter getFileObjectWriter() {
		return fileObjectWriter;
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
