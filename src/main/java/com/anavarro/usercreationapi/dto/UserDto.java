package com.anavarro.usercreationapi.dto;

import lombok.Builder;
import lombok.Getter;

import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@Builder
public class UserDto {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El correo es obligatorio")
    @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "El correo debe tener un formato válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{6,}$",
            message = "La contraseña debe tener minimo un largo de 6 caracteres, al menos una mayúscula y un número")
    private String password;
    @Valid
    private List<PhoneDto> phones;

}