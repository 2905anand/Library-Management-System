package com.xfactor.openlibrary.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("StudentController")
public class Student123 {
    @GetMapping("/getstudent")
    public String getstudent(@RequestParam String name,@RequestParam int age,@RequestParam String dept){
        return "Student name is "+name+" age="+age+" dept="+dept;
    }
    @GetMapping("/getstudent_")
    public HashMap<String, String> getstudent_(@RequestParam String name,@RequestParam int age,@RequestParam String dept){
        HashMap<String, String> respHashMap = new HashMap<>();
        respHashMap.put("Dept",dept);
        respHashMap.put("Age",String.valueOf(age));
        respHashMap.put("Name",name);
        return respHashMap;
    }
}
