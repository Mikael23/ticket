package com.ticket.check.controller;

import com.ticket.check.domain.CacheDto;
import com.ticket.check.interfaces.FindEntityInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/dataBaggage")
public class DataBaggageController {

    @Autowired @Qualifier("databaggage")
    private FindEntityInterface findEntityInterface;


    @GetMapping("/{destinationId}/{baggageId}")
    public Boolean getBaggage(@PathVariable Long destinationId, @PathVariable String baggageId) {
        return findEntityInterface.findEntity(CacheDto.builder().value(destinationId).key(baggageId).build());
    }


}
