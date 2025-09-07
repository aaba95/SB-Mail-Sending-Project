package com.cjc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.model.Ticket;

@Repository
public interface IRCTCRepository extends JpaRepository<Ticket, Integer> {

	Ticket findByPnr(String pnr);
	
	boolean existsByEmailId(String msg);

}
