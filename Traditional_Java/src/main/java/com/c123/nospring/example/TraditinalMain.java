package com.c123.nospring.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;




public class TraditinalMain {

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
		File f = new File("TEMP/USER_LIST_FILE.txt");
		System.out.println(f.isFile());
		userGenerator.setFileName("TEMP/USER_LIST_FILE.txt");
		userGenerator.generateUsers();

	}

}
