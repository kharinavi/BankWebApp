package ru.kharina.study.bankwebapp.models;

import javax.validation.constraints.NotEmpty;

public class Employee extends Person{
    private String specialization = "";
    private String manager = "";

    public Employee(int i, String name, String surname) {
        setId(i);
        setName(name);
        setSurname(surname);
    }

    public Employee() {

    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDescription() {
        String result = super.getDescription();
        if (!specialization.equals(""))
            result = result + "Specialization: " + specialization + "    ";
        if (!manager.equals(""))
            result = result + "Manager: " + manager ;
        return result;
    }
}
