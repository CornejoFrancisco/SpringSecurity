package com.demo.services.implementations;

import com.demo.entities.DTO.UsuarioDto;
import com.demo.entities.Transformations.Usuario.UsuarioDtoMapper;
import com.demo.entities.Transformations.Usuario.UsuarioMapper;
import com.demo.entities.Usuario;
import com.demo.respositories.UserRepository;
import com.demo.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository userRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioDtoMapper usuarioDtoMapper;

    public UsuarioServiceImpl(UserRepository userRepository, UsuarioMapper usuarioMapper, UsuarioDtoMapper usuarioDtoMapper) {
        this.userRepository = userRepository;
        this.usuarioMapper = usuarioMapper;
        this.usuarioDtoMapper = usuarioDtoMapper;
    }

    @Override
    public List<UsuarioDto> getAll() {
        List<Usuario> usuariosDto = userRepository.findAll();
        return usuariosDto.stream().map(usuarioDtoMapper).toList();
    }

    @Override
    public void update(UsuarioDto usuarioDto) {
        Optional<Usuario> usuario = Stream.of(usuarioDto)
                .map(usuarioMapper)
                .findAny();
        usuario.ifPresent(userRepository :: save);

    }

    @Override
    public void delete(Long id) {
        Optional<Usuario> usuario = userRepository.findById(id);
        usuario.ifPresent(userRepository :: delete);

    }

    @Override
    public UsuarioDto getById(Long id) {
        Optional<Usuario> usuario = userRepository.findById(id);
        return usuario.map(usuarioDtoMapper).orElseThrow();
    }


    @Override
    public void add(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setActivo(usuarioDto.getActivo());
        usuario.setId(usuario.getId());
        usuario.setName(usuario.getName());
        usuario.setPassword(usuario.getPassword());
        usuario.setId_perfil(usuario.getId_perfil());
        userRepository.save(usuario);
    }
}
