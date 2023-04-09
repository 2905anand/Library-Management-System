package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;

// import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Author;
import com.xfactor.openlibrary.repositories.AuthorRepository;

@RestController
@RequestMapping("authors")
public class AuthorsController {
    private AuthorRepository authorRepository;
    
    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    // ArrayList<Author> lAuthors = new ArrayList<>();

    @PostMapping("/saveAuthor")
    public Author saveAuthor(@RequestBody Author author){
        if(author.getId() == null){
            Author author2 = authorRepository.save(author);
            return author2;
        }
        return null;

    }

    @PutMapping("/updateAuthor")
    public Author updateAuthor(@RequestBody Author author){
        if(author.getId() != null){
            Author author2 = authorRepository.save(author);
            return author2;
        }
        return null;
    }
    @GetMapping("/getAllAuthor")
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Author findbyId(@PathVariable Long id){
        Optional<Author> optional = authorRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @GetMapping("/findByName/{name}")
    public List<Author> findByName(@PathVariable String name){
        List<Author> authors = authorRepository.findByName(name);
        return authors;
    }

    @GetMapping("/findTotal")
    public Long findTotal(){
        return authorRepository.count();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        authorRepository.deleteById(id);
    }
}
