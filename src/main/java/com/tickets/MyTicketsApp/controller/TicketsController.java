package com.tickets.MyTicketsApp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickets.MyTicketsApp.dto.FilterDto;
import com.tickets.MyTicketsApp.dto.TicketDto;
import com.tickets.MyTicketsApp.entity.Ticket;
import com.tickets.MyTicketsApp.repository.TicketsRepository;
import com.tickets.MyTicketsApp.service.TicketService;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TicketsController {

	@Autowired
	private TicketService service;

	@GetMapping("/findAll")
	public List<TicketDto> findAll() {
		return service.findAll();
	}

	@GetMapping("/find/{id}") 
	public TicketDto findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
	
	@PutMapping("/findByDates")
	public List<TicketDto> findByDates(@RequestBody FilterDto filter) {
		
		LocalDateTime start = LocalDateTime.of(LocalDate.from(filter.getStartDate()), LocalTime.of(0, 0, 0));
        LocalDateTime end = LocalDateTime.of(LocalDate.from(filter.getEndDate()), LocalTime.of(23, 59, 59));
		
		return service.findByDates(start, end);
	}
	
	@PostMapping("/addTicket")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		return service.saveTicket(ticket);
	}
	
	@PostMapping("/addTickets")
	public List<Ticket> addTickets(@RequestBody List<Ticket> tickets) {
		return service.saveTickets(tickets);
	}
	
	@PutMapping("/updateTicket")
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		return service.updateTicket(ticket);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTicket(@PathVariable int id) {
		service.deleteTicket(id);
	}
}
