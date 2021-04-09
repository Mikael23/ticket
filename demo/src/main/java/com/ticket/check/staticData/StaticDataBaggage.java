package com.ticket.check.staticData;

import com.ticket.check.interfaces.FindEntityInterface;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.LongStream.range;

@Data
@Component
public class StaticDataBaggage  {

    private final static Map<String, Long> destinationBaggage = new HashMap<>();

    static {
        range(0, 10).mapToObj(it -> destinationBaggage.put(String.valueOf(it), it)).collect(Collectors.toList());
    }


    public Boolean findBaggage(String baggageId, Long destinationId) {
        Long key = destinationBaggage.get(baggageId);
        return destinationId.equals(key);
    }
}
