/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.jflex.Secundario;

import emuladorsql.cup.Componente;
import emuladorsql.cup.Secundario.AnalizadorSintacticoCSV;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
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

        ArrayList<String[]> filas = conseguirTabla(com.getUbicacion());
        JTable tabla = new JTable();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setColumnIdentifiers(filas.get(0));
        for (int i = 1; i < filas.size(); i++) {
            model.addRow(filas.get(i));
        }

        JScrollPane jsp = new JScrollPane(tabla);
        tabbedPaneUI.addTab(com.getNombre(), jsp);
        return true;
//        File file = new File(com.getUbicacion());
//        JTable tabla = new JTable();
//        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
//
//        if (file.exists()) {
//
//            String textoArchivo = "";
//            BufferedReader br = null;
//            String columnas = "";
//            try {
//                br = new BufferedReader(new FileReader(file));
//                columnas = br.readLine();
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            String[] s = columnas.split(",");
//            model.setColumnCount(s.length);
//            model.setColumnIdentifiers(s);
//
//            while (true) {
//                try {
//                    textoArchivo = "";
//                    textoArchivo += br.readLine();
//                } catch (IOException ex) {
//                    Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                if (textoArchivo.endsWith("null")) {
//                    textoArchivo = textoArchivo.replace("null", "");
//                    break;
//                } else {
//                    String[] fila = textoArchivo.split(",");
//                    model.addRow(fila);
//
//                }
//            }
//
//            JScrollPane jsp = new JScrollPane(tabla);
//            
//            tabbedPaneUI.addTab(com.getNombre(), jsp);
//
//            return true;
//        } else {
//            return false;
//        }
    }

    public ArrayList<String[]> conseguirTabla(String path) {
        File file = new File(path);
        BufferedReader br = null;
        if (file.exists()) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String s = "";
        while (true) {
            String aux = null;
            try {
                aux = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (aux == null) {
                s=s.substring(0,s.length()-1);
                break;
            } else {
                s += aux + "\n";
            }
        }
        if (s.endsWith("\n")) {
            s = s.substring(0, s.length() - 1);
        }
        AnalizadorLexicoCSV alcsv = new AnalizadorLexicoCSV(new BufferedReader(new StringReader(s)));
        AnalizadorSintacticoCSV ascsv = new AnalizadorSintacticoCSV(alcsv);
        try {
            ascsv.parse();
        } catch (Exception ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String[]> filas = ascsv.filas;
        return filas;
    }

    public String conseguirPathCsv(String pathArchivo) {
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

    public void insertarFila(String[] fila, String path) {
        File file = new File(conseguirPathCsv(path));
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);

            String filaAux = "";
            for (int i = 0; i < fila.length; i++) {
                if (i == 0) {
                    filaAux += fila[i];
                } else {
                    filaAux += "," + fila[i];
                }
            }
            bw.write("\n" + filaAux);

        } catch (IOException ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void actualizarTabla(ArrayList<String> columna, ArrayList<String> valores, String pathCsv, ArrayList<String[]> tablaVieja) {
        File file1 = new File(pathCsv);
        ArrayList<String[]> tablaOriginal = conseguirTabla(pathCsv);

        for (int i = 1; i < tablaOriginal.size(); i++) {
            for (int j = 1; j < tablaVieja.size(); j++) {
                if (compareString(tablaOriginal.get(i), tablaVieja.get(j))) {

                    for (int k = 0; k < tablaOriginal.get(i).length; k++) {
                        for (int l = 0; l < columna.size(); l++) {

                            if (tablaOriginal.get(0)[k].equals(columna.get(l))) {
                                tablaOriginal.get(i)[k] = valores.get(l);
                            }
                        }
                    }
                }
            }

        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file1);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        String fila = "";
        for (int i = 0; i < tablaOriginal.size(); i++) {
            for (int j = 0; j < tablaOriginal.get(i).length; j++) {
                if (j == 0) {
                    fila += tablaOriginal.get(i)[j];
                } else {
                    fila += "," + tablaOriginal.get(i)[j];
                }

            }
            fila += "\n";

        }
        try {
            fw.write(fila);
            fila = "";
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarFila(ArrayList<String[]> filas, String pathCsv) {
        File file1 = new File(pathCsv);
        ArrayList<String[]> tablaOriginal = conseguirTabla(pathCsv);
        ArrayList<String[]> aux = new ArrayList<>();
        aux.add(tablaOriginal.get(0));

        for (int j = 1; j < tablaOriginal.size(); j++) {
            boolean aparece = false;
            for (int i = 0; i < filas.size(); i++) {
                if (compareString(filas.get(i), tablaOriginal.get(j))) {
                    aparece = true;
                }
            }
            if (aparece) {
                aux.add(tablaOriginal.get(j));
            }

        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(file1);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        String fila = "";
        for (int i = 0; i < aux.size(); i++) {
            for (int j = 0; j < aux.get(i).length; j++) {
                if (j == 0) {
                    fila += aux.get(i)[j];
                } else {
                    fila += "," + aux.get(i)[j];
                }

            }
            fila += "\n";

        }
        try {
            fw.write(fila);
            fila = "";
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean compareString(String[] s1, String[] s2) {
        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals(s2[i])) {
                return false;
            }
        }
        return true;
    }
}
