package util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import util.Endereco;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerC {

    private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

    private int rowNumber = 0;
    private Integer birthday = 0;
    private ZonedDateTime atualizacao;
    private Integer codigo = 0;
    private final String tipoCustomer = "CLIENTE";
    private String municipio = "";
    private String tipoPessoa = "FISICIA";
    private String razaoSocial = "lele";
    private String fantasia = "";
    private String cpfCnpj = "";
    private double limit = 0;
    private String rgIe = "";
    private String email = "";
    private final boolean isentoIcms = false;
    private final boolean ehSimples = false;
    private String celular = "";
    private String fone = "";
    private String observacao = "";

    //    @JoinTable(name = "Endereco",
//            joinColumns = {@JoinColumn(name = "codCostumer", referencedColumnName = "codigo")},
//            inverseJoinColumns = {@JoinColumn(name = "codEndereco", referencedColumnName = "codigo")})
//    @ManyToMany
//    private List<Endereco> enderecos;

    public String toString() {
        return "CustomerC{" +
                "codigo =" + codigo + '\'' +
                "birthday=" + birthday +
                ", tipoCustomer='" + tipoCustomer + '\'' +
                ", municipio='" + municipio + '\'' +
                ", tipoPessoa='" + tipoPessoa + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", fantasia='" + fantasia + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", limit='" + limit + '\'' +
                ", rgIe='" + rgIe + '\'' +
                ", email='" + email + '\'' +
                ", isentoIcms='" + isentoIcms + '\'' +
                ", ehSimples='" + ehSimples + '\'' +
                ", celular='" + celular + '\'' +
                ", fone='" + fone + '\'' +
                ", observacao='" + observacao + '\'' +
                ", enderecos='" + enderecos + '\'' +
                //  "pais=" + pais + '\'' +
                '}';
    }
}
