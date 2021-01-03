package com.gs.nospring.example;

import java.util.ArrayList;
import java.util.Arrays;




public class TraditionalMain {

	private static final ArrayList<String> USER_NAME_LIST = new ArrayList<String>(
			Arrays.asList("James Johnson",
					"Peter Gardener",
					"Andrei Saizovsky",
					"Petr Kirul",
					"Gerard Bourtagne",
					"Hans Freihof",
					"Sami Filppula",
					"Niklas Nilsson",
					"Marian Varga",
					"Sigur Briem"));
	
			
	public static void main(String args[]){
		UserGenerator userGenerator = new UserGenerator(USER_NAME_LIST);
		userGenerator.setFileName("TEMP/USER_LIST_FILE_TRADITIONAL_JAVA.txt");
		userGenerator.generateUsers();
	}

}
