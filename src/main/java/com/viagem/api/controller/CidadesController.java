package com.viagem.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.viagem.api.model.Cidades;
import com.viagem.api.repository.CidadesRepository;
import com.viagem.api.service.CidadesService;

@RestController
@RequestMapping(value="/cidades")
public class CidadesController {
	
	@Autowired
	private CidadesRepository cidadesRepository;
	
	
	@Autowired
	private CidadesService cidadesService;	
	
	@GetMapping
	public List<Cidades> listar() { return cidadesRepository.findAll(); }

	@GetMapping(value="/{cidadeId}")
	public ResponseEntity<Cidades> buscarId(@PathVariable Long cidadeId){
		Optional<Cidades> cidade = cidadesRepository.findById(cidadeId);

		if(cidade.isPresent()){
			return ResponseEntity.ok(cidade.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidades salvar(@RequestBody Cidades cidade){
		return cidadesService.salvar(cidade);
	}
	
	

}
