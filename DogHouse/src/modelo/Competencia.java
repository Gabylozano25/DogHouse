/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author gabrielalozano
 */
public class Competencia implements Serializable {

    private String nombre;
    private String lugar;
    private String fecha;
    private ArrayList<Perro> perros;

    public Competencia() {
        this.nombre = "";
        this.lugar = "";
        this.fecha = "";
        this.perros = new ArrayList<>();
    }

    public Competencia(String nombre, String lugar, String fecha) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.perros = new ArrayList<>();
    }

    public Competencia(String nombre, String lugar, String fecha, ArrayList<Perro> perros) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.perros = perros;

    }

    

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPerros(ArrayList<Perro> perros) {
        this.perros = perros;
    }

    public void agregarPerro(Perro perro) {
        this.perros.add(perro);
    }

    public String toString() {
        return nombre + " ;" + lugar + ";" + fecha + ";" + perros;
    }

}
