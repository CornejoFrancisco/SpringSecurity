package com.demo.entities.Transformations.Usuario;

import com.demo.entities.DTO.UsuarioDto;
import com.demo.entities.Perfil;
import com.demo.entities.Usuario;
import com.demo.respositories.PerfilRespository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UsuarioMapper implements Function<UsuarioDto, Usuario> {
    private final PerfilRespository perfilRespository;

    public UsuarioMapper(PerfilRespository perfilRespository) {
        this.perfilRespository = perfilRespository;
    }

    @Override
    public Usuario apply(UsuarioDto usuarioDto) {
        Set<String> perfilIds = usuarioDto.getId_perfil();


        Set<Long> perfilIds1 = perfilIds.stream()
                .map(Long::valueOf)  // Convert each String to Long
                .collect(Collectors.toSet());

        Set<Perfil> perfiles = perfilIds1.stream()
                .map(perfilRespository::getReferenceById)
                .collect(Collectors.toSet());;

        Usuario usuario = new Usuario(
                usuarioDto.getId(),
                usuarioDto.getActivo(),
                usuarioDto.getName(),
                usuarioDto.getPassword(),
                perfiles
        );

        return usuario;
    }
}
