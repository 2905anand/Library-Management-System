package com.xfactor.openlibrary.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("HelloController")
public class Hello {
    // int x=0;
    @GetMapping("/hello")
    public String hello(@RequestParam String name,@RequestParam int number) {
        // int i=0;
        return "Hii "+name+" !! "+number;
    }
    @GetMapping("/hi/{name}")
    public String Sayhi(@PathVariable String name,@RequestParam int number){
        return "Hello "+name+" !! "+number;
    }
    @GetMapping("/hii/{name}/{age}")
    public HashMap<String, String> sayhi(@PathVariable int age, @PathVariable String name){
        HashMap<String, String> respHashMap = new HashMap<>();
        respHashMap.put("name",name);
        respHashMap.put("age",String.valueOf(age));
        return respHashMap;
    }
}
