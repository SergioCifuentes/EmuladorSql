/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ManejadorSQL;

import emuladorsql.manejadorArchivo.ManejadorCsv;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Select extends Consulta{
    private ArrayList<String> columnas;
    ArrayList<Filtracion> filtraciones;

    public Select(ArrayList<String> columnas, ArrayList<Filtracion> filtraciones, String consulta, String path) {
        super(consulta, path);
        this.columnas = columnas;
        this.filtraciones = filtraciones;
    }
    
    public String select(File file){
        String respuesta=null;
        ManejadorErrores me = new ManejadorErrores();
        String pathArchivo=me.conseguirPathArchivo(path, file);
        if (me.verificarPath(pathArchivo)) {
            ManejadorCsv mc = new ManejadorCsv();
            ArrayList<String[]> tabla = mc.conseguirTabla(mc.conseguirPathCsv(pathArchivo));
            me.verificarColumnas(tabla, columnas);
            String errorColumnas=me.verificarColumnas(tabla, columnas);
            if (errorColumnas==null) {
                
            }else{
                return errorColumnas;
            }
        }else{
            return "Error Path Incorrecto";
        }

        return respuesta;
    }
}
