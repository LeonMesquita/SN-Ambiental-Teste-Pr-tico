package com.api.company_manager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleDto {
    @NotBlank
    @Size(max = 35)
    private String desc_veiculo;

    @NotBlank
    @Size(max = 7)
    @Size(min = 7)
    private String placa;

    @NotNull
    private double valor;
}
