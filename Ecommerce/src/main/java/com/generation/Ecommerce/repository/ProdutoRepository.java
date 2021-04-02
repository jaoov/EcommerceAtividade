package com.generation.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.Ecommerce.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>
{
	public List<Produto> findAllByTituloContainingIgnoreCase(String titulo);
	
	public List<Produto> findAllByValorLessThanEqual (float valor);
	
	public List<Produto> findAllByValorGreaterThanEqual (float valor);
	
	@Query(value = "SELECT * FROM tb_produto where valor = :valor", nativeQuery = true)
	public List<Produto> findAllByValor(@Param("valor") float valor);
}
