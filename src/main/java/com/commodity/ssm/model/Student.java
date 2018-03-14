package com.commodity.ssm.model;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/3/14 19:18
 */
public class Student {

    private Integer studId;
    private String name;
    private String email;
    private String phone;
    private Address address;

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
       return  "studId-" + studId + " name-" + name +" email-"
                + email +" phone-" + phone + " addressId-" + address.getAddrId() +
                " street-" + address.getStreet() + " city-" + address.getCity() + " country " + address.getCountry()
                + " state " + address.getState() + " zip-" + address.getZip();
    }
}
