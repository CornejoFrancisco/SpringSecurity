package com.demo.controllers;


import com.demo.entities.DTO.UsuarioDto;
import com.demo.entities.EPerfil;
import com.demo.entities.Perfil;
import com.demo.entities.Usuario;
import com.demo.respositories.UserRepository;
import com.demo.services.UsuarioService;
import com.demo.services.implementations.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UsuarioController(UsuarioServiceImpl usuarioService, UserRepository userRepository) {
        this.usuarioService = usuarioService;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDto>> getAll(){
        List<UsuarioDto> values = usuarioService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getByid(@PathVariable("id") Long id){
        UsuarioDto values = usuarioService.getById(id);
        return ResponseEntity.ok(values);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody UsuarioDto entity) {
        Set<Perfil> perfils = entity.getId_perfil().stream()
                .map(perfil -> Perfil.builder()
                        .name(EPerfil.valueOf(perfil))
                        .build())
                .collect(Collectors.toSet());
        Usuario usuario = Usuario.builder()
                .name(entity.getName())
                .password(passwordEncoder.encode(entity.getPassword()))
                .activo(entity.getActivo())
                .id_perfil(perfils).build();
        userRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }


    @PutMapping()
    public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioDto entity) {
        usuarioService.update(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDto> delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
