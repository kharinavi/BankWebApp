package ru.kharina.study.bankwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kharina.study.bankwebapp.dao.PersonDAO;
import ru.kharina.study.bankwebapp.models.Employee;
import ru.kharina.study.bankwebapp.models.Manager;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/manager/list")
    public String indexM(Model model) {
        model.addAttribute("people", personDAO.indexM());
        return "people/manager/list";
    }

    @GetMapping("/employee/list")
    public String indexE(Model model) {
        model.addAttribute("people", personDAO.indexE());
        return "people/employee/list";
    }

    @GetMapping("/manager/{id}")
    public String showM(@PathVariable("id") int id, Model model) {
        System.out.println(personDAO.showM(id).getDescription());
        model.addAttribute("person", personDAO.showM(id));
        return "people/manager/show";
    }

    @GetMapping("/employee/{id}")
    public String showE(@PathVariable("id") int id, Model model) {
        System.out.println(personDAO.showE(id).getDescription());
        model.addAttribute("person", personDAO.showE(id));
        return "people/employee/show";
    }

    @GetMapping("/manager/new")
    public String newPersonM(@ModelAttribute("person") Manager person) {
        return "people/manager/new";
    }

    @GetMapping("/employee/new")
    public String newPersonE(@ModelAttribute("person") Employee person) {
        return "people/employee/new";
    }

    @PostMapping("/manager/create")
    public String createM(@ModelAttribute("person") @Valid Manager person,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/manager/new";
        personDAO.saveM(person);
        return "redirect:/people/manager/list";
    }

    @PostMapping("/employee/create")
    public String createE(@ModelAttribute("person") @Valid Employee person,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/employee/new";
        personDAO.saveE(person);
        return "redirect:/people/employee/list";
    }

    @GetMapping("/manager/{id}/edit")
    public String editM(Model model, @PathVariable("id") int id) {
        Manager manager = personDAO.showM(id);
        model.addAttribute("person", manager);
        model.addAttribute("employers", personDAO.stringE());
        System.out.println(manager.getClass().getName());
        return "people/manager/edit";
    }

    @GetMapping("/employee/{id}/edit")
    public String editE(Model model, @PathVariable("id") int id) {
        Employee employee = personDAO.showE(id);
        model.addAttribute("person", employee);
        model.addAttribute("people", personDAO.stringM());
        return "people/employee/edit";
    }

    @PatchMapping("/manager/{id}")
    public String updateM(@ModelAttribute("person") @Valid Manager person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/manager/edit";
        personDAO.updateM(id, person);
        return "redirect:/people/manager/list";
    }

    @PatchMapping("/employee/{id}")
    public String updateE(@ModelAttribute("person") @Valid Employee person,
                          BindingResult bindingResult,
                          @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/employee/edit";
        personDAO.updateE(id, person);
        return "redirect:/people/employee/list";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteE(@PathVariable("id") int id) {
        personDAO.deleteE(id);
        return "redirect:/people/employee/list";
    }

    @DeleteMapping("/manager/{id}")
    public String deleteM(@PathVariable("id") int id) {
        personDAO.deleteM(id);
        return "redirect:/people/manager/list";
    }
}
