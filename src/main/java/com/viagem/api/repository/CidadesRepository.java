package com.viagem.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.viagem.api.model.Cidades;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Long>{

    Page<Cidades> buscarTudo(Pageable pageable, Sort sort);
}
