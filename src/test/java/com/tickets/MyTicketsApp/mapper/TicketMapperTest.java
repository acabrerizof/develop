package com.tickets.MyTicketsApp.mapper;

import static org.hamcrest.CoreMatchers.is;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.tickets.MyTicketsApp.dto.TicketDto;
import com.tickets.MyTicketsApp.entity.Ticket;
	
@RunWith(MockitoJUnitRunner.class) 
public class TicketMapperTest {
	
	@InjectMocks
	private TicketMapper mapper;
	
	@Mock
	private ModelMapper modelMapper;

	@Test
	@Ignore
	public void entityToDtoTest() {
		LocalDateTime date = LocalDate.parse("2021-06-03").atStartOfDay();
		Date d = new Date(1622738752);
		// Given
		Ticket entity = new Ticket();
		entity.setId(1);
		entity.setCreation(date);
		entity.setAmount(10);
		
		// When
		TicketDto expectedResult = new TicketDto();
		Mockito.when(modelMapper.map(entity, TicketDto.class)).thenReturn(expectedResult);
		
		// Then
		TicketDto result = mapper.entityToDto(entity);
		org.hamcrest.MatcherAssert.assertThat(expectedResult, is(result));
	}
}
