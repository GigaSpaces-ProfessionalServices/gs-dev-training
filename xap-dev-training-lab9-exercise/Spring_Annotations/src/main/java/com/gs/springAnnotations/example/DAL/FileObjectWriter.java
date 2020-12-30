package com.gs.springAnnotations.example.DAL;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// TODO: 
public class FileObjectWriter {
	// TODO:
	private String fileName; 
	
	PrintWriter printWriter;

	public FileObjectWriter(String fileName) {
        this.setFileName(fileName);

    }

	public FileObjectWriter() {
    }
	
	// TODO:
	public void init() {
	   if (fileName != null) {
	        try {
				this.printWriter = new PrintWriter(new FileWriter(fileName), true);
			} catch (IOException e) {
				e.printStackTrace();
			} 
	   }
	}
	
    public void write(Object object){
        try {
			printWriter.println(""+ object);
		} catch (Exception e) {
			e.printStackTrace();
		} 
  	
    }
    // TODO:
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

	private void setFileName(String fileName) {
		this.fileName = fileName;
		
	}
}
