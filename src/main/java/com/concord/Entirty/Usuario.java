package com.concord.Entirty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer", unique = true)
    private Long idUsuario;

    @Column(length = 50, nullable = false)
    private String nombreUsuario;

    @Column(length = 100, nullable = false)
    private String correoElectronivo;

    @Column(length = 50, nullable = false)
    private String contraseña;

    @Column(length = 10, nullable = false)
    private  String estadoCuenta;

    @Column(length = 150, nullable = false)
    private String nombres;

    @Column(length = 150, nullable = false)
    private String apellidos;

    @Column(length = 100, nullable = false)
    private Long noCedula;

    @Column(length = 50, nullable = false)
    private String direccion;

    @Column(length = 50, nullable = false)
    private Long telefono;

    @Column(length = 2, nullable = false)
    private Long edad;

    @ManyToOne
    @JoinColumn(name = "idRol")
    @JsonBackReference
    private Rol rol;
}
