package com.viagem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.api.model.Cozinha;
import com.viagem.api.repository.CozinhaRepository;



@Service
public class CozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
    public Cozinha salvar(Cozinha cozinha){     	
    	return cozinhaRepository.save(cozinha);
    	}

}
