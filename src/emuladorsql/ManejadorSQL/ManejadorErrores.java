/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ManejadorSQL;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class ManejadorErrores {

    public boolean verificarPath(String path) {
        boolean verificado = false;
        
        File filePath = new File(path);
        if (filePath.exists()) {
            if (filePath.isFile()) {
                return true;
            }
        }
        return verificado;
    }
    
    public String conseguirPathArchivo(String path,File file){
        String auxPath = path.replace(".", "%s");
        String[] paths = auxPath.split("%s");
        auxPath = "";
        for (int i = 1; i < paths.length; i++) {
            auxPath += "/" + paths[i];
        }
        return (file.getPath()+auxPath);
    }
    
    public String verificarColumnas(ArrayList<String[]> tabla,ArrayList<String> columnas){
        String error=null;
        
        for (int i = 0; i < columnas.size(); i++) {
            boolean aux = false;
            for (int j = 0; j < tabla.get(0).length; j++) {
                if (columnas.get(i).equals(tabla.get(0)[j])) {
                    aux=true;
                }
                
            }
            if (aux==false) {
                error="Columna: "+columnas.get(i)+" no existe";
                break;
            }
        }
        return error;
        
    }
}
