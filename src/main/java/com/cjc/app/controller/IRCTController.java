package com.cjc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.exception.NoSuchUserExistsException;
import com.cjc.app.exception.UserAlreadyExistsException;
import com.cjc.app.model.Passenger;
import com.cjc.app.model.Ticket;
import com.cjc.app.service.IRCTCService;

@RestController
public class IRCTController {

	@Autowired
	private IRCTCService irctcservice;

	// URL : http://localhost:9090/tickets

	@PostMapping(value = "/tickets")
	public ResponseEntity<String> bookTicket(@RequestBody Passenger passenger) {
		String msg = irctcservice.saveTicket(passenger);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	// URL :http://localhost:9090/tickets/pnr

	@GetMapping(value = "/tickets/{pnr}")
	public ResponseEntity<Ticket> getTicket(@PathVariable String pnr) {
		Ticket ticket = irctcservice.getTicket(pnr);
		
		if(ticket==null) {
			NoSuchUserExistsException e=new NoSuchUserExistsException("No User Available with given PNR no....");
			throw e;
		}
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

	
}
