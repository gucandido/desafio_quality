package com.desafioteste.desafioteste.dto;

import com.desafioteste.desafioteste.entity.District;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class DistrictDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotNull(message = "O nome do bairro não pode estar vazio.")
    @NotEmpty(message = "O nome do bairro não pode estar vazio.")
    @NotBlank(message = "O nome do bairro não pode estar em branco.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres")
    private String district_name;

    @NotNull(message = "O valor do metro quadrado no bairro não pode estar vazio")
    @Digits(integer = 11, fraction = 2, message = "O comprimento não pode exceder 13 dígitos, sendo 11 inteiros e 2 decimais")
    @DecimalMin(value = "0.0", inclusive = true, message = "O valor não pode ser negativo")
    private BigDecimal value_district_m2;

    public DistrictDto() {
    }

    public DistrictDto(@NotNull(message = "O nome do bairro não pode estar vazio.") @NotEmpty(message = "O nome do bairro não pode estar vazio.") @NotBlank(message = "O nome do bairro não pode estar em branco.") @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres") String district_name, @NotNull(message = "O valor do metro quadrado no bairro não pode estar vazio") @Digits(integer = 11, fraction = 2, message = "O comprimento não pode exceder 13 dígitos, sendo 11 inteiros e 2 decimais") @DecimalMin(value = "0.0", inclusive = true, message = "O valor não pode ser negativo") BigDecimal value_district_m2) {
        this.district_name = district_name;
        this.value_district_m2 = value_district_m2;
    }

    public DistrictDto(District dist) {
        this.district_name = dist.getDistrict_name();
        this.value_district_m2 = dist.getValue_district_m2();
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
    }

    public static DistrictDto classToDto(District dist){
        return new DistrictDto(dist);
    }

    public static District dtoToClass(DistrictDto dist){
        return new District(dist);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
