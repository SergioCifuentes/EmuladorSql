/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.manejadorArchivo;

import emuladorsql.cup.Componente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergio
 */
public class ManejadorCsv {

    public boolean agregarArchivo(Componente com, JTabbedPane tabbedPaneUI) {
        File file = new File(com.getUbicacion());
        JTable tabla = new JTable();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
           
        if (file.exists()) {
            
            String textoArchivo = "";
            BufferedReader br = null;
            String columnas="";
            try {
                br = new BufferedReader(new FileReader(file));
                columnas = br.readLine();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] s = columnas.split(",");
            model.setColumnCount(s.length);
            model.setColumnIdentifiers(s);
               
            
            
            while (true) {
                try {
                    textoArchivo="";
                    textoArchivo += br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (textoArchivo.endsWith("null")) {
                    textoArchivo = textoArchivo.replace("null", "");
                    break;
                }else{
                    String[] fila=textoArchivo.split(",");
                        model.addRow(fila);
                        
                    
                
                }
            }
            
            
            JScrollPane jsp = new JScrollPane(tabla);
            tabbedPaneUI.addTab(com.getNombre(),jsp);
            
            return true;
        } else {
            return false;
        }
    }
public ArrayList<String[]> conseguirTabla(String path){
    File file = new File(path);
    ArrayList<String[]> tabla= new ArrayList<>();
    BufferedReader br=null ;
        try {
             br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        String textoArchivo="";
        while (true) {
                try {
                    textoArchivo="";
                    textoArchivo += br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (textoArchivo.endsWith("null")) {
                    textoArchivo = textoArchivo.replace("null", "");
                    break;
                }else{
                    tabla.add(textoArchivo.split(","));                    
                    
                
                }
            }
        System.out.println("tabla "+tabla);
        return tabla;
}
public String conseguirPathCsv(String pathArchivo){
    File file = new File(pathArchivo);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
}
}
