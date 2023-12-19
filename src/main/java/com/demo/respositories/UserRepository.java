package com.demo.respositories;

import com.demo.entities.DTO.UsuarioDto;
import com.demo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.name = ?1")
    Optional<Usuario> getName(String name);

}

