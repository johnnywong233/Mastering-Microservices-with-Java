package com.packtpub.mmj.mcrsrvc.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sourabh Sharma
 */
@Data
public class Restaurant extends BaseEntity<String> {

    private List<Table> tables = new ArrayList<>();

    public Restaurant(String name, String id, List<Table> tables) {
        super(id, name);
        this.tables = tables;
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", name: ")
                .append(name).append(", tables: ").append(tables).append("}").toString();
    }
}
