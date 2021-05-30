package com.viagem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viagem.api.model.Cidades;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Long>{

}
