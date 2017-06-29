/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Competencia;
import modelo.Perro;

/**
 *
 * @author gabrielalozano
 */
public class AlmacenarCompetencias {

  private PrintWriter pw;
    private FileWriter fw;
    private File f;
    private PrintWriter printWriter;
    private ObjectOutputStream os;
    private FileOutputStream fs;
    
    public void escribirCompetenciasSerializado(ArrayList<Competencia> competencias){
        try{
            f = new File("CompetenciasSerializado.data");
            fs = new FileOutputStream(f);
            os = new ObjectOutputStream(fs);
            
            os.writeObject(competencias);
            os.close();
            JOptionPane.showMessageDialog(null, "Archivo serializado");
        }catch(IOException ex){
         JOptionPane.showMessageDialog(null, "Error escribiendo archivo" + ex);
        }
    }

    public void escribirCompetenciasArchivoPlano(ArrayList<Competencia> competencias) {
        try {
            f = new File("Competencias.txt");
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            for (Competencia comp : competencias) {
                String competencia = comp.getNombre() + ";";
                String perros = "";
                for (Perro perro : comp.getPerros()) {
                    perros += perro.getNombre() + ";" + perro.getRaza() + ";" + perro.getEdad() + ";" +  perro.getPuntos() ;
                }
                pw.println(competencia+ perros);
                JOptionPane.showMessageDialog(null, "Archivo escrito");
            }
            pw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error escribiendo archivo" + ex);
           
        }
    }
    



}
