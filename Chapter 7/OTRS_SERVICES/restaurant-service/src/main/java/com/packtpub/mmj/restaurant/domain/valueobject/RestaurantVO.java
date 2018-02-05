package com.packtpub.mmj.restaurant.domain.valueobject;

import com.packtpub.mmj.restaurant.domain.model.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class RestaurantVO {

    private List<Table> tables = new ArrayList<>();
    private String name;
    private String id;
    private String address;

    /**
     * Constructor
     */
    public RestaurantVO() {
    }


    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }


    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }


    public List<Table> getTables() {
        return tables;
    }

    /**
     * @param tables
     */
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", name: ")
                .append(name).append(", address: ").append(address).
                        append(", tables: ").append(tables).append("}").toString();
    }
}
