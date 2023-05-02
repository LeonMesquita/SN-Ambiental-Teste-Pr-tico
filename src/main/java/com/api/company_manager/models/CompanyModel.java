package com.api.company_manager.models;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80, name = "vNome_fantasia")
    private String nome_fantasia;

    @Column(nullable = false, length = 80, name = "vNome_razao_social")
    private String nome_razao_social;

    @Column(nullable = false, length = 14, unique = true, name = "vCnpj")
    private String cnpj;

    @Column(nullable = false, length = 10, unique = true, name = "vEmail")
    private String email;

    @Column(nullable = false, length = 200, name = "vObservacao")
    private String observacao;

    @OneToOne
    @JoinColumn(name = "iCod_endereco", referencedColumnName = "id")
    AddressModel endereco;

    @OneToMany
    @JoinColumn(name = "iCod_empresa")
    private List<VehicleModel> veiculos;
}
