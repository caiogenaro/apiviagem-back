package com.viagem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.api.model.Cidades;
import com.viagem.api.repository.CidadesRepository;

import java.util.Optional;


@Service
public class CidadesService {
	
	
	@Autowired
	private CidadesRepository cidadesRepository;
	
    public Cidades salvar(Cidades cidade){ return cidadesRepository.save(cidade); }



    public Optional<Cidades> calcularMedia(Long id, Integer dias){
        Optional<Cidades> cidadeInfo = cidadesRepository.findById(id);

        Integer media = cidadeInfo.get().getValor() * dias;
        cidadeInfo.get().setMedia(media);
        return cidadeInfo;
    }
    
    }



