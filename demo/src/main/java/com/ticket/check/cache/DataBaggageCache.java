package com.ticket.check.cache;

import com.ticket.check.domain.CacheDto;
import com.ticket.check.interfaces.CacheInterface;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("databaggagecache")
@NoArgsConstructor
public class DataBaggageCache implements CacheInterface {

    private final Map<CacheDto, Boolean> dataBaggageCache = new HashMap<>();


    @Override
    public Boolean checkHash(CacheDto param) {
        return dataBaggageCache.get(param);
    }

    @Override
    public Boolean putInCache(CacheDto param,Boolean flag) {
        dataBaggageCache.put(param,flag);
        return flag;
    }
}
