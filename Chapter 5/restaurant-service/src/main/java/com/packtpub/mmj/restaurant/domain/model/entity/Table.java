package com.packtpub.mmj.restaurant.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;

@Data
public class Table extends BaseEntity<BigInteger> {

    private int capacity;

    public Table(@JsonProperty("name") String name, @JsonProperty("id") BigInteger id, @JsonProperty("capacity") int capacity) {
        super(id, name);
        this.capacity = capacity;
    }
}
