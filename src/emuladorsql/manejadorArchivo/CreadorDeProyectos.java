/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.manejadorArchivo;

import java.io.File;

/**
 *
 * @author sergio
 */
public class CreadorDeProyectos {
    public  void crearProyecto(String path,String nombre){
        File file = new File(path+"/"+nombre);
        file.mkdir();
        file.mkdirs();
        ManejadorIde manejadorIde = new ManejadorIde();
        manejadorIde.crearArchivoIde(file.getPath(), nombre);
    }
}
