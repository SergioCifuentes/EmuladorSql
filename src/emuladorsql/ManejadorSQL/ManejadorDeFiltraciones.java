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
public class ManejadorDeFiltraciones {
        public ArrayList<String[]> aplicarFiltraciones(ArrayList<String[]> tabla,ArrayList<Filtracion> filtracions){
        
    }
    public ArrayList<String[]> filtrar(ArrayList<String[]> tabla,Filtracion fil){
        
    }
    
    public ArrayList<String[]> obtenerColumnas(ArrayList<String[]> tabla,ArrayList<String> columnas){
        String[][] tablaAux=null;
        tablaAux=new String[tabla.size()][columnas.size()];
        for (int i = 0; i < columnas.size(); i++) {
            for (int j = 0; j < tabla.get(0).length; j++) {              
                if (columnas.get(i).equals(tabla.get(0)[j])) {
                    for (int k = 0; k < tabla.size(); k++) {
                      tablaAux[k][i]=tabla.get(k)[j];
                    }
                }
                
            }
        }
        ArrayList<String[]> tablaFiltrada = new ArrayList<>();
        for (int i = 0; i < tablaAux.length; i++) {
            tablaFiltrada.add(tablaAux[i]);
        }
        return tablaFiltrada;
    }
}
