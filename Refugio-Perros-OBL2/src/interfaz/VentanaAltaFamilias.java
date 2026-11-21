// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package interfaz;

import dominio.*;
import java.awt.Color;

public class VentanaAltaFamilias extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAltaFamilias.class.getName());

    public VentanaAltaFamilias(Sistema sistema) {
        initComponents();
        modelo = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fldCedula = new javax.swing.JTextField();
        fldApellido = new javax.swing.JTextField();
        fldCelular = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        fldCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fldCedulaKeyTyped(evt);
            }
        });
        getContentPane().add(fldCedula);
        fldCedula.setBounds(30, 100, 170, 22);

        fldApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fldApellidoKeyTyped(evt);
            }
        });
        getContentPane().add(fldApellido);
        fldApellido.setBounds(300, 100, 210, 22);

        fldCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fldCelularKeyTyped(evt);
            }
        });
        getContentPane().add(fldCelular);
        fldCelular.setBounds(160, 200, 170, 22);

        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(this::btnCrearActionPerformed);
        getContentPane().add(btnCrear);
        btnCrear.setBounds(190, 280, 120, 50);

        lblCedula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCedula.setText("Cédula del titular");
        getContentPane().add(lblCedula);
        lblCedula.setBounds(30, 70, 190, 30);

        lblApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblApellido.setText("Apellido");
        getContentPane().add(lblApellido);
        lblApellido.setBounds(300, 70, 100, 30);

        lblCelular.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCelular.setText("Celular");
        getContentPane().add(lblCelular);
        lblCelular.setBounds(160, 170, 140, 30);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Ingrese los datos de la familia");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(90, 10, 340, 50);

        setBounds(0, 0, 548, 413);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String cedula = fldCedula.getText();
        String apellido = fldApellido.getText();
        String celular = fldCelular.getText();
        boolean ok = true;
        if (cedula.equals("") || cedula.startsWith("ERROR")) {
            fldCedula.setText("ERROR. No puede ser vacío");
            fldCedula.setForeground(Color.red);
            ok = false;
        } else {
            for (Familia fam : modelo.getListaFamilias()) {
                if ((fam.getCedulaTitular().equals(cedula))) {
                    fldCedula.setText("ERROR. Debe ser única");
                    fldCedula.setForeground(Color.red);
                    ok = false;
                }
            }
        }
        if(apellido.equals("") || apellido.startsWith("ERROR")){
            fldApellido.setText("ERROR. No puede ser vacío");
            fldApellido.setForeground(Color.red);
            ok = false;
        }
        if (celular.equals("") || celular.startsWith("ERROR")) {
            fldCelular.setText("ERROR. No puede ser vacío");
            fldCelular.setForeground(Color.red);
            ok = false;
        }
        
        if(ok){
            VentanaExitoRegistro vent = new VentanaExitoRegistro("FAMILIA");
            vent.setVisible(true);
            Familia fam = new Familia(cedula, apellido, celular);
            modelo.agregarFamilia(fam);
            dispose();
        }
        modelo.notificarObs();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void fldCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fldCedulaKeyTyped
        fldCedula.setForeground(Color.black);
    }//GEN-LAST:event_fldCedulaKeyTyped

    private void fldApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fldApellidoKeyTyped
        fldApellido.setForeground(Color.black);
    }//GEN-LAST:event_fldApellidoKeyTyped

    private void fldCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fldCelularKeyTyped
        fldCelular.setForeground(Color.black);
    }//GEN-LAST:event_fldCelularKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JTextField fldApellido;
    private javax.swing.JTextField fldCedula;
    private javax.swing.JTextField fldCelular;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
