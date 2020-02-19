/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.manejadorArchivo;

import emuladorsql.ui.PantallaPrincipal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private final static String ARCHIVO2 = "<ARCHIVO nombre=\"%s\"";
    private final static String PROYECTOA = "<PROYECTO nombre=\"%s\">";
    private final static String CARPETAC = "</CARPETA>";

    public void agregarCarpeta(String path, TreeNode treeNode, File ide, boolean ruta) {

        File newCarpet = new File(path);
        newCarpet.mkdir();
        newCarpet.mkdirs();

        agregarCarpetaIde(path, treeNode, ide, ruta);
    }

    public void agregarArchivo(String path, TreeNode treeNode, File ide, String ubi, boolean ruta) {

        File newArchivo = new File(path);
        try {
            newArchivo.createNewFile();
            FileWriter fw = new FileWriter(newArchivo);
            fw.write(ubi);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
        }

        agregarArchivoIde(path, treeNode, ide, ubi, ruta);
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
            if (aux2 == null) {
                break;
            }
            aux += aux2 + "\n";

            if (ruta) {
                if (aux2.startsWith(PROYECTOA.replace("%s", treeNode.toString()))) {
                    aux += CARPETA.replace("%s", p2[p2.length - 1]) + "\n";
                    aux += CARPETAC + "\n";
                }
            } else {
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

    public void agregarArchivoIde(String path, TreeNode treeNode, File ide, String ubi, boolean ruta) {
        String[] p = ide.getPath().split("/");
        String[] p2 = path.split("/");
        String aux = "";
        BufferedReader br = null;
        File fileIde = new File(ide.getPath() + "/" + p[p.length - 1] + ".ide");
        try {
            br = new BufferedReader(new FileReader(fileIde));
        } catch (FileNotFoundException ex) {

        }
        String aux2 = "";
        while (true) {
            try {
                aux2 = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (aux2 == null) {
                break;
            }
            aux += aux2 + "\n";

            if (ruta) {
                if (aux2.startsWith(PROYECTOA.replace("%s", treeNode.toString()))) {
                    aux += ARCHIVO.replace("%s", p2[p2.length - 1]).replace("%n", ubi) + "\n";

                }
            } else {
                if (aux2.startsWith(CARPETA.replace("%s", treeNode.toString()))) {
                    aux += ARCHIVO.replace("%s", p2[p2.length - 1]).replace("%n", ubi) + "\n";
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

    public boolean verificarExistente(String path) {
        File file = new File(path);
        return file.exists();
    }

    public void borrarCarpeta(File file, TreeNode[] treeNodes, PantallaPrincipal pp) {
        String sPath = file.getPath();
        for (int i = 1; i < treeNodes.length; i++) {
            sPath += "/" + treeNodes[i];

        }
        File fileCarpeta = new File(sPath);
        if (fileCarpeta.exists()) {
            if (fileCarpeta.isDirectory()) {
                borrarDirectorio(fileCarpeta);
            }else{
                fileCarpeta.delete();
            }
            
        }

        String[] p = file.getPath().split("/");
        File fileIde = new File(file.getPath() + "/" + p[p.length - 1] + ".ide");
        String aux = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileIde));

            String aux2 = "";
            boolean borrar = false;
            int carpetetasInternas = 0;
            while (true) {
                try {
                    aux2 = br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (aux2 == null) {
                    break;
                }
                if (treeNodes[treeNodes.length - 1].isLeaf()) {

                    if (!aux2.startsWith(ARCHIVO2.replace("%s", treeNodes[treeNodes.length - 1].toString()))) {
                        aux += aux2 + "\n";

                    }

                } else {

                    if (aux2.startsWith(CARPETA.replace("%s", treeNodes[treeNodes.length - 1].toString()))) {
                        borrar = true;

                    } else {
                        if (aux2.startsWith(CARPETA.substring(0, 6))) {
                            carpetetasInternas++;

                        }
                    }

                    if (!borrar) {
                        aux += aux2 + "\n";
                    }
                    if (aux2.startsWith(CARPETAC)) {
                        if (carpetetasInternas == 0) {
                            borrar = false;
                        } else {
                            carpetetasInternas--;
                        }
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

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditadorIde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void borrarDirectorio(File directorio) {
        File[] files = directorio.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                borrarDirectorio(files[i]);
            } else {
                files[i].delete();
            }
        }
    }
}
