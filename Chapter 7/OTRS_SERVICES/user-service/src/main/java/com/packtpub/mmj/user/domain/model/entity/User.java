package com.packtpub.mmj.user.domain.model.entity;

public class User extends BaseEntity<String> {

    private String address;
    private String city;
    private String phoneNo;

    /**
     * @param name
     * @param id
     * @param address
     * @param city
     * @param phoneNo
     */
    public User(String id, String name, String address, String city, String phoneNo) {
        super(id, name);
        this.address = address;
        this.city = city;
        this.phoneNo = phoneNo;
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


    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }


    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
                .append(name).append(", address: ").append(address)
                .append(", city: ").append(city)
                .append(", phoneNo: ").append(phoneNo).append("}").toString();
    }
}
