package util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer municipio;
    private Integer pais;

}



