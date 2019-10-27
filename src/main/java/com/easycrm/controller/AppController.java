package com.easycrm.controller;

import com.easycrm.model.Cat;
import com.easycrm.model.Crocodile;
import com.easycrm.model.Dog;
import com.easycrm.model.Hedgehog;
import com.easycrm.service.TableAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ImportResource(value = "classpath:ioc.xml")
public class AppController {
    private final Cat cat;
    private Hedgehog hedgehog;
    private final Dog dog;
    private final Crocodile crocodile;
    private TableAction tableAction;

    public AppController(Cat cat, Dog dog, Crocodile crocodile, TableAction tableAction) {
        this.cat = cat;
        this.dog = dog;
        this.crocodile = crocodile;
        this.tableAction = tableAction;
    }

    // http://yandex.ru/hello/
    // front controller
    @RequestMapping("/hello/{name}")
    public String getHelloPage(@PathVariable("name") String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("cat", cat.getName());
        dog.setName("Sharik");
        model.addAttribute("dog", dog.getName());
        crocodile.setName("Gena");
        model.addAttribute("crocodile", crocodile.getName());
        model.addAttribute("hedgehog", hedgehog.getName());
        return "hello";
    }

    @RequestMapping("/sql/create")
    public String getTableCreationStatus(Model model) {
        model.addAttribute("status", tableAction.tableCreationStatus());
        return "sql";
    }

    @RequestMapping("/sql/get/{name}")
    public String getCatsCountByName(@PathVariable("name") String name, Model model) {
        model.addAttribute("count", tableAction.getInfo(name));
        return "cats";
    }

    @Qualifier("hedgehogGood")
    @Autowired
    public void setHedgehog(Hedgehog hedgehog) {
        this.hedgehog = hedgehog;
    }

//    @Autowired
//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }
}
