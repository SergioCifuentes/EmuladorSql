/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ManejadorSQL;

import emuladorsql.cup.AnalizadorSintacticoSql;
import emuladorsql.ui.PantallaPrincipal;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class ManejadorDeEntrada {
    public void leerEntrada(String entrada,PantallaPrincipal pp){
        AnalizadorLexicoSql als = new AnalizadorLexicoSql(new StringReader(entrada));
        AnalizadorSintacticoSql ass = new AnalizadorSintacticoSql(als);
        try {
            ass.parse();
            if (ass.consultas==null) {
               pp.recibirSinPuntoyComa(ass.sinPuntoyComa);
            }else{
                for (int i = 0; i < ass.consultas.size(); i++) {
                    System.out.println(ass.consultas.get(i).getConsulta());
                    System.out.println(ass.consultas.get(i).getPath());
                    if (ass.consultas.get(i).getClass()==Select.class) {
                        Select select = (Select)ass.consultas.get(i);
                        select.select(pp.getFile(),pp);
                        
                        
                    }else if(ass.consultas.get(i).getClass()==Insertar.class){
                        Insertar insertar = (Insertar)ass.consultas.get(i);
                            insertar.insertar(pp.getFile(), pp);
                    }else if(ass.consultas.get(i).getClass()==Actualizar.class){
                        Actualizar actualizar = (Actualizar)ass.consultas.get(i);
                    }else if(ass.consultas.get(i).getClass()==Eliminar.class){
                        Eliminar eliminar = (Eliminar)ass.consultas.get(i);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManejadorDeEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
