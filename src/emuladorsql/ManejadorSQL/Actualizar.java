/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ManejadorSQL;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Actualizar extends Consulta{
    
    private ArrayList<String> asignaciones;
    private ArrayList<Filtracion> filtracion;

    public Actualizar( ArrayList<String> valores, ArrayList<Filtracion> filtracion, String consulta, String path) {
        super(consulta, path);
        this.asignaciones = valores;
        this.filtracion = filtracion;
    }
    
    
}
