package com.api.company_manager.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 80, unique = true)
    private String vNome_fantasia;

    @Column(nullable = false, length = 80, unique = true)
    private String vNome_razao_social;

    @Column(nullable = false, length = 14, unique = true)
    private String vCnpj;

    @Column(nullable = false, length = 10, unique = true)
    private String vEmail;

    @Column(nullable = false, length = 200)
    private String vObservacao;

    @OneToOne
    @JoinColumn(name = "iCod_endereco", referencedColumnName = "id")
    AddressModel endereco;
}
