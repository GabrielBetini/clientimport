package util;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
    private String tipoEndereco;
    private String cep;
    private String tipoLogradouro;
    private String numero;
    private String complemento;
    private String bairro;

}



