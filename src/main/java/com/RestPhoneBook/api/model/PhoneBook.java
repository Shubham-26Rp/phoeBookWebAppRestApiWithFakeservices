package com.RestPhoneBook.api.model;


public class PhoneBook {


    private int id;

    private String name;

    private int number;

    public PhoneBook(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public PhoneBook() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
