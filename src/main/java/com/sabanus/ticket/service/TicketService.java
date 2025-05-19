package com.sabanus.ticket.service;

import com.sabanus.ticket.model.Ticket;
import com.sabanus.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository repo;

    public List<Ticket> findAll() {
        return repo.findAll();
    }

    public Optional<Ticket> findById(Long id) {
        return repo.findById(id);
    }

    public Ticket create(Ticket t) {
        return repo.save(t);
    }

    public Optional<Ticket> update(Long id, Ticket t) {
        return repo.findById(id)
                .map(existing -> {
                    t.setId(id);
                    return repo.save(t);
                });
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

