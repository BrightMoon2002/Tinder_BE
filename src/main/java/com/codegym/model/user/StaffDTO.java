package com.codegym.model.user;

public class StaffDTO {
    private Long id;
    private String genders;
    private String name;
    private String dob;
    private String city;
    private String nationality;
    private double height;
    private double weight;
    private String description;
    private String avatarList;

    public StaffDTO(Long id, String genders, String name, String dob, String city, String nationality, double height, double weight, String description) {
        this.id = id;
        this.genders = genders;
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }

    public StaffDTO(Long id, String genders, String name, String dob, String city, String nationality, double height, double weight, String description, String avatarList) {
        this.id = id;
        this.genders = genders;
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.avatarList = avatarList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarList() {
        return avatarList;
    }

    public void setAvatarList(String avatarList) {
        this.avatarList = avatarList;
    }
}
