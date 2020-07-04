package br.edu.usj.ads.lpii.projeto_final_produto.model;

import javax.persistence.Id;
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

public class Clientes {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    
    String nome;
    String idade;
    String telefone;
    String email;
    String senha;
  

}