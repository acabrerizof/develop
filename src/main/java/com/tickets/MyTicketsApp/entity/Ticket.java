package com.tickets.MyTicketsApp.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "Ticket")
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "creation_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creation;
	
	@Column(name = "total_amount")
	private Integer amount;

	@OneToMany(mappedBy = "idTicket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Detalle> detalles;
}
