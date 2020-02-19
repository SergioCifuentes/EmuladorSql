/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.jflex.Secundario;

import emuladorsql.cup.Secundario.AnalizadorSintacticoPuntoyComa;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class verificarPyC {
    public boolean verificarPuntoyComa(String text){
        AnalizadorLexicoPuntoyComa alpc = new AnalizadorLexicoPuntoyComa(new BufferedReader(new StringReader(text)));
        AnalizadorSintacticoPuntoyComa aspc = new AnalizadorSintacticoPuntoyComa(alpc);
        try {
            aspc.parse();
        } catch (Exception ex) {
            Logger.getLogger(verificarPyC.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return aspc.correcto;
    }
}
