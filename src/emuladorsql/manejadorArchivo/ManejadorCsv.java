/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.manejadorArchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author sergio
 */
public class ManejadorCsv {

    public boolean agregarArchivo(String path, JTabbedPane tabbedPaneUI) {
        File file = new File(path);
        if (file.exists()) {
            String textoArchivo = "";
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
            JTextArea jtxt = new JTextArea();
            tabbedPaneUI.add(jtxt);
            while (true) {
                try {
                    textoArchivo="";
                    textoArchivo += br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(ManejadorCsv.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (textoArchivo.endsWith("null")) {
                    textoArchivo = textoArchivo.replace("null", "");
                    break;
                }else{
                jtxt.append(textoArchivo+"\n");
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
