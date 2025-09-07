package com.cjc.app.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.exception.UserAlreadyExistsException;
import com.cjc.app.model.Passenger;
import com.cjc.app.model.Ticket;
import com.cjc.app.repository.IRCTCRepository;

@Service
public class IRCTCServiceimpl implements IRCTCService {

	@Autowired
	private IRCTCRepository irctcrepository;
	
	@Autowired
	private EmailService emailservice;

	@Override
	public String saveTicket(Passenger passenger) {

		//
		Ticket ticket = new Ticket();

		ticket.setPassengerName(passenger.getPassengerName());
		ticket.setMobileNo(passenger.getMobileNo());
		ticket.setEmailId(passenger.getEmailId());
		ticket.setAddress(passenger.getAddress());
		ticket.setAge(passenger.getAge());
		ticket.setGender(passenger.getGender());
		ticket.setSource(passenger.getSource());
		ticket.setDestination(passenger.getDestination());
		ticket.setJourneyDate(passenger.getJourneyDate());
		ticket.setTrainNo(passenger.getTrainNo());
		ticket.setTrainName(passenger.getTrainName());
		ticket.setTicketStatus("CONFIRMED");
		ticket.setCost(generateCost());
		ticket.setPnr(generatePnr());

		
		
		boolean flag = irctcrepository.existsByEmailId(passenger.getEmailId());
		if(flag) {
			UserAlreadyExistsException e=new UserAlreadyExistsException("User Already Exists with Given EmailId");
			throw e;
		}
		
		Ticket saveTicket = irctcrepository.save(ticket);
		
		//Logic : Send mail to this user
		emailservice.sendMail(passenger.getEmailId());

		return "PNR NO :" + ticket.getPnr();
	}

	private double generateCost() {
		Random random = new Random();
		int min = 500;
		int max = 1000;

		int randomNumber = random.nextInt(max - min + 1) + min;
		return randomNumber;
	}

	private String generatePnr() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		return generatedString;
	}

	@Override
	public Ticket getTicket(String pnr) {
		Ticket ticket = irctcrepository.findByPnr(pnr);
		return ticket;
	}

}
