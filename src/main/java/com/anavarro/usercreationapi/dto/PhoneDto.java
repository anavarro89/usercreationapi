package com.anavarro.usercreationapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class PhoneDto {
    @NotBlank(message = "El número de teléfono es obligatorio")
    private int phone;

    @NotBlank(message = "El código de ciudad es obligatorio")
    private int cityCode;

    @NotBlank(message = "El código de país es obligatorio")
    private int countryCode;


}
