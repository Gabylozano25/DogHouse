/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author gabrielalozano
 */
public class Perro implements Serializable{
    
    private String nombre;
    private String raza;
    private int edad;
    private int puntos;
    private String ruta;
    
    public Perro(){
        
    }

    public Perro(String nombre, String raza, int edad, int puntos, String ruta) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.puntos = puntos;
        this.ruta= ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String toString() {
        return nombre + ";" + raza + ";" + edad + ";" + puntos + ";"+ruta;
    }
    
    
    
    
    
    
    
    
    
}


