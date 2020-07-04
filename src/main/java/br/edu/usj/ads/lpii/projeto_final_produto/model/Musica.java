package br.edu.usj.ads.lpii.projeto_final_produto.model;

import javax.persistence.Id;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Musica {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    
    String nome_musica;
    String album;
    String artista;
    String gravadora;
    Integer ano;
    Time duracao;
    Double preco; 
  

}