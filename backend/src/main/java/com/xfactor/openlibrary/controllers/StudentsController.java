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

import com.xfactor.openlibrary.domain.Student;
import com.xfactor.openlibrary.repositories.StudentRepository;

@RestController
@RequestMapping("student")
public class StudentsController {
    private StudentRepository studentRepository;

    public StudentsController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        if(student.getId() == null){
            Student student2 = studentRepository.save(student);
            return student2;
        }
        return null;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        if(student.getId() != null){
            Student student2 = studentRepository.save(student);
            return student2;
        }
        return null;
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable Long id){
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @GetMapping("/findByName/{name}")
    public List<Student> findByName(@PathVariable String name){
        List<Student> students = studentRepository.findByName(name);
        return students;
    }

    @GetMapping("/findTotal")
    public Long findAll(){
        return studentRepository.count();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePublisher(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

}
