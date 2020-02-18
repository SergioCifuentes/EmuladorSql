/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.manejadorArchivo;

import emuladorsql.cup.AnalizadorSintactico;
import emuladorsql.ui.PantallaPrincipal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class ManejadorIde {

    private final static String EXTENSION = ".ide";
    private final static String PROYECTO = "<PROYECTO nombre=\"%s\">";
    private final static String PROYECTOC = "</PROYECTO>";

    public void crearArchivoIde(String path, String nombre) {
        File fileIde = new File(path + "/" + nombre + EXTENSION);
        try {
            fileIde.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ManejadorIde.class.getName()).log(Level.SEVERE, null, ex);
        }
        agregarProyectoAIde(fileIde, nombre);
    }

    public void agregarProyectoAIde(File file, String nombre) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(PROYECTO.replace("%s", nombre) + "\n" + PROYECTOC);
            fileWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(ManejadorIde.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void abrirProyectoIde(File proyecto, PantallaPrincipal pr) {
        String textoArchivo = "";
        BufferedReader br = null;
        if (proyecto.getPath().endsWith(".ide")) {

        } else {
            File fileIde = new File(proyecto.getPath() + "/" + proyecto.getName() + ".ide");
            try {
                br = new BufferedReader(new FileReader(fileIde));
                while (true) {
                    textoArchivo += br.readLine();

                    if (textoArchivo.endsWith("null")) {
                        textoArchivo = textoArchivo.replace("null", "");
                        break;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ManejadorIde.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManejadorIde.class.getName()).log(Level.SEVERE, null, ex);
            }

            AnalizadorLexico al = new AnalizadorLexico(new BufferedReader(new StringReader(textoArchivo)));
            AnalizadorSintactico as = new AnalizadorSintactico(al);
            try {
                as.parse();
                
                pr.recibirRaiz(as.resultado);

            } catch (Exception ex) {
                Logger.getLogger(ManejadorIde.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(ManejadorIde.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
