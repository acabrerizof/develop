package com.tickets.MyTicketsApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Detalle")
@Data

public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "description")
	private String description;

	@Column(name = "total_amount")
	private Integer total_amount;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Ticket", nullable = false)
    private Ticket idTicket;
}
