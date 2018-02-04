package com.packtpub.mmj.restaurant.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * @author Sourabh Sharma
 */
@Data
public class Table extends BaseEntity<BigInteger> {
    private int capacity;

    /**
     * @param name
     * @param id
     * @param capacity
     */
    public Table(@JsonProperty("name") String name, @JsonProperty("id") BigInteger id, @JsonProperty("capacity") int capacity) {
        super(id, name);
        this.capacity = capacity;
    }
}