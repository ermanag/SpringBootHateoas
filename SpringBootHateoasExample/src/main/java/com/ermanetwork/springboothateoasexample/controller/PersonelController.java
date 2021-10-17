package com.ermanetwork.springboothateoasexample.controller;

import com.ermanetwork.springboothateoasexample.model.Personel;
import com.ermanetwork.springboothateoasexample.service.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class PersonelController {

    @Autowired
    PersonelService personelService;

    @PostMapping("/save")
    ResponseEntity<String> addPersonel(@Valid @RequestBody Personel personel) {
        personelService.save(personel);
        Personel personel1 = new Personel();
        //personel1.add(linkTo(methodOn(PersonelController.class).addStudent(greeting)).withSelfRel());

        return new ResponseEntity<String>("", HttpStatus.OK);
    }
}
