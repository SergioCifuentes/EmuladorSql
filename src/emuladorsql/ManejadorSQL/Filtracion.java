/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ManejadorSQL;

/**
 *
 * @author sergio
 */
public class Filtracion {
    private String columna;
    private String valor;
    private int tipoOperacion;
    private String opLog;
    public Filtracion(String columna, String valor, int tipoOperacion,String opLog) {
        this.columna = columna;
        this.valor = valor;
        this.tipoOperacion = tipoOperacion;
        this.opLog=opLog;
    }

    public String getColumna() {
        return columna;
    }

    public String getValor() {
        return valor;
    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public String getOpLog() {
        return opLog;
    }
    
   public static int operadorAtipo(String op){
       switch (op) {
           case ">":
               return 1;
               
           case "<":
               return 2;
               
           case ">=":
               return 3;
               
           case "<=":
               return 4;
               
           case "<>":
               return 5;
               
           case "==":
               return 5;
               default:
                   return 0;
       }
   }
}
