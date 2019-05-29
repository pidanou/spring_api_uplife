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

@RestController
public class TicketController {

    @Autowired
    private TicketRepository TicketRepository;

    @GetMapping("/user/ticket/getAll")
    public List<Ticket> getAllTickets(){
        return TicketRepository.findAll();
    }

    @GetMapping("user/ticket/getById/{id}")
    public Optional<Ticket> getTicketByID(@PathVariable long id){
        return TicketRepository.findById(id);
    }

    @GetMapping("user/ticket/getByRoom/{room_name}")
    public Optional<Ticket> getTicketByRoom(@PathVariable String room_name){
        return TicketRepository.findTicketByRoom(room_name);
    }

    @GetMapping("user/ticket/getBySubject/{subject}")
    public Optional<Ticket> getTicketBySubject(@PathVariable String subject){
        return TicketRepository.findTicketBySubject(subject);
    }

    @GetMapping("user/ticket/getByAuthor/{author_id}")
    public Optional<Ticket> getTicketByAuthor(@PathVariable long author_id){
        return TicketRepository.findTicketByAuthor(author_id);
    }


    @GetMapping("user/ticket/getByStatus/{status_ticket}")
    public Optional<Ticket> getTicketByStatus(@PathVariable long status_ticket){
        return TicketRepository.findTicketByStatus(status_ticket);
    }

    @GetMapping("user/ticket/getAllByCampus/{campus}")
    public List<Ticket> getTicketsByCampus(@PathVariable String campus){
        return TicketRepository.findTicketByCampus(campus);
    }

    // Delete a ticket
    @RequestMapping(value = "admin/ticket/deleteTicket/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteTicket(@PathVariable(value = "id") Long id) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
        TicketRepository.delete(ticket);
        return ResponseEntity.ok().build();
    }

    // Update a ticket
    @RequestMapping(value ="admin/ticket/SetReponse/{id}")
    public Ticket updateticketReponse(@PathVariable(value = "id") Long ticketId,
                               @Valid @RequestBody String reponse) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        ticket.setReponse(reponse);
        Ticket updatedticket = TicketRepository.save(ticket);
        return updatedticket;
    }

    @RequestMapping(value ="admin/ticket/SetStatus/{id}")
    public Ticket updateticketReponse(@PathVariable(value = "id") Long ticketId,
                                      @Valid @RequestBody long status) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        ticket.setStatus_ticket(status);
        Ticket updatedticket = TicketRepository.save(ticket);
        return updatedticket;
    }

/*
    //delete by user
    RequestMapping(value = "user/ticket/deleteTicket/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteTicket(@PathVariable(value = "id") Long ticketId) throws TicketNotFoundException {
        Ticket ticket = TicketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        TicketRepository.delete(ticket);
        return ResponseEntity.ok().build();
    }

    // Update a ticket
    @PutMapping("user/ticket/updateTicket/{id}")
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

    //like
    //todo

     */
    // Create a new ticket
    @PostMapping("user/ticket/createTicket")
    //@RequestMapping(value = "user/ticket/createTicket")
    public Ticket create(@Valid @RequestBody Ticket ticket) {
        return TicketRepository.save(ticket);
    }
}
