package com.demo.entities.Transformations.Usuario;

import com.demo.entities.DTO.UsuarioDto;
import com.demo.entities.Perfil;
import com.demo.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UsuarioDtoMapper implements Function<Usuario, UsuarioDto> {
    @Override
    public UsuarioDto apply(Usuario usuario) {
        Set<String> perfilIds = Optional.ofNullable(usuario.getId_perfil())
                .orElse(Collections.emptySet())
                .stream()
                .map(perfil -> perfil.getName().toString())
                .collect(Collectors.toSet());




        return new UsuarioDto(
                usuario.getId(),
                usuario.getActivo(),
                usuario.getName(),
                usuario.getPassword(),
                perfilIds
        );
    }
}
