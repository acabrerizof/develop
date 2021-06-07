package com.tickets.MyTicketsApp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tickets.MyTicketsApp.entity.Ticket;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Integer> {

	List<Ticket> findByAmount(Integer amount);

	@Query("select t from Ticket t where t.creation >= :start and t.creation <= :end")
	List<Ticket> findByStartDateBetwList(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
	
}
