package br.senai.sp.cadastro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Cliente {

    private Long id;
    private String nome;
    private String email;
}