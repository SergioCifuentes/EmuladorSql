/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ManejadorSQL;

import emuladorsql.jflex.Secundario.ManejadorCsv;
import emuladorsql.ui.PantallaPrincipal;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Eliminar extends Consulta {

    private ArrayList<Filtracion> filtraciones;

    public Eliminar(ArrayList<Filtracion> filtraciones, String consulta, String path) {
        super(consulta, path);
        this.filtraciones = filtraciones;
    }

    public void eliminar(File file, PantallaPrincipal pp) {
        ManejadorErrores me = new ManejadorErrores();
        String pathArchivo = me.conseguirPathArchivo(path, file);
        ManejadorCsv mc = new ManejadorCsv();
        String pathCsv = mc.conseguirPathCsv(pathArchivo);
        if (me.verificarPath(pathArchivo)) {
            
            ArrayList<String[]> tabla = mc.conseguirTabla(pathCsv);

            String auxColumnas = null;
            if (filtraciones != null) {
                ArrayList<String> a = new ArrayList<>();
                for (int i = 0; i < filtraciones.size(); i++) {
                    
                    a.add(filtraciones.get(i).getColumna());
                }
                auxColumnas = me.verificarColumnas(tabla, a);
                if (auxColumnas != null) {
                    pp.escribirLinea(auxColumnas);
                }
            }
            if (auxColumnas == null) {

                seguireliminando(tabla, pp,pathCsv);
            }

        } else {
            pp.escribirLinea("Error Path Incorrecto");

        }
    }

    private void seguireliminando(ArrayList<String[]> tabla, PantallaPrincipal pp,String pathArchivo) {
            ArrayList<String[]> aux = tabla;
        ManejadorDeFiltraciones mdf = new ManejadorDeFiltraciones();
        ManejadorCsv mc = new ManejadorCsv();
        if (filtraciones != null) {

            aux = mdf.aplicarFiltraciones(aux, filtraciones);
        }
        mc.eliminarFila(aux, pathArchivo);
        pp.escribirLinea((aux.size()-1) +"Elemento Insertado");
        pp.actaulizarTabs();
    }

}
