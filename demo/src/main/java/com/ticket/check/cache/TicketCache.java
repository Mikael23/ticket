package com.ticket.check.cache;

import com.ticket.check.domain.CacheDto;
import com.ticket.check.interfaces.CacheInterface;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component("ticketcache")
@NoArgsConstructor
public class TicketCache implements CacheInterface {

    private final Map<Long, Boolean> ticketHash = new HashMap<>();


    @Override
    public Boolean checkHash(CacheDto param) {
        return ticketHash.get(param.getValue());
    }

    @Override
    public Boolean putInCache(CacheDto param, Boolean flag) {
        ticketHash.put(param.getValue(), flag);
        return flag;
    }


}
