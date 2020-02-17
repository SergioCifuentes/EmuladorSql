/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.manejadorArchivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class CreadorDeArchivosCsv {
    public boolean  crearCsv(ArrayList<String> columnas,String path,String nombre){
        try {
             File fi = new File(path+"/"+nombre+".csv");
        if (!fi.exists()) {
            try {
                fi.createNewFile();
                
            FileWriter fw = new FileWriter(fi);
            String texto="";
                for (int i = 0; i < columnas.size(); i++) {
                    if (i==0) {
                       texto+=columnas.get(i); 
                    }else{
                        texto+=","+columnas.get(i);
                    }
                    
                }
                System.out.println(texto);
                fw.write(texto);
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CreadorDeArchivosCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return true;
        } catch (Exception e) {
            return false;
        }
       
    }
}
