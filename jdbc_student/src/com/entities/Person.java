package com.entities;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String age;
    private String base;
    private String ave_base;

    public Person(){

    }
    public Person(String firstName, String lastName, String age, String base , String ave_base){

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.base = base;
        this.ave_base = ave_base;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getAve_base() {
        return ave_base;
    }

    public void setAve_base(String ave_base) {
        this.ave_base = ave_base;
    }



}
