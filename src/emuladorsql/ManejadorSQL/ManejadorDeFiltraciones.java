/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ManejadorSQL;

import emuladorsql.jflex.Secundario.ManejadorCsv;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class ManejadorDeFiltraciones {

    public ArrayList<String[]> aplicarFiltraciones(ArrayList<String[]> tabla, ArrayList<Filtracion> filtracions) {
        if (filtracions.size() > 1) {
            String op = null;
            for (int i = 0; i < filtracions.size(); i++) {
                if (filtracions.get(i).getOpLog() != null) {
                    op = filtracions.get(i).getOpLog();
                    break;
                }
            }
            switch (op) {
                case "AND":

                    for (int i = 0; i < filtracions.size(); i++) {
                        tabla = filtrar(tabla, filtracions.get(i));
                    }

                    return tabla;
                case "OR":
                    ArrayList<String[]> tablaAux = new ArrayList<>();
                    tablaAux.add(tabla.get(0));
                    for (int i = 0; i < filtracions.size(); i++) {
                        ArrayList<String[]> aux = filtrar(tabla, filtracions.get(i));
                        for (int j = 1; j < aux.size(); j++) {
                            boolean aparece = false;
                            for (int k = 1; k < tablaAux.size(); k++) {
                                if (ManejadorCsv.compareString(tablaAux.get(k), aux.get(j))) {
                                    aparece = true;
                                }
                            }
                            if (!aparece) {
                                tablaAux.add(aux.get(j));
                            }
                        }
                    }
                    return tablaAux;
            }
        } else {
            return filtrar(tabla, filtracions.get(0));
        }
        return tabla;
    }

    public ArrayList<String[]> filtrar(ArrayList<String[]> tabla, Filtracion fil) {
        ArrayList<String[]> resultado = new ArrayList<>();
        resultado.add(tabla.get(0));
        for (int i = 0; i < tabla.get(0).length; i++) {
            if (fil.getColumna().equals(tabla.get(0)[i])) {

                for (int j = 1; j < tabla.size(); j++) {
                    try {
                        int num1 = Integer.valueOf(tabla.get(j)[i]);
                        int num2 = Integer.valueOf(fil.getValor());
                        
                        switch (fil.getTipoOperacion()) {
                        case 1:
                            if (num1>num2) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 2:
                            if (num1<num2) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 3:
                            if (num1>=num2) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 4:
                            if (num1<=num2) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 5:
                            if (num1!=num2) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 6:
                            if (num1==num2) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                    }
                        
                        
                        
                    } catch (NumberFormatException e) {
                        
                        String val1=tabla.get(j)[i];
                        String val2= fil.getValor();
                        
                        switch (fil.getTipoOperacion()) {
                        case 1:
                            if (val1.length()>val2.length()) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 2:
                            if (val1.length()<val2.length()) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 3:
                            if (val1.length()>=val2.length()) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 4:
                            if (val1.length()<=val2.length()) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 5:
                            if (!val1.equals(val2)) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                        case 6:
                            if (val1.equals(val2)) {
                                resultado.add(tabla.get(j));
                            }
                            break;
                    }
                        
                    }
                    
                    
                    
                }

                break;
            }
        }

        return resultado;
    }

    public ArrayList<String[]> obtenerColumnas(ArrayList<String[]> tabla, ArrayList<String> columnas) {
        String[][] tablaAux = null;
        tablaAux = new String[tabla.size()][columnas.size()];
        for (int i = 0; i < columnas.size(); i++) {
            for (int j = 0; j < tabla.get(0).length; j++) {
                if (columnas.get(i).equals(tabla.get(0)[j])) {
                    for (int k = 0; k < tabla.size(); k++) {
                        tablaAux[k][i] = tabla.get(k)[j];
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
