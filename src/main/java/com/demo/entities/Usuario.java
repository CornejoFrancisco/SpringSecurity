package com.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.BindParam;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "USUARIOS", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private Long id;

    @Column(name = "ACTIVO")
    private Boolean activo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Perfil.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "User_Perfiles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))

    private Set<Perfil> id_perfil;




}
