package interfaz;

public class VentanaExitoRegistro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaExitoRegistro.class.getName());

    public VentanaExitoRegistro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¡¡REGISTRO EXITOSO!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 80, 400, 90);

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);
        getContentPane().add(btnVolver);
        btnVolver.setBounds(120, 210, 160, 50);

        setBounds(0, 0, 414, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
