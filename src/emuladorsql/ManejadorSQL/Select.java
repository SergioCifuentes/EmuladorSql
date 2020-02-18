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
public class Select extends Consulta {

    private ArrayList<String> columnas;
    ArrayList<Filtracion> filtraciones;

    public Select(ArrayList<String> columnas, ArrayList<Filtracion> filtraciones, String consulta, String path) {
        super(consulta, path);
        this.columnas = columnas;
        this.filtraciones = filtraciones;
    }

    public void select(File file, PantallaPrincipal pp) {
        ManejadorErrores me = new ManejadorErrores();
        String pathArchivo = me.conseguirPathArchivo(path, file);
        if (me.verificarPath(pathArchivo)) {
            ManejadorCsv mc = new ManejadorCsv();
            ArrayList<String[]> tabla = mc.conseguirTabla(mc.conseguirPathCsv(pathArchivo));
            String errorColumnas = null;
            if (columnas != null) {
                me.verificarColumnas(tabla, columnas);
                errorColumnas = me.verificarColumnas(tabla, columnas);

            }
            if (errorColumnas != null) {
                pp.escribirLinea(errorColumnas);

            } else {
                String auxColumnas = null;
                if (filtraciones != null) {
                    for (int i = 0; i < filtraciones.size(); i++) {

                        ArrayList<String> a = new ArrayList<>();
                        a.add(filtraciones.get(i).getColumna());
                        auxColumnas = me.verificarColumnas(tabla, a);
                        if (auxColumnas != null) {
                            pp.escribirLinea(auxColumnas);
                        }
                    }
                }
                if (auxColumnas == null) {

                    buscar(tabla, pp);
                }
            }

        } else {
            pp.escribirLinea("Error Path Incorrecto");

        }

    }

    public void buscar(ArrayList<String[]> tabla, PantallaPrincipal pp) {
        ArrayList<String[]> aux = tabla;
        ManejadorDeFiltraciones mdf = new ManejadorDeFiltraciones();
        if (filtraciones != null) {

            aux = mdf.aplicarFiltraciones(aux, filtraciones);
        }
        if (columnas != null) {
            aux = mdf.obtenerColumnas(aux, columnas);
        }
        for (int i = 0; i < aux.size(); i++) {
            String row = "";
            for (int j = 0; j < aux.get(i).length; j++) {
                row += "|" + aux.get(i)[j] + "|";
            }
            pp.escribirLinea(row);
        }
        pp.escribirLinea((aux.size() - 1) + "elemento(s) encontrado(s)");

    }
}
