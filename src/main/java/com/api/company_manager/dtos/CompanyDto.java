package com.api.company_manager.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CompanyDto {
    @NotBlank
    @Size(max = 80)
    private String nome_fantasia;

    @NotBlank
    @Size(max = 80)
    private String nome_razao_social;

    @NotBlank
    @Size(max = 14)
    private String cnpj;

    @NotBlank
    @Size(max = 10)
    private String email;

    @NotBlank
    @Size(max = 200)
    private String observacao;

    @NotNull
    private Integer id_endereco;

    @NotNull
    private List<Integer> vehicles_ids;

}