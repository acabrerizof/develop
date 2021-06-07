package com.tickets.MyTicketsApp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class FilterDto {
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@NotNull
	private LocalDate startDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@NotNull
    private LocalDate endDate;
}
