package ru.kharina.study.bankwebapp.dao;

import org.springframework.stereotype.Component;
import ru.kharina.study.bankwebapp.models.Employee;
import ru.kharina.study.bankwebapp.models.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonDAO {
    private static int MANAGERS_COUNT;
    private static int EMPLOYEE_COUNT;
    private List<Manager> managers;
    private List<Employee> employers;
    private Map<String,Employee> stringEmployeeMap;
    private Map<String,Manager> stringManagerMap;

    {
        managers = new ArrayList<>();
        stringManagerMap = new HashMap<>();
        Manager currentManager = new Manager(++MANAGERS_COUNT, "Katy", "Katy");
        managers.add(currentManager);
        stringManagerMap.put(currentManager.getName() + " " + currentManager.getSurname(), currentManager);
        currentManager = new Manager(++MANAGERS_COUNT, "Tom", "Tom");
        managers.add(currentManager);
        stringManagerMap.put(currentManager.getName() + " " + currentManager.getSurname(), currentManager);
        currentManager = new Manager(++MANAGERS_COUNT, "Bob", "Bob");
        managers.add(currentManager);
        stringManagerMap.put(currentManager.getName() + " " + currentManager.getSurname(), currentManager);
        currentManager = new Manager(++MANAGERS_COUNT, "Mike", "Mike");
        managers.add(currentManager);
        stringManagerMap.put(currentManager.getName() + " " + currentManager.getSurname(), currentManager);

        employers = new ArrayList<>();
        stringEmployeeMap = new HashMap<>();
        Employee currentEmployee = new Employee(++EMPLOYEE_COUNT, "Mary", "Mary");
        employers.add(currentEmployee);
        stringEmployeeMap.put(currentEmployee.getName() + " " + currentEmployee.getSurname(), currentEmployee);
        currentEmployee = new Employee(++EMPLOYEE_COUNT, "John", "John");
        employers.add(currentEmployee);
        stringEmployeeMap.put(currentEmployee.getName() + " " + currentEmployee.getSurname(), currentEmployee);
    }

    public Map<String, Employee> getStringEmployeeMap() {
        return stringEmployeeMap;
    }

    public void setStringEmployeeMap(Map<String, Employee> stringEmployeeMap) {
        this.stringEmployeeMap = stringEmployeeMap;
    }

    public List<Employee> indexE() {
        return employers;
    }
    public List<Manager> indexM() {
        return managers;
    }

    public List<String> stringM() {
        List<String> result = new ArrayList<>();
        for (Manager m: managers) {
            result.add(m.getName() + " " +m.getSurname());
        }
        return result;
    }

    public List<String> stringE() {
        List<String> result = new ArrayList<>();
        for (Employee e: employers) {
            result.add(e.getName() + " " +e.getSurname());
        }
        return result;
    }

    public Employee showE(int id) {
        return employers.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public Manager showM(int id) {
        return managers.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public int saveM(Manager person) {
        person.setId(++MANAGERS_COUNT);
        managers.add(person);
        stringManagerMap.put(person.getName() + " " + person.getSurname(), person);
        return MANAGERS_COUNT;
    }

    public int saveE(Employee person) {
        person.setId(++EMPLOYEE_COUNT);
        employers.add(person);
        stringEmployeeMap.put(person.getName() + " " + person.getSurname(), person);
        return EMPLOYEE_COUNT;
    }

    public void updateM(int id, Manager updatedPerson) {
        Manager personToBeUpdated = showM(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setSurname(updatedPerson.getSurname());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setExperience(updatedPerson.getExperience());
        personToBeUpdated.setEmployeeStringList(updatedPerson.getEmployeeStringList());
    }

    public void updateE(int id, Employee updatedPerson) {
        Employee personToBeUpdated = showE(id);
        personToBeUpdated.setName(updatedPerson.getName());

        personToBeUpdated.setSurname(updatedPerson.getSurname());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setExperience(updatedPerson.getExperience());
        personToBeUpdated.setSpecialization(updatedPerson.getSpecialization());
        personToBeUpdated.setManager(updatedPerson.getManager());
    }

    public void deleteE(int id) {
        employers.removeIf(p -> p.getId() == id);
    }
    public void deleteM(int id) {
        managers.removeIf(p -> p.getId() == id);
    }
}