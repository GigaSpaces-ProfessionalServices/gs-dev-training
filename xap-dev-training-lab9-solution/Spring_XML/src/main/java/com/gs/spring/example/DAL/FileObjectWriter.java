package com.gs.spring.example.DAL;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileObjectWriter {
	
	private String fileName; 

	private PrintWriter printWriter = null;

	public FileObjectWriter(String fileName) {
        this.setFileName(fileName);

    }
    
	public FileObjectWriter() {

    }
    public void write(Object object){
        try {
			printWriter.println(""+ object);
		} catch (Exception e) {
			e.printStackTrace();
		} 
  	
    }
    
    public void close(){
        try {
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
		     if (printWriter != null)
		    	 printWriter.close(); 
		}    	
    }
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
	    this.fileName = fileName;
        try {
			this.printWriter = new PrintWriter(new FileWriter(fileName), true);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
   
}
