package com.example.myapplication.model;

public class Empleado {

    private long id;
    private String nombre;

    private String nombreCompleto;

    private String celular;

    private String confirmacionPassword;

    private String password;
    private String email;

    public Empleado(){
    }

    public  Empleado (String nombreCompleto, String password, String email, String celular, String confirmacionPassword){
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.email = email;
        this.celular=celular;
        this.confirmacionPassword=confirmacionPassword;
    }

    public long getId(){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password =password;
    }

    public String getEmail(){return email;}

    public void setEmail (String email){ this.email=email;}

    public String getNombreCompleto(){return nombreCompleto;}

    public void setNombreCompleto(String nombreCompleto){this.nombreCompleto = nombreCompleto;}

    public String getCelular(){return celular;}

    public void setCelular(String celular){this.celular=celular;}

    public String getConfirmacionPassword(){return confirmacionPassword;}

    public void setConfirmacionPassword(String confirmacionPassword){this.confirmacionPassword = confirmacionPassword;}

    public  String toString(){
        return "Empleado(" +
                "id=" + id +
                ", nombre='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", password='" + password + '\'' +
                ", confirmacionPassword='" + confirmacionPassword + '\'' +
                '}';
    }

}
