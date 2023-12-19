package com.demo.services;

import com.demo.entities.DTO.UsuarioDto;
import com.demo.entities.Usuario;
import com.demo.services.implementations.UsuarioServiceImpl;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDto> getAll();
    void update(UsuarioDto usuarioDto);
    void delete(Long Id_usuario);
    UsuarioDto getById(Long id);
    void add(UsuarioDto usuarioDto);

}
