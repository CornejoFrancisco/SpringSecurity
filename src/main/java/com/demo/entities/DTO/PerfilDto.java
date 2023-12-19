package com.demo.entities.DTO;

import com.demo.entities.EPerfil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PerfilDto {
    private Long id;
    @Enumerated(EnumType.STRING)
    private EPerfil name;


}
