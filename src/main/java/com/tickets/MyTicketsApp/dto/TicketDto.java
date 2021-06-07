package com.tickets.MyTicketsApp.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonPropertyOrder({ "id", "amount", "creation" })
public class TicketDto {

	private Integer id;
	private LocalDateTime creation;
	private Integer amount;
}
