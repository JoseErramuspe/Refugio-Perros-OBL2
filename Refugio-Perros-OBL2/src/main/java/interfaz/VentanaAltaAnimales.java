package interfaz;

import dominio.*;

public class VentanaAltaAnimales extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAltaAnimales.class.getName());

    public VentanaAltaAnimales(Sistema sistema) {
        initComponents();
        modelo = sistema;
        rdDisp.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        fldCodigo = new javax.swing.JTextField();
        fldNombre = new javax.swing.JTextField();
        fldTemp = new javax.swing.JTextField();
        fldPeso = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        rdDisp = new javax.swing.JRadioButton();
        rdNoDisp = new javax.swing.JRadioButton();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(fldCodigo);
        fldCodigo.setBounds(30, 100, 170, 22);
        getContentPane().add(fldNombre);
        fldNombre.setBounds(300, 100, 210, 22);
        getContentPane().add(fldTemp);
        fldTemp.setBounds(30, 170, 170, 22);
        getContentPane().add(fldPeso);
        fldPeso.setBounds(300, 170, 210, 22);

        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(this::btnCrearActionPerformed);
        getContentPane().add(btnCrear);
        btnCrear.setBounds(190, 280, 120, 50);

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCodigo.setText("Código");
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(30, 70, 110, 30);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(300, 70, 100, 30);

        lblTemp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTemp.setText("Temperamento");
        getContentPane().add(lblTemp);
        lblTemp.setBounds(30, 140, 140, 30);

        lblPeso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPeso.setText("Peso (kg)");
        getContentPane().add(lblPeso);
        lblPeso.setBounds(300, 140, 100, 30);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Ingrese los datos del animal");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(110, 10, 340, 50);

        buttonGroup1.add(rdDisp);
        rdDisp.setText("Disponible");
        getContentPane().add(rdDisp);
        rdDisp.setBounds(110, 240, 98, 21);

        buttonGroup1.add(rdNoDisp);
        rdNoDisp.setText("No disponible");
        getContentPane().add(rdNoDisp);
        rdNoDisp.setBounds(300, 240, 160, 21);

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEstado.setText("Estado");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(220, 210, 110, 30);

        setBounds(0, 0, 548, 413);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String codigo = fldCodigo.getText();
        String nombre = fldNombre.getText();
        String temp = fldTemp.getText();
        int peso = 0;
        boolean ok = true;
        if (codigo.equals("")) {
            fldCodigo.setText("ERROR. No puede ser vacío");
            ok = false;
        } else {
            for (Animal ani : modelo.getListaAnimales()) {
                if ((ani.getCodigo().equals(codigo))) {
                    fldCodigo.setText("ERROR. Debe ser único");
                    ok = false;
                }
            }
        }
        if(nombre.equals("")){
            fldNombre.setText("ERROR. No puede ser vacío");
            ok = false;
        }
        if (temp.equals("")) {
            fldTemp.setText("ERROR. No puede ser vacío");
            ok = false;
        }
        try {
            peso = Integer.parseInt(fldPeso.getText());
        } catch (NumberFormatException e) {
            fldPeso.setText("ERROR. No puede tener letras o ser vacío");
            ok = false;
        }
        if(ok){
            VentanaExitoRegistro vent = new VentanaExitoRegistro();
            vent.setVisible(true);
            Animal ani = new Animal(codigo, nombre, temp, peso, "Disponible para adoptar");
            if(rdNoDisp.isSelected()){
                ani.cambiarEstado();
            }
            modelo.agregarAnimal(ani);
            dispose();
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fldCodigo;
    private javax.swing.JTextField fldNombre;
    private javax.swing.JTextField fldPeso;
    private javax.swing.JTextField fldTemp;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdDisp;
    private javax.swing.JRadioButton rdNoDisp;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
