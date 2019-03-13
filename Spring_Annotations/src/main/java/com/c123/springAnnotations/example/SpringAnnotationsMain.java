package com.c123.springAnnotations.example;



import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringAnnotationsMain {

    public static void main(String[] args)
     {
    // Load the Spring context. After initialization the
    // afterPropertiesSet() method is called.
    new FileSystemXmlApplicationContext("SpringContextAnnotations.xml");
}
}
