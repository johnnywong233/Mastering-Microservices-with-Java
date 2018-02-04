package com.packtpub.mmj.user.domain.valueobject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO {
    private String name;
    private String id;
    private String address;
    private String city;
    private String phoneNo;

    /**
     * Custom Constructor
     *
     * @param name
     * @param id
     * @param address
     * @param city
     * @param phoneNo
     */
    public UserVO(String id, String name, String address, String city, String phoneNo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNo = phoneNo;
    }
}