package com.example.myapplication22222;



public class ProClass {

    private String name;
    private String description;
    private String address;
    private ProCat category;
    private String photo;
    private String phone;


    public ProClass(String name, String description, String address,
                      ProCat category, String photo, String phone) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.category = category;
        this.photo = photo;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProCat getCategory() {
        return category;
    }

    public void setCategory(ProCat category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Professional{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", category=" + category +
                ", photo='" + photo + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
