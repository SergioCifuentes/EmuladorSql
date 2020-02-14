/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.cup;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Componente {
    private String nombre;
    private ArrayList<Componente> componetes;
    private String ubicacion;

    public Componente(String tipo, ArrayList<Componente> componetes) {
        this.nombre = tipo;
        this.componetes = componetes;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString(){
        return nombre;
    }
    public ArrayList<Componente>  getComponetes() {
        return componetes;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
