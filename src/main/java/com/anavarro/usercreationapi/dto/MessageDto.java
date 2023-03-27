package com.anavarro.usercreationapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MessageDto {
    private String message;
}
