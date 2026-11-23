// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package interfaz;

import dominio.*;
import java.awt.Color;
import javax.swing.JOptionPane;

public class VentanaAltaEmpresas extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAltaEmpresas.class.getName());

    public VentanaAltaEmpresas(Sistema sistema) {
        initComponents();
        modelo = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fldNombre = new javax.swing.JTextField();
        fldRut = new javax.swing.JTextField();
        fldDireccion = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        lblRut = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        fldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fldNombreKeyTyped(evt);
            }
        });
        getContentPane().add(fldNombre);
        fldNombre.setBounds(30, 100, 190, 22);

        fldRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fldRutKeyTyped(evt);
            }
        });
        getContentPane().add(fldRut);
        fldRut.setBounds(300, 100, 190, 22);

        fldDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fldDireccionKeyTyped(evt);
            }
        });
        getContentPane().add(fldDireccion);
        fldDireccion.setBounds(160, 200, 170, 22);

        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(this::btnCrearActionPerformed);
        getContentPane().add(btnCrear);
        btnCrear.setBounds(190, 280, 120, 50);

        lblRut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRut.setText("RUT");
        getContentPane().add(lblRut);
        lblRut.setBounds(300, 70, 190, 30);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(30, 70, 100, 30);

        lblDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDireccion.setText("Dirección");
        getContentPane().add(lblDireccion);
        lblDireccion.setBounds(160, 170, 140, 30);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Ingrese los datos de la empresa");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(60, 20, 380, 50);

        setBounds(0, 0, 548, 413);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nombre = fldNombre.getText();
        String rut = fldRut.getText();
        String direccion = fldDireccion.getText();
        boolean ok = true;
        if(nombre.equals("") || nombre.equals("ERROR. No puede ser vacío")){
            fldNombre.setText("ERROR. No puede ser vacío");
            fldNombre.setForeground(Color.red);
            ok = false;
        }
        if (rut.equals("") || rut.equals("ERROR. No puede ser vacío")) {
            fldRut.setText("ERROR. No puede ser vacío");
            fldRut.setForeground(Color.red);
            ok = false;
        } else {
            for (Empresa emp : modelo.getListaEmpresas()) {
                if ((emp.getRut().equals(rut)) || rut.equals("ERROR. Debe ser único")) {
                    fldRut.setText("ERROR. Debe ser único");
                    fldRut.setForeground(Color.red);
                    ok = false;
                }
            }
        }
        if (direccion.equals("") || direccion.equals("ERROR. No puede ser vacío")) {
            fldDireccion.setText("ERROR. No puede ser vacío");
            fldDireccion.setForeground(Color.red);
            ok = false;
        }
        if(ok){
            Empresa emp = new Empresa(nombre, rut, direccion);
            modelo.agregarEmpresa(emp);
            modelo.notificarObs();
            JOptionPane.showMessageDialog(this,"¡¡Empresa registrada con éxito!!","REGISTRO",1);
            fldNombre.setText("");
            fldRut.setText("");
            fldDireccion.setText("");
        }
        else {
            JOptionPane.showMessageDialog(this,"Algún campo no es válido","ERROR",0);
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void fldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fldNombreKeyTyped
        fldNombre.setForeground(Color.black);
    }//GEN-LAST:event_fldNombreKeyTyped

    private void fldRutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fldRutKeyTyped
        fldRut.setForeground(Color.black);
    }//GEN-LAST:event_fldRutKeyTyped

    private void fldDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fldDireccionKeyTyped
        fldDireccion.setForeground(Color.black);
    }//GEN-LAST:event_fldDireccionKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JTextField fldDireccion;
    private javax.swing.JTextField fldNombre;
    private javax.swing.JTextField fldRut;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRut;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
