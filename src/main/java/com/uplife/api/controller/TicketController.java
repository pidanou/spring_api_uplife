package com.uplife.api.controller;

import com.uplife.api.exception.TicketNotFoundException;
import com.uplife.api.model.Ticket;
import com.uplife.api.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TicketController {

    @Autowired
    private TicketRepository TicketRepository;

    @GetMapping("user/tickets/getAll")
    public List<Ticket> getAllTickets(){
        return TicketRepository.findAll();
    }

    @GetMapping("user/ticket/getById/{id}")
    public Optional<Ticket> getTicketByID(@PathVariable long id){
        return TicketRepository.findById(id);
    }

    @GetMapping("user/ticket/getByIdRoom/{room_name}")
    public Optional<Ticket> getTicketByRoom(@PathVariable String room_name){
        return TicketRepository.findTicketByRoom(room_name);
    }

    @GetMapping("user/ticket/getBySubject/{subject}")
    public Optional<Ticket> getTicketByName(@PathVariable String subject){
        return TicketRepository.findTicketBySubject(subject);
    }

    /*
    @GetMapping("user/ticket/getByAuthor/{id_author}")
    public Optional<Ticket> getTicketByAuthor(@PathVariable long id_author){
        return TicketRepository.findTicketByAuthor(id_author);
    }

     */

    @GetMapping("user/ticket/getByStatus/{status}")
    public Optional<Ticket> getTicketByStatus(@PathVariable int status){
        return TicketRepository.findTicketByStatus(status);
    }

    @GetMapping("user/ticket/getByDate/{date}")
    public Optional<Ticket> getTicketByDate(@PathVariable Date date){
        return TicketRepository.findTicketByDate(date);
    }


    //todo
    /*
    @GetMapping("/ticket/getAllByCampus/{campus}")
    public List<Ticket> getTicketsByCampus(@PathVariable String campus){
        return TicketRepository.findTicketByCampus(campus);
    }

     */


    // Delete a ticket
    @DeleteMapping("admin/tickets/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable(value = "id") Long ticketId) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        TicketRepository.delete(ticket);
        return ResponseEntity.ok().build();
    }
/*
    //delete by user
    //todo
    @DeleteMapping("user/tickets/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable(value = "id") Long ticketId) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        TicketRepository.delete(ticket);
        return ResponseEntity.ok().build();
    }
*/

    // Update a ticket
    @PutMapping("user/tickets/{id}")
    public Ticket updateTicket(@PathVariable(value = "id") Long ticketId,
                               @Valid @RequestBody Ticket ticketDetails) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        ticket.setMessage(ticketDetails.getMessage());
        ticket.setroom_name(ticketDetails.getroom_name());
        ticket.setSubject(ticketDetails.getSubject());
        ticket.setImage(ticketDetails.getImage());
        Ticket updatedticket = TicketRepository.save(ticket);
        return updatedticket;
    }

    // Update a ticket
    @PutMapping("admin/tickets/SetReponse/{id}")
    public Ticket updateticketReponse(@PathVariable(value = "id") Long ticketId,
                               @Valid @RequestBody String reponse) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        ticket.setReponse(reponse);
        Ticket updatedticket = TicketRepository.save(ticket);
        return updatedticket;
    }

    @PutMapping("admin/tickets/SetStatut/{id}")
    public Ticket updateticketReponse(@PathVariable(value = "id") Long ticketId,
                                      @Valid @RequestBody int status) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        ticket.setStatut_ticket(status);
        Ticket updatedticket = TicketRepository.save(ticket);
        return updatedticket;
    }



    // Create a new ticket
    @PostMapping("/tickets")
    public Ticket create(@Valid @RequestBody Ticket ticket) {
        return TicketRepository.save(ticket);
    }
}
