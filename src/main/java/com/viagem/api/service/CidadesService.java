package com.viagem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.api.model.Cidades;
import com.viagem.api.repository.CidadesRepository;



@Service
public class CidadesService {
	
	
	@Autowired
	private CidadesRepository cidadesRepository;
	
    public Cidades salvar(Cidades cidade){ return cidadesRepository.save(cidade); }
    
    
    }



