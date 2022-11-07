package ru.kharina.study.bankwebapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Manager extends Person{
    private List<String> employeeStringList = new ArrayList<>();

    public List<String> getEmployeeStringList() {
        return employeeStringList;
    }

    public void setEmployeeStringList(List<String> employeeStringList) {
        this.employeeStringList = employeeStringList;
    }

    public Manager(int i, String name, String surname) {
        setId(i);
        setName(name);
        setSurname(surname);
    }

    public Manager() {
    }

    public String getDescription() {
        String result = super.getDescription();
        String employersString = "";
        for (String employee : employeeStringList)
            employersString = employersString + employee + " ";
        if (!employersString.equals(""))
            result = result + String.format("Employer: %s", employersString);
        return result;
    }
}
