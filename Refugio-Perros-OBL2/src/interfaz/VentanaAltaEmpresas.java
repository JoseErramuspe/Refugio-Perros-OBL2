package interfaz;

import dominio.*;

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
        getContentPane().add(fldNombre);
        fldNombre.setBounds(30, 100, 190, 22);
        getContentPane().add(fldRut);
        fldRut.setBounds(300, 100, 190, 22);
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
        if(nombre.equals("")){
            fldNombre.setText("ERROR. No puede ser vacío");
            ok = false;
        }
        if (rut.equals("")) {
            fldRut.setText("ERROR. No puede ser vacío");
            ok = false;
        } else {
            for (Empresa emp : modelo.getListaEmpresas()) {
                if ((emp.getRut().equals(rut))) {
                    fldRut.setText("ERROR. Debe ser único");
                    ok = false;
                }
            }
        }
        if (direccion.equals("")) {
            fldDireccion.setText("ERROR. No puede ser vacío");
            ok = false;
        }
        if(ok){
            VentanaExitoRegistro vent = new VentanaExitoRegistro();
            vent.setVisible(true);
            Empresa emp = new Empresa(nombre, rut, direccion);
            modelo.agregarEmpresa(emp);
            dispose();
        }
    }//GEN-LAST:event_btnCrearActionPerformed

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
