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
public class Actualizar extends Consulta{
    
    private ArrayList<String> asignaciones;
    private ArrayList<Filtracion> filtraciones;
    private ArrayList<String> columnas= new ArrayList<>();
    private ArrayList<String> valores= new ArrayList<>();

    public Actualizar( ArrayList<String> valores, ArrayList<Filtracion> filtracion, String consulta, String path) {
        super(consulta, path);
        this.asignaciones = valores;
        this.filtraciones = filtracion;
    }
    
    public void actualizar(File file, PantallaPrincipal pp){
        convertirAsignaciones();
        ManejadorErrores me = new ManejadorErrores();
        String pathArchivo = me.conseguirPathArchivo(path, file);
        ManejadorCsv mc = new ManejadorCsv();
        String pathCsv=mc.conseguirPathCsv(pathArchivo);
        if (me.verificarPath(pathArchivo)) {
            
            ArrayList<String[]> tabla = mc.conseguirTabla(pathCsv);
            String errorColumnas = null;
            errorColumnas = me.verificarColumnas(tabla, columnas);
            if (errorColumnas != null) {
                pp.escribirLinea(errorColumnas);

            } else {
                String auxColumnas = null;
                if (filtraciones != null) {
                    ArrayList<String> a=null;
                    for (int i = 0; i < filtraciones.size(); i++) {

                         a= new ArrayList<>();
                        a.add(filtraciones.get(i).getColumna());
                        
                    }
                    auxColumnas = me.verificarColumnas(tabla, a);
                        if (auxColumnas != null) {
                            pp.escribirLinea(auxColumnas);
                        }
                }
                if (auxColumnas == null) {
                    seguirActualizacion(tabla, pp,pathCsv);
                }
            }
            
        }else{
             pp.escribirLinea("Error Path Incorrecto");
        }
    }
    
    public void seguirActualizacion(ArrayList<String[]> tabla,PantallaPrincipal pp,String pathCsv){
        ArrayList<String[]> aux = tabla;
        ManejadorCsv mc = new ManejadorCsv();
        ManejadorDeFiltraciones mdf = new ManejadorDeFiltraciones();
        if (filtraciones != null) {

            aux = mdf.aplicarFiltraciones(aux, filtraciones);
        }
        mc.actualizarTabla(columnas, valores, pathCsv, aux);
            pp.escribirLinea((aux.size()-1)+" Elemento(s) modificado(s)");
        pp.actaulizarTabs();
        
    }
    
    public void convertirAsignaciones(){
        
        for (int i = 0; i < asignaciones.size(); i+=2) {
            
            columnas.add(asignaciones.get(i));
            valores.add(asignaciones.get(i+1));
        }
    }
}
