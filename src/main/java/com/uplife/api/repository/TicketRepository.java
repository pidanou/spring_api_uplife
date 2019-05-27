

package com.uplife.api.repository;


import com.uplife.api.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAll();

    Optional<Ticket> findById(long id);

    @Query(value="SELECT * FROM tickets t WHERE t.room_name = :room_name", nativeQuery = true)
    Optional<Ticket> findTicketByRoom(@Param("room_name") String room_name);

    @Query(value="SELECT * FROM tickets t WHERE t.subject = :subject", nativeQuery = true)
    Optional<Ticket> findTicketBySubject(@Param("subject") String subject);

    @Query(value="SELECT * FROM Tickets r WHERE r.campus = :campus", nativeQuery = true)
    List<Ticket> findTicketByCampus(@Param("campus") String campus);

    @Query(value="SELECT * FROM Tickets r WHERE r.author_id = :author_id", nativeQuery = true)
    Optional<Ticket> findTicketByAuthor(@Param("author_id") long author_id);

    @Query(value="SELECT * FROM tickets t WHERE t.status_ticket = :status_ticket", nativeQuery = true)
    Optional<Ticket> findTicketByStatus(@Param("status_ticket") long status_ticket);

    @Query(value="SELECT * FROM tickets t WHERE t.date = :date", nativeQuery = true)
    Optional<Ticket> findTicketByDate(@Param("date") Date date);


}


