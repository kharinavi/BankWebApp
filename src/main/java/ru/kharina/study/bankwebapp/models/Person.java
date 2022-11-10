package ru.kharina.study.bankwebapp.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message="Name should not be empty")
    @Size(min=2, max=30, message="Name should be between 2 and 30 characters")
    private String name = "";
    @NotEmpty(message="Surname should not be empty")
    @Size(min=2, max=30, message="Name should be between 2 and 30 characters")
    private String surname = "";
    @Min(value = 0, message="Age should be greater than 0")
    private int age = 0;

    private String experience = "";
    //private String isManager;

    public Person() {
    }

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLongName() {
        return name + " " + surname;
    }

    public String getDescription() {
        String result = "";
        if (!name.equals(""))
            result = result + "Name: " + name + "    ";
        if (!surname.equals(""))
            result = result + "Surname: " + surname + "    ";
        if (age != 0)
            result = result + "Age: " + age + "    ";
        if (!experience.equals(""))
            result = result + "Experience: " + experience + "    ";
        return result;
    }
}