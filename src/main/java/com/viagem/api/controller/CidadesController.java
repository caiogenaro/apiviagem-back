package com.viagem.api.controller;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.web.PageableDefault;
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
	public List<Cidades> listar() {
		return cidadesService.listar();
	}

	@GetMapping(value="/listarPaginado")
	public Page<Cidades> listar(@RequestParam Optional<Integer> page) throws Exception {
		return cidadesService.listarPaginado(PageRequest.of(page.orElse(0), 6), Sort.by("valor").ascending());
	}

	@GetMapping(value="/{cidadeId}")
	public ResponseEntity<Cidades> buscarId(@PathVariable Long cidadeId){
		Optional<Cidades> cidade = cidadesRepository.findById(cidadeId);

		if(cidade.isPresent()){
			return ResponseEntity.ok(cidade.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping(value="/media/{cidadeId}")
	public Optional<Cidades> calcularMedia(@PathVariable Long cidadeId, @RequestParam("dias")Integer dias){
		Optional<Cidades> media = cidadesService.calcularMedia(cidadeId, dias);
		return media;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidades salvar(@RequestBody Cidades cidade){
		return cidadesService.salvar(cidade);
	}



}
