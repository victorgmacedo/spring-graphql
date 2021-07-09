package br.com.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {

    private String nome;
    private String email;

}
