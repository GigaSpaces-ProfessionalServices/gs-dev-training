package com.c123.springAnnotations.example.DAL;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
@Component
public class FileObjectWriter {
	@Resource
	private String fileName; 
	
	PrintWriter printWriter;

	public FileObjectWriter(String fileName) {
        this.setFileName(fileName);

    }

	public FileObjectWriter() {
    }
	
	@PostConstruct
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
    @PreDestroy
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
