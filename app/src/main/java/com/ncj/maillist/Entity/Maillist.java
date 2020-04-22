package com.ncj.maillist.Entity;

/**
 * Created by 咸蛋糙人 on 2020/4/15.
 */

public class Maillist {
    private Integer id;
    private String name;
    private String phone;
    private byte[] image;

    public Maillist(){
    }
    public Maillist(String name, String phone, byte[] image){
        this.name = name;
        this.phone = phone;
        this.image = image;
    }
    public Maillist(int id, String name, String phone, byte[] image){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Maillist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
