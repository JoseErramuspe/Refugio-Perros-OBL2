// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package interfaz;

import dominio.*;
import java.util.Observable;
import java.util.Observer;

public class VentanaConsultaDonaciones extends javax.swing.JFrame implements Observer {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaConsultaDonaciones.class.getName());
    
    public VentanaConsultaDonaciones(Sistema sistema) {
        this.modelo = sistema;
        initComponents();
        modelo.addObserver(this);
        this.actualizarLista();
    }
    
    public void actualizarLista() {
        this.lstDonaciones.setListData(modelo.getListaDonaciones().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDonaciones = new javax.swing.JList();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Donaciones");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 30, 180, 40);

        lstDonaciones.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstDonaciones);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 70, 250, 200);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        getContentPane().add(btnSalir);
        btnSalir.setBounds(130, 283, 100, 30);

        setBounds(0, 0, 416, 343);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstDonaciones;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;

    @Override
    public void update(Observable o, Object arg) {
        this.actualizarLista();
    }
}
