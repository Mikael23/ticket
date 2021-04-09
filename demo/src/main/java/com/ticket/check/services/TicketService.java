package com.ticket.check.services;

import com.ticket.check.domain.CacheDto;
import com.ticket.check.interfaces.CacheInterface;
import com.ticket.check.interfaces.FindEntityInterface;
import com.ticket.check.staticData.StaticDataTicket;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ticket")
@NoArgsConstructor
public class TicketService implements FindEntityInterface {


    @Qualifier("ticketcache")
    @Autowired
    private CacheInterface cacheInterface;
    @Autowired
    private StaticDataTicket staticDataTicket;



    @Override
    public Boolean findEntity(CacheDto cacheDto) {
        Boolean checkHash = cacheInterface.checkHash(cacheDto);
        return checkHash != null ? checkHash : cacheInterface.putInCache(cacheDto,staticDataTicket.findTicket(cacheDto.getValue()));
    }
}
