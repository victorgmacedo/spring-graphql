package br.com.graphql.inputs;

import br.com.graphql.model.Cliente;
import br.com.graphql.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraInput {

    private Long id;
    private Long quantidade;
    private String status;
    private Long clienteId;
    private Long produtoId;
}
