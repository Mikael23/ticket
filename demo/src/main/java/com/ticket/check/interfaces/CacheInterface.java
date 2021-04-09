package com.ticket.check.interfaces;

import com.ticket.check.domain.CacheDto;

public interface CacheInterface {

    Boolean checkHash(CacheDto param);

    Boolean putInCache(CacheDto param,Boolean flag);
}
