package com.viagem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagem.api.model.Cozinha;
import com.viagem.api.repository.CozinhaRepository;
import com.viagem.api.service.CozinhaService;

@RestController
@RequestMapping(value="/cozinha")
public class CozinhaController {
	
	
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CozinhaService cozinhaService;	
	
	@GetMapping
	public List<Cozinha> listar() { return cozinhaRepository.findAll(); }
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha){
    	System.out.println(cozinha.getNome());
        return cozinhaService.salvar(cozinha);
    }
}
