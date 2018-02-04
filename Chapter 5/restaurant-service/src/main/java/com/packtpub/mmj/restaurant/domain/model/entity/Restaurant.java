package com.packtpub.mmj.restaurant.domain.model.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Restaurant extends BaseEntity<String> {

    private List<Table> tables = new ArrayList<>();
    private String address;

    public Restaurant(String name, String id, String address, List<Table> tables) {
        super(id, name);
        this.address = address;
        this.tables = tables;
    }
}
