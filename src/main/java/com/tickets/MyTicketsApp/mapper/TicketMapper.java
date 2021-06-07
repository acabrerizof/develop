package com.tickets.MyTicketsApp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tickets.MyTicketsApp.dto.TicketDto;
import com.tickets.MyTicketsApp.entity.Ticket;

@Component
public class TicketMapper {

	private ModelMapper modelMapper = new ModelMapper();

	public TicketDto entityToDto(Ticket entity) {
		return modelMapper.map(entity, TicketDto.class);
	}

	public Ticket dtoToEntity(TicketDto dto) {
		return modelMapper.map(dto, Ticket.class);
	}
}
