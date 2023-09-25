package com.palacio.sucursales.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sucursales")
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long id;

    @NonNull
    @Column(name = "nombre_sucursal")
    private String nombreSucursal;

    @NonNull
    @Column(name = "direccion")
    private String direccion;

    @NonNull
    @Column(name = "telefono")
    private int telefono;

    @NonNull
    @Column(name = "estatus")
    private int estatus;

    @NonNull
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @NonNull
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @NonNull
    @Column(name = "empresa")
    private int empresa;
}
