/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabrielalozano
 */
public class LeerArchivos {

    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
    private String rutaPerros;
    private String rutaCompetencias;
    
    
    
    public Object leerObjetoSerializado(String nombreArchivo)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        file = new File(nombreArchivo);
        fileInputStream = new FileInputStream(file);
        objectInputStream = new ObjectInputStream(fileInputStream);
        Object objetoArchivo = objectInputStream.readObject();
        objectInputStream.close();
        return objetoArchivo;
    }

    public ArrayList leerArchivoPlano(String nombreArchivo)
            throws FileNotFoundException, IOException {
        file = new File(nombreArchivo);
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        ArrayList contenidoArchivo = new ArrayList();
        while (Boolean.TRUE) {
            String linea = bufferedReader.readLine();
            if (linea == null) {
                break;
            }
            contenidoArchivo.add(linea);
        }
        bufferedReader.close();
        return contenidoArchivo;
    }
    
    
    
    

//    public String getRutaPerros() {
//        return rutaPerros;
//    }
//
//    public void setRutaPerros(String rutaPerros) {
//        this.rutaPerros = rutaPerros;
//    }
//
//    public String getRutaCompetencias() {
//        return rutaCompetencias;
//    }
//
//    public void setRutaCompetencias(String rutaCompetencias) {
//        this.rutaCompetencias = rutaCompetencias;
//    }
//
//    public LeerArchivos() {
//        rutaPerros = "./Perros.txt";
//        rutaCompetencias = "./Competencias.txt";
//
//    }
//
//    public void verificarArchivos() {
//
//        verificarArchivo(rutaPerros);
//        verificarArchivo(rutaCompetencias);
//
//    }
//
//    public void verificarArchivo(String ruta) {
//        try {
//            File filex;
//            filex = new File(ruta);
//            if (!filex.exists()) {
//                filex.createNewFile();
//            }
//        } catch (IOException ex) {
//            JOptionPane.showInputDialog(null, "No se pudo crear el archivo");
//        }
//    }
//

}
