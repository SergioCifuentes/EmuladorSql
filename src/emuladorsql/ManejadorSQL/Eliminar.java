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
public class Eliminar extends Consulta{
    private ArrayList<Filtracion> filtraciones;

    public Eliminar(ArrayList<Filtracion> filtraciones, String consulta, String path) {
        super(consulta, path);
        this.filtraciones = filtraciones;
    }
    
    
}
