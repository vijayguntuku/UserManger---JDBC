package com.wavemaker.training.db.model;

public class employee {
    private int Id;

    private String name;

    private String mobile;

    private int department_id;

    private int address_id;

    public employee(int id, String name, String mobile, int department_id, int address_id) {
        Id = id;
        this.name = name;
        this.mobile = mobile;
        this.department_id = department_id;
        this.address_id = address_id;
    }
    public employee(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", department_id=" + department_id +
                ", address_id=" + address_id +
                '}';
    }

}
