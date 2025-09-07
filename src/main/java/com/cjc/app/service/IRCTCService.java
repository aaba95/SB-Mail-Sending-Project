package com.cjc.app.service;

import com.cjc.app.model.Passenger;
import com.cjc.app.model.Ticket;

public interface IRCTCService {

	String saveTicket(Passenger passenger);

	Ticket getTicket(String pnr);

}
