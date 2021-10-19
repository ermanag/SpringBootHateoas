package com.ermanetwork.springboothateoasexample.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
public class Personel extends RepresentationModel<Personel> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, message = "Ad Soyad Boş Olamaz")
    private String nameSurname;

    @Email(message = "Geçerli Bir Mail Adresi Giriniz")
    private String emailAdress;

    @PositiveOrZero(message = "Personel Yaşı Negatif Olamaz")
    @Min(value = 18)
    private int personelAge;

    @Pattern(regexp = "[0-9\\s]{12}")
    private String phoneNumber;
}
