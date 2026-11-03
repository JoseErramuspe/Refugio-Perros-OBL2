package interfaz;

public class VentanaResultado extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaResultado.class.getName());

    public VentanaResultado(String titulo, String mensaje) {
        initComponents();
        lblTitulo.setText(titulo);
        lblDesc.setText(mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        btnReintentar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("TITULO");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(130, 20, 130, 70);

        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDesc.setText("Descripción");
        lblDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblDesc);
        lblDesc.setBounds(20, 100, 360, 110);

        btnReintentar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReintentar.setText("OK");
        btnReintentar.addActionListener(this::btnReintentarActionPerformed);
        getContentPane().add(btnReintentar);
        btnReintentar.setBounds(130, 230, 120, 50);

        setBounds(0, 0, 414, 337);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReintentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReintentarActionPerformed
        dispose();
    }//GEN-LAST:event_btnReintentarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReintentar;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
