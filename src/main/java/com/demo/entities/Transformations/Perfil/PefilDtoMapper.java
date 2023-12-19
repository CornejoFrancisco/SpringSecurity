package com.demo.entities.Transformations.Perfil;

import com.demo.entities.DTO.PerfilDto;
import com.demo.entities.EPerfil;
import com.demo.entities.Perfil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PefilDtoMapper implements Function<Perfil, PerfilDto> {
    @Override
    public PerfilDto apply(Perfil perfil){
        return new PerfilDto(
                perfil.getId(),
                perfil.getName());
    }
}
