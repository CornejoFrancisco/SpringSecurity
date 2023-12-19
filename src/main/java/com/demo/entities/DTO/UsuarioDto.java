package com.demo.entities.DTO;

import com.demo.entities.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {
    private Long id;
    private Boolean activo;
    private String name;
    private String password;
    private Set<String> id_perfil;
}

