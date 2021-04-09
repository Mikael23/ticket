package com.ticket.check.controller;

import com.ticket.check.domain.CacheDto;
import com.ticket.check.domain.EntityDto;
import com.ticket.check.interfaces.FindEntityInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    @Autowired @Qualifier("ticket")
    private FindEntityInterface findEntityInterface;



    @GetMapping("/{ticketId}")
    public EntityDto getTicket(@PathVariable Long ticketId) {
        return new EntityDto(findEntityInterface.findEntity(CacheDto.builder().value(ticketId).build()));
    }

}
