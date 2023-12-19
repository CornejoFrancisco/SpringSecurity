package com.demo.entities.Transformations.Perfil;

import com.demo.entities.DTO.PerfilDto;
import com.demo.entities.Perfil;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PerfilMapper implements Function<PerfilDto, Perfil> {

    @Override
    public Perfil apply(PerfilDto perfilDto){
        return new Perfil(
                perfilDto.getId(),
                perfilDto.getName()
        );
    }
}
