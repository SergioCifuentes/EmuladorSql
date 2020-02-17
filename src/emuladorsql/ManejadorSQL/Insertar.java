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
public class Insertar extends Consulta{
    private ArrayList<String> columnas;
    private ArrayList<String> valores;

    public Insertar(ArrayList<String> columnas, ArrayList<String> valores, String consulta, String path) {
        super(consulta, path);
        this.columnas = columnas;
        this.valores = valores;
    }
    
}
