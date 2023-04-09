package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Admin;
import com.xfactor.openlibrary.repositories.AdminRepository;

@RestController
@RequestMapping("admin")
public class AdminsController {
    
    private AdminRepository adminRepository;

    public AdminsController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    @PostMapping("/saveAdmin")
    public Admin saveAdmin(@RequestBody Admin admin){
        if(admin.getId() == null){
            Admin admin2 = adminRepository.save(admin);
            return admin2;
        }
        return null;

    }

    @PutMapping("/updateAdmin")
    public Admin updateAdmin(@RequestBody Admin admin){
        if(admin.getId() != null){
            Admin admin2 = adminRepository.save(admin);
            return admin2;
        }
        return null;
    }
    @GetMapping("/getAllAdmin")
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Admin findbyId(@PathVariable Long id){
        Optional<Admin> optional = adminRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @GetMapping("/findByName/{name}")
    public List<Admin> findByName(@PathVariable String name){
        List<Admin> admins = adminRepository.findByName(name);
        return admins;
    }

    @GetMapping("/findTotal")
    public Long findTotal(){
        return adminRepository.count();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        adminRepository.deleteById(id);
    }
    
}
