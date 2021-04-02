package com.generation.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.Ecommerce.model.Inscricao;
import com.generation.Ecommerce.model.Produto;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long>
{
	
}
