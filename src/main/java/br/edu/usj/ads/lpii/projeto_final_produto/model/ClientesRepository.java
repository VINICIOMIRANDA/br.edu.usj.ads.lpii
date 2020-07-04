package br.edu.usj.ads.lpii.projeto_final_produto.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Clientes,Long> {
  List<Clientes> findAll();
  List<Clientes> findByNome(String nome);
  List<Clientes> findByNomeContainingIgnoreCase(String nome);






} 
    
