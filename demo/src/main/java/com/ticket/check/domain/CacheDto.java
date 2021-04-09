package com.ticket.check.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CacheDto {

    private final String key;
    private final Long value;
    private final Double price;

}

