package com.example.gerenciador.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "empresas")
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nombre;

    public EmpresaEntity() {
    }

    public EmpresaEntity(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEntity empresaEntity = (EmpresaEntity) o;
        return Objects.equals(id, empresaEntity.id) && Objects.equals(nombre, empresaEntity.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
