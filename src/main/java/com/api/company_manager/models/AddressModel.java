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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 80)
    private String vLogradouro;

    @Column(nullable = false, length = 50)
    private String vComplemento;

    @Column(nullable = false, length = 40)
    private String vBairro;

    @Column(nullable = false, length = 10)
    private String vNumero;

    @Column(nullable = false, length = 2)
    private String cUF;
}
