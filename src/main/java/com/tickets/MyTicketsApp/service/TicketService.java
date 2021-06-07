package com.tickets.MyTicketsApp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickets.MyTicketsApp.dto.TicketDto;
import com.tickets.MyTicketsApp.entity.Ticket;
import com.tickets.MyTicketsApp.mapper.TicketMapper;
import com.tickets.MyTicketsApp.repository.TicketsRepository;

@Service
public class TicketService {

	@Autowired
	private TicketsRepository repo;

	@Autowired
	private TicketMapper mapper;

	public List<TicketDto> findAll() {
		return repo.findAll().stream().map(t -> mapper.entityToDto(t)).collect(Collectors.toList());
	}

	public TicketDto findById(Integer id) {
		return repo.findById(id).map(t -> mapper.entityToDto(t)).orElseThrow(() -> new RuntimeException("No data!"));
	}
	
	public List<TicketDto> findByDates(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		List<Ticket> entities = repo.findByStartDateBetwList(fechaInicio, fechaFin);
		return entities.stream().map(t -> mapper.entityToDto(t)).collect(Collectors.toList());
	}
	
	public Ticket saveTicket(Ticket t) {
		return repo.save(t);
	}
	
	public List<Ticket> saveTickets(List<Ticket> tickets) {
		return repo.saveAll(tickets);
	}
	
	public void deleteTicket(int id) {
		repo.deleteById(id);
	}
	
	public Ticket updateTicket(Ticket t) {
		//System.out.println("idTicket -> " + t.getId());
		Ticket existeTicket = repo.findById(t.getId()).orElse(null);
		//System.out.println("Ticket -> " + existeTicket);
		existeTicket.setAmount(t.getAmount());
		//System.out.println("amount -> " + t.getAmount());
		
		return repo.save(existeTicket);
	}
}
