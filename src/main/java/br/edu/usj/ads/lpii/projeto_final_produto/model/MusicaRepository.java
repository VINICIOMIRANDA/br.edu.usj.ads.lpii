package br.edu.usj.ads.lpii.projeto_final_produto.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MusicaRepository extends CrudRepository<Musica,Long> {
  List<Musica> findAll();

} 
  
