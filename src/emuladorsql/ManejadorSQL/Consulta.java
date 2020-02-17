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
public class Consulta {
    protected  String consulta;
    protected  String path;

    public Consulta(String consulta, String path) {
        this.consulta = consulta;
        this.path = path;
    }

    public String getConsulta() {
        return consulta;
    }

    public String getPath() {
        return path;
    }
    
}
