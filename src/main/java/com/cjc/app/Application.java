package com.cjc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//int x=100;

       public void m1(){
System.out.println("m1 method...");
}     
       public void evenno() {
    	   int num=14;
    	   if(num%2==0) {
    		   System.out.println("Number is Even Number");
    	   }
    	   else {
    		   System.out.println("Number is Odd Number...");
    	   }
       }

       public void oddno() {
    	   int num=15;
    	   if(num%2!=0) {
    		   System.out.println("Number is odd");
    	   }
    	   else {
    		   System.out.println("Number is even ");
    	   }
       }
       
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
