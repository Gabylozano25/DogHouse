/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import archivos.LeerArchivos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import modelo.Competencia;
import modelo.Perro;

/**
 *
 * @author gabrielalozano
 */
public class Controlador {

    private ArrayList<Perro> perros;
    private ArrayList<Competencia> competencias;
    private LeerArchivos leerArchivos;

    public Controlador() {
        perros = new ArrayList<Perro>();
        competencias = new ArrayList<Competencia>();
    }

    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public void setPerros(ArrayList<Perro> perros) {
        this.perros = perros;
    }

    public ArrayList<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(ArrayList<Competencia> competencias) {
        this.competencias = competencias;
    }

    public void crearCompetencia(String nombre, String lugar, String fecha) {

        Competencia comp = new Competencia(nombre, lugar, fecha);
        this.competencias.add(comp);
        JOptionPane.showMessageDialog(null, "Competencia agregada");

    }

    public void crearPerro(String nombre, String raza, int edad, int puntos, String ruta) {

        Perro perro = new Perro(nombre, raza, edad, puntos,ruta);
        perros.add(perro);
        JOptionPane.showMessageDialog(null, "Perro creado");

    }

    public void asignaPerroCompetencia(String nombre, String nombreCom) {

        for (Competencia c : competencias) {
            if (c.getNombre().equals(nombreCom)) {

                for (Perro p : perros) {
                    if (p.getNombre().equals(nombre)) {
                        c.getPerros().add(p);
                        JOptionPane.showMessageDialog(null, "Perro agregado a la competencia");
                    }
                }

            }
        }

    }

    public void ordenarPorPuntos(ArrayList<Perro> perros) {
        Collections.sort(perros, new Comparator<Perro>() {
            @Override
            public int compare(Perro p1, Perro p2) {
                return p1.getPuntos() < p2.getPuntos() ? -1
                        : p1.getPuntos() == p2.getPuntos() ? 0 : 1;
            }

        });

    }

    public void ordenarPorNombre(ArrayList<Perro> perros) {
        Collections.sort(perros, new Comparator<Perro>() {
            @Override
            public int compare(Perro p1, Perro p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }

        });

    }

    public void ordenarPorRaza(ArrayList<Perro> perros) {
        Collections.sort(perros, new Comparator<Perro>() {
            @Override
            public int compare(Perro p1, Perro p2) {
                return p1.getRaza().compareTo(p2.getRaza());
            }

        });

    }



    public ArrayList<Perro> cargarPerrosArchivoPlano() {
        ArrayList<String> lineasArchivo = new ArrayList<>();
        ArrayList<Perro> perrosCargados = new ArrayList<>();
      

        if (this.leerArchivos == null) {
            this.leerArchivos = new LeerArchivos();
        }

        try {
            lineasArchivo = this.leerArchivos.leerArchivoPlano("Competencias.txt");
            for (String s : lineasArchivo) {
                String[] datosPerro = s.split(";");
                String nombre = datosPerro[0];
                String raza = datosPerro[1];
                String edad = datosPerro[2];
                String puntos = datosPerro[3];                
                String ruta= datosPerro[4];

                Perro p = new Perro(nombre,raza,Integer.parseInt(edad),Integer.parseInt(puntos), ruta);
                p.setNombre(nombre);
                
               perrosCargados.add(p);
               
            }
            JOptionPane.showMessageDialog(null, "Se cargo el archivo plano");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo plano");

        }
        return perrosCargados;
    }
    
 
       private ArrayList<Perro> cargarPerrosSerializados(){
        ArrayList<Perro> perrosArchivo = new ArrayList<>();
        if(this.leerArchivos == null){
            this.leerArchivos = new LeerArchivos();
        }
        
        try{
            perrosArchivo = (ArrayList<Perro>)this.leerArchivos.leerObjetoSerializado("CompetenciasSerializado.data");
           JOptionPane.showMessageDialog(null, "Se cargo el archivo serializado");       
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo serializado");
  
        }
        
        return perrosArchivo;
    }

}
