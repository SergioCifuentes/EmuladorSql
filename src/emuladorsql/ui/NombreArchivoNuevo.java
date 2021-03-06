/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorsql.ui;

import emuladorsql.manejadorArchivo.EditadorIde;
import java.io.File;
import javax.swing.tree.TreeNode;

/**
 *
 * @author sergio
 */
public class NombreArchivoNuevo extends javax.swing.JDialog {

    private static final String TITULO_NEW_CARPET = "Ingrese el Nombre De su Nueva Carpeta";
    private static final String TITULO_NEW_ARCHIVO = "Ingrese el Nombre De su Nueva Archivo";
    private static final String ERROR_CARPET_EXISTENTE = "Carpeta Ya Existente";
    private static final String ERROR_ARCHIVO_EXISTENTE = "Archivo Ya Existente";
    public static final int TIPO_CARPETA = 1;
    public static final int TIPO_ARCHIVO = 2;
    private boolean ingresado = false;
    private  String path;
    private final TreeNode treeNode;
    private int tipo;
    private final File idFile;
    private boolean ruta;
    private String nombre;
   

    /**
     * Creates new form NombreArchivoNuevo
     *
     * @param parent
     * @param modal
     * @param tipo
     * @param path
     * @param treeNode
     * @param idFile
     */
    public NombreArchivoNuevo(java.awt.Frame parent, boolean modal, int tipo, String path, TreeNode treeNode, File idFile,boolean ruta) {
        super(parent, modal);
        initComponents();
        lblError.setVisible(false);
        this.tipo = tipo;
        if (tipo == TIPO_CARPETA) {
            lblTitulo.setText(TITULO_NEW_CARPET);
            lblError.setText(ERROR_CARPET_EXISTENTE);
        } else {
            lblTitulo.setText(TITULO_NEW_ARCHIVO);
            lblError.setText(ERROR_ARCHIVO_EXISTENTE);
        }
        this.path = path;
        this.treeNode = treeNode;
        this.idFile = idFile;
        this.ruta=ruta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("jLabel1");

        txtNombre.setText(" ");

        lblError.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("jLabel1");

        btnSiguiente.setText("=>");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(lblError)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        EditadorIde ei = new EditadorIde();
        if (tipo == TIPO_CARPETA) {
            
            if (ei.verificarExistente(path + "/" + txtNombre.getText())) {
                lblError.setVisible(true);
            } else {
                ei.agregarCarpeta(path + "/" + txtNombre.getText(), treeNode, idFile,ruta);
                ingresado = true;
                this.setVisible(false);
            }
        }else{
            if (ei.verificarExistente(path + "/" + txtNombre.getText())) {
                lblError.setVisible(true);
            } else {
                nombre=txtNombre.getText();
                path=path + "/" + txtNombre.getText();
                ingresado = true;
                this.setVisible(false);
            }
        }

    }//GEN-LAST:event_btnSiguienteActionPerformed

    public String getPath() {
        return path;
    }
public String getNombre(){
           return nombre;
}
    /**
     * @param args the command line arguments
     */
    public boolean isIngresado() {
        return ingresado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
