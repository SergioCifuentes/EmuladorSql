/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.manejadorArchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.TreeNode;

/**
 *
 * @author sergio
 */
public class EditadorIde {

    private final static String CARPETA = "<CARPETA nombre=\"%s\">";
    private final static String ARCHIVO = "<ARCHIVO nombre=\"%s\" ubicacion=\"%n\"/>";
    private final static String PROYECTOA = "<PROYECTO nombre=\"%s\">";
    private final static String CARPETAC = "</CARPETA>";
   

    public void agregarCarpeta(String path, TreeNode treeNode, File ide, boolean ruta) {

        File newCarpet = new File(path);
        newCarpet.mkdir();
        newCarpet.mkdirs();

        agregarCarpetaIde(path, treeNode, ide,ruta);
    }
        public void agregarArchivo(String path, TreeNode treeNode, File ide,String ubi, boolean ruta) {

        File newArchivo = new File(path);
        try {
            newArchivo.createNewFile();
            FileWriter fw = new FileWriter(newArchivo);
            fw.write(ubi);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
        }

        agregarArchivoIde(path, treeNode, ide,ubi,ruta);
    }

    public void agregarCarpetaIde(String path, TreeNode treeNode, File ide, boolean ruta) {
        String[] p = ide.getPath().split("/");
        String[] p2 = path.split("/");
        String aux = "";
        BufferedReader br = null;
        File fileIde = new File(ide.getPath() + "/" + p[p.length - 1] + ".ide");
        try {
            br = new BufferedReader(new FileReader(fileIde));
        } catch (FileNotFoundException ex) {
            System.out.println("Error2");
        }
        String aux2 = "";
        while (true) {
            try {
                aux2 = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (aux2==null) {
                break;
            }
            aux += aux2+"\n";
            
            if (ruta) {
                if (aux2.startsWith(PROYECTOA.replace("%s", treeNode.toString()))) {
                aux += CARPETA.replace("%s", p2[p2.length - 1]) + "\n";
                aux += CARPETAC + "\n";
            }
            }else{
            if (aux2.startsWith(CARPETA.replace("%s", treeNode.toString()))) {
                aux += CARPETA.replace("%s", p2[p2.length - 1]) + "\n";
                aux += CARPETAC + "\n";
            }
            }
        }
        
        try {
            FileWriter fw = new FileWriter(fileIde);
            fw.write(aux);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        public void agregarArchivoIde(String path, TreeNode treeNode, File ide,String ubi, boolean ruta) {
        String[] p = ide.getPath().split("/");
        String[] p2 = path.split("/");
        String aux = "";
        BufferedReader br = null;
        File fileIde = new File(ide.getPath() + "/" + p[p.length - 1] + ".ide");
        try {
            br = new BufferedReader(new FileReader(fileIde));
        } catch (FileNotFoundException ex) {
            System.out.println("Error2");
        }
        String aux2 = "";
        while (true) {
            try {
                aux2 = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (aux2==null) {
                break;
            }
            aux += aux2+"\n";
            
            if (ruta) {
                if (aux2.startsWith(PROYECTOA.replace("%s", treeNode.toString()))) {
                aux += ARCHIVO.replace("%s", p2[p2.length - 1]).replace("%n", ubi) + "\n";
                
            }
            }else{
            if (aux2.startsWith(CARPETA.replace("%s", treeNode.toString()))) {
                aux += ARCHIVO.replace("%s", p2[p2.length - 1]).replace("%n", ubi) + "\n";
            }
            }
        }
        
        try {
            FileWriter fw = new FileWriter(fileIde);
            System.out.println(aux);
            fw.write(aux);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean verificarExistente(String path) {
        File file = new File(path);
        return file.exists();
    }
}
