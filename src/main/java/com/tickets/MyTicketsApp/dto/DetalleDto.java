package com.tickets.MyTicketsApp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tickets.MyTicketsApp.entity.Ticket;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonPropertyOrder({ "id", "id_ticket", "description", "amount"})
public class DetalleDto {

	private Integer id;
	private Ticket idTicket;
	private String description;
	private Integer amount;
}
