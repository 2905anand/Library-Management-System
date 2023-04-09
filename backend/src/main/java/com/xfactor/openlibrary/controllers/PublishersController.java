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

import com.xfactor.openlibrary.domain.Publisher;
import com.xfactor.openlibrary.repositories.PublisherRepository;

@RestController
@RequestMapping("publisher")
public class PublishersController {

    private PublisherRepository publisherRepository;

    public PublishersController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
    
    @PostMapping("/savePublisher")
    public Publisher savePublisher(@RequestBody Publisher publisher){
        if(publisher.getId() == null){
            Publisher publisher2 = publisherRepository.save(publisher);
            return publisher2;
        }
        return null;
    }

    @PutMapping("/updatePublisher")
    public Publisher updatePublisher(@RequestBody Publisher publisher){
        if(publisher.getId() != null){
            Publisher publisher2 = publisherRepository.save(publisher);
            return publisher2;
        }
        return null;
    }

    @GetMapping("/getAllPublisher")
    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Publisher findById(@PathVariable Long id){
        Optional<Publisher> optional = publisherRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @GetMapping("/findByName/{name}")
    public List<Publisher> findByName(@PathVariable String name){
        List<Publisher> publishers = publisherRepository.findByName(name);
        return publishers;
    }

    @GetMapping("/findTotal")
    public Long findAll(){
        return publisherRepository.count();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePublisher(@PathVariable Long id){
        publisherRepository.deleteById(id);
    }

}
