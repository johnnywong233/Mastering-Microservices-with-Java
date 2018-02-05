package com.packtpub.mmj.mcrsrvc.domain.model;

import java.math.BigInteger;

public class Table extends BaseEntity<BigInteger> {

    private int capacity;

    /**
     * @param name
     * @param id
     * @param capacity
     */
    public Table(String name, BigInteger id, int capacity) {
        super(id, name);
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
                .append(name).append(", capacity: ").append(capacity).append("}").toString();
    }

}
