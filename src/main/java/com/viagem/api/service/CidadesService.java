package com.viagem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.viagem.api.model.Cidades;
import com.viagem.api.repository.CidadesRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CidadesService {
	
	
	@Autowired
	private CidadesRepository cidadesRepository;


	public List<Cidades> listar(){
	    return cidadesRepository.findAll();
    }


	public Page<Cidades> listarPaginado(Pageable pageable)  {
	    return cidadesRepository.findAll(pageable);
	}
	
    public Cidades salvar(Cidades cidade){ return cidadesRepository.save(cidade); }

    public Optional<Cidades> calcularMedia(Long id, Integer dias){
        Optional<Cidades> cidadeInfo = cidadesRepository.findById(id);
        Integer media = cidadeInfo.get().getValor() + (cidadeInfo.get().getValorRefeicao() * 2 * dias);
        cidadeInfo.get().setMedia(media);
        return cidadeInfo;
    }

    }



