package com.generation.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.Ecommerce.model.Inscricao;
import com.generation.Ecommerce.repository.InscricaoRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inscricao")
public class InscricaoController 
{
	@Autowired
	private InscricaoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Inscricao>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Inscricao> GetById(@PathVariable long id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Inscricao> post (@RequestBody Inscricao inscricao)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(inscricao));
	}
	
	@PutMapping
	public ResponseEntity<Inscricao> put (@RequestBody Inscricao inscricao)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(inscricao));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) 
	{
		repository.deleteById(id);
	}
}
