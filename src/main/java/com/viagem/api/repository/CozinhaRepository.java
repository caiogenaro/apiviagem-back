package com.viagem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viagem.api.model.Cozinha;


@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {	

}
