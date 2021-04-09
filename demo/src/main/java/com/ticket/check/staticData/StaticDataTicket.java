package com.ticket.check.staticData;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.LongStream.range;


@Data
@Component
public class StaticDataTicket  {


    private final static Set<Long> tickets = new HashSet<>();

    static {
        range(0, 10).mapToObj(tickets::add).collect(Collectors.toList());
    }

    public Boolean findTicket(Long ticketId) {
        return tickets.contains(ticketId);
    }
}
