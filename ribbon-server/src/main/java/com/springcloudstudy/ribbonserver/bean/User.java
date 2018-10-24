package com.springcloudstudy.ribbonserver.bean;

/**
 * @author yanghai
 * @date 2018/10/23 17:20
 */
public class User {

    private String id;

    private String name;

    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User() {
    }


}
