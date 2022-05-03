package com.codegym.entity;

public class MedicalDeclaration {
    private String id;
    private String name;
    private String birthday;
    private String gender;
    private String nationality;
    private String identification;
    private String vehicle;
    private String numberVehicle;
    private String numberSeats;
    private String city;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String id, String name, String birthday, String gender, String nationality, String identification, String vehicle, String numberVehicle, String numberSeats, String city) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.nationality = nationality;
        this.identification = identification;
        this.vehicle = vehicle;
        this.numberVehicle = numberVehicle;
        this.numberSeats = numberSeats;
        this.city = city;
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public String getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(String numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
