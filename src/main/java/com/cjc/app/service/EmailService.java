package com.cjc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;





@Component
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
    @Value("${spring.mail.username}")
	private String from;
	
	public void sendMail(String to) {
		//Logic To Send Email
		
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject("Ticket Booking ");
		mail.setText("Hii, \n \t "
				+ "Your IRCTC Ticket Booking Successfully.... ENjoy the Journey. ");
		
		mailSender.send(mail);
	}
}
