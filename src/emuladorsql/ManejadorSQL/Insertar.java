/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ManejadorSQL;

import emuladorsql.manejadorArchivo.ManejadorCsv;
import emuladorsql.ui.PantallaPrincipal;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Insertar extends Consulta {

    private ArrayList<String> columnas;
    private ArrayList<String> valores;

    public Insertar(ArrayList<String> columnas, ArrayList<String> valores, String consulta, String path) {
        super(consulta, path);
        this.columnas = columnas;
        this.valores = valores;
    }

    public void insertar(File file, PantallaPrincipal pp) {
        ManejadorErrores me = new ManejadorErrores();
        String pathArchivo = me.conseguirPathArchivo(path, file);
        if (me.verificarPath(pathArchivo)) {
            ManejadorCsv mc = new ManejadorCsv();
            ArrayList<String[]> tabla = mc.conseguirTabla(mc.conseguirPathCsv(pathArchivo));
            boolean errorColumna = false;
            String errorColumnas = null;
            if (columnas != null) {
                me.verificarColumnas(tabla, columnas);
                errorColumnas = me.verificarColumnas(tabla, columnas);
                if (errorColumnas != null) {
                    errorColumna = true;
                    pp.escribirLinea(errorColumnas);
                }
                System.out.println("columnas " + columnas.size());
                errorColumnas = me.verificarLongitud(tabla, columnas);
                if (errorColumnas != null) {
                    errorColumna = true;
                    pp.escribirLinea(errorColumnas);
                }
            }
            if (errorColumna == false) {
                System.out.println("valores " + valores.size());
                String errorValores = me.verificarLongitud(tabla, valores);
                if (errorValores != null) {
                    pp.escribirLinea(errorValores);
                } else {

                    insert(tabla, pp, pathArchivo);

                }
            }
        } else {
            pp.escribirLinea("Error Path Incorrecto");

        }

    }

    public void insert(ArrayList<String[]> tabla, PantallaPrincipal pp, String pathArchivo) {
        ManejadorCsv mc = new ManejadorCsv();
        String[] fila = new String[valores.size()];
        if (columnas != null) {
            for (int i = 0; i < tabla.get(0).length; i++) {
                for (int j = 0; j < columnas.size(); j++) {
                    if (tabla.get(0)[i].equals(columnas.get(j))) {
                        fila[i] = valores.get(j);
                    }
                }
            }
        } else {
            for (int i = 0; i < valores.size(); i++) {
                fila[i] = valores.get(i);
            }

        }
        mc.insertarFila(fila, pathArchivo);
        pp.escribirLinea("1 Elemento Insertado");
        pp.actaulizarTabs();
    }

}
