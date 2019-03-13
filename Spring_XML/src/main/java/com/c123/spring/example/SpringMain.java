package com.c123.spring.example;

import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringMain {

    public static void main(String[] args)
     {
	    // Load the Spring context. After initialization the
	    // afterPropertiesSet() method is called.
	    new FileSystemXmlApplicationContext("SpringContext.xml");
	    

     }
}
