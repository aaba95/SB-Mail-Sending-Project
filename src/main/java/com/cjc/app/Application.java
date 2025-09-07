package com.cjc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//int x=100;

       public void m1(){
System.out.println("m1 method...");
}     

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
