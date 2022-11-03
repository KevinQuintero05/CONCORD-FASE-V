package com.concord.Entity;

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
    @Column(name = "idUsuario", unique = true)
    private Long idusuario;

    @Column(length = 50, nullable = false)
    private String nombreusuario;

    @Column(length = 100, nullable = false)
    private String correoelectronico;

    @Column(length = 50, nullable = false)
    private String contraseña;

    @Column(length = 10, nullable = true)
    private  String estadocuenta;

    @Column(length = 150, nullable = false)
    private String nombres;

    @Column(length = 150, nullable = false)
    private String apellidos;

    @Column(length = 100, nullable = false)
    private Long nocedula;

    @Column(length = 50, nullable = false)
    private String direccion;

    @Column(length = 50, nullable = false)
    private Long telefono;

    @Column(length = 2, nullable = false)
    private Long edad;

    @ManyToOne
    @JoinColumn(name = "idrol")
    @JsonBackReference
    private Rol rol;
}
