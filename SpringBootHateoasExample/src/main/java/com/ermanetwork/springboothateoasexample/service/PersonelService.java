package com.ermanetwork.springboothateoasexample.service;

import com.ermanetwork.springboothateoasexample.model.Personel;
import com.ermanetwork.springboothateoasexample.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class PersonelService {

    @Autowired
    PersonelRepository personelRepository;

    public void save(@Valid Personel personel){
        personelRepository.save(personel);
    }
}
