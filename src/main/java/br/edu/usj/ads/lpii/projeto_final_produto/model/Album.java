package br.edu.usj.ads.lpii.projeto_final_produto.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Album {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    
    String nome;
    String genero;
    Integer ano;
    Time duracao;
   
 

  

}