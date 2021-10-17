package com.ermanetwork.springboothateoasexample.repository;

import com.ermanetwork.springboothateoasexample.model.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonelRepository extends JpaRepository<Personel, Long> {
}
