package com.demo.respositories;

import com.demo.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRespository extends JpaRepository<Perfil, Long> {
}
