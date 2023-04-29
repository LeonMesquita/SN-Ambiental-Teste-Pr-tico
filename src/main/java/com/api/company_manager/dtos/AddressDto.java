package com.api.company_manager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDto {
    @NotBlank
    @Size(max = 80)
    private String vLogradouro;

    @NotBlank
    @Size(max = 50)
    private String vComplemento;

    @NotBlank
    @Size(max = 40)
    private String vBairro;

    @NotBlank
    @Size(max = 10)
    private String vNumero;

    @NotBlank
    @Size(min = 2)
    @Size(max = 2)
    private String cUF;

}