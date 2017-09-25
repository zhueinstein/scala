package com.learn.collection;

/**
 * Created by zcx on 2017/9/23.
 */
public class Person {
    private Integer uid;
    private String name;
    private String address;

    public Person(Integer uid, String name, String address) {
        this.uid = uid;
        this.name = name;
        this.address = address;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
