package com.wavemaker.training.db.model;

public class department {
    private int id;

    private String name ;

    private String locality;

    public department() {
    }

    public department(int id ,String name,String locality){
        this.id=id;
        this.name =name;
        this.locality=locality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locality='" + locality + '\'' +
                '}';
    }
}
