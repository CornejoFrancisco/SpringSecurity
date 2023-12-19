package com.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "PERFILES")
public class Perfil {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @TableGenerator(name = "PERFILES", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    @Column(name = "ID")
    private long id;

    @Enumerated(EnumType.STRING)
    private EPerfil name;


}
