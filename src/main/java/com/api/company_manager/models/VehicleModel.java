package com.api.company_manager.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "veiculo")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 35, name = "vDesc_veiculo")
    private String desc_veiculo;

    @Column(nullable = false, length = 7, name = "cPlaca", unique = true)
    private String placa;

    @Column(nullable = false, name = "nValor")
    private double valor;
}
