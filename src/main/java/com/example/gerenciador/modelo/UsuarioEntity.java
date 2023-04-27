package com.example.gerenciador.modelo;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private String login;
    private String contrasena;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String login, String contrasena) {
        this.login = login;
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean esIgual(String login, String contrasena){
        if (!this.login.equals(login)){
            return false;
        }
        if (!this.contrasena.equals(contrasena)){
            return false;
        }
        return true;
    }
}
