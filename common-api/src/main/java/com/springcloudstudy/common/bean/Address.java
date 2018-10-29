package com.springcloudstudy.common.bean;

/**
 * @author yanghai
 * @date 2018/10/24 11:25
 */
public class Address {

    private String name;

    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Address() {
    }

    public Address(String name, String info) {
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
