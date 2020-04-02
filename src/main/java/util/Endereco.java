package util;

import lombok.*;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
    private TipoEnderecoEnum tipoEnderecoEnum;
    private String cep = "";
    private final String tipoLogradouro = "RUA";
    private String numero = "";
    private String complemento = "";
    private String bairro = "";
    private String endereco = "";
    private String municipio = "";

}



