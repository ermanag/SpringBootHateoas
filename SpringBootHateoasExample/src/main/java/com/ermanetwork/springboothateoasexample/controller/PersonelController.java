package com.ermanetwork.springboothateoasexample.controller;

import com.ermanetwork.springboothateoasexample.model.Personel;
import com.ermanetwork.springboothateoasexample.service.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class PersonelController {

    @Autowired
    PersonelService personelService;

    @PostMapping("/save")
    ResponseEntity<Personel> addPersonel(@Valid @RequestBody Personel personel) {
        personelService.save(personel);
        Personel personel1 = new Personel();
        personel1.add(linkTo(PersonelController.class).withSelfRel());

        return new ResponseEntity<Personel>(personel1, HttpStatus.OK);
    }

    @GetMapping("/list")
    public CollectionModel<Personel> getPersonelList(){
        List<Personel> allPersonel = personelService.getPersonelList();
        for (Personel personel : allPersonel) {
            Long personelId = personel.getId();
            Link selfLink = linkTo(PersonelController.class).slash(personelId).withSelfRel();
            personel.add(selfLink);
        }

        Link link = linkTo(PersonelController.class).withSelfRel();
        CollectionModel<Personel> result = CollectionModel.of(allPersonel, link);
        return result;
    }
}
