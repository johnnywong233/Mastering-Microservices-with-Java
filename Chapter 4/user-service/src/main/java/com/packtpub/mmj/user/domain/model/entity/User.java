package com.packtpub.mmj.user.domain.model.entity;

import lombok.Data;

@Data
public class User extends BaseEntity<String> {

    private String address;
    private String city;
    private String phoneNo;

    public User(String id, String name, String address, String city, String phoneNo) {
        super(id, name);
        this.address = address;
        this.city = city;
        this.phoneNo = phoneNo;
    }
}
