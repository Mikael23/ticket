package com.ticket.check.services;


import com.ticket.check.domain.CacheDto;
import com.ticket.check.interfaces.CacheInterface;
import com.ticket.check.interfaces.FindEntityInterface;
import com.ticket.check.staticData.StaticDataBaggage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value = "databaggage")
@NoArgsConstructor
public class DataBaggageService implements FindEntityInterface {

    @Qualifier("databaggagecache")
    @Autowired
    private CacheInterface cacheInterface;
    @Autowired
    private StaticDataBaggage staticDataBaggage;



    @Override
    public Boolean findEntity(CacheDto cacheDto) {
        Boolean checkHash = cacheInterface.checkHash(cacheDto);
        return checkHash != null ? checkHash :
                cacheInterface.putInCache(cacheDto, staticDataBaggage.findBaggage(cacheDto.getKey(),cacheDto.getValue()));

    }
}
