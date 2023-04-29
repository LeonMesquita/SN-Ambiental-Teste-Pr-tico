package com.api.company_manager.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "endereco")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80, name = "vLogradouro")
    private String logradouro;

    @Column(nullable = false, length = 50, name = "vComplemento")
    private String complemento;

    @Column(nullable = false, length = 40, name = "vBairro")
    private String bairro;

    @Column(nullable = false, length = 10, name = "vNumero")
    private String numero;

    @Column(nullable = false, length = 2, name = "cUf")
    private String uf;
}
