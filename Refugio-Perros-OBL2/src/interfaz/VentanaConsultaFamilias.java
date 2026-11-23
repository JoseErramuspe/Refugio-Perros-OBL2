// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package interfaz;
import dominio.*;
import java.util.*;

public class VentanaConsultaFamilias extends javax.swing.JFrame implements Observer{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaConsultaFamilias.class.getName());

    public VentanaConsultaFamilias(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        rdApellido.setSelected(true);
        modelo.ordenarFam(true);
        lstFamilias.setListData(modelo.famConAdops().toArray());
    }

    @Override
    public void update(Observable o, Object arg) {
        modelo.ordenarFam(rdApellido.isSelected());
        lstFamilias.setListData(modelo.famConAdops().toArray());        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFamilias = new javax.swing.JList();
        btnSalir = new javax.swing.JButton();
        rdApellido = new javax.swing.JRadioButton();
        rdAdopciones = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Familias");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 30, 180, 40);

        lstFamilias.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstFamilias);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 70, 250, 200);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        getContentPane().add(btnSalir);
        btnSalir.setBounds(130, 283, 100, 30);

        buttonGroup1.add(rdApellido);
        rdApellido.setText("Por apellido");
        rdApellido.addItemListener(this::rdApellidoItemStateChanged);
        rdApellido.addActionListener(this::rdApellidoActionPerformed);
        getContentPane().add(rdApellido);
        rdApellido.setBounds(320, 90, 120, 21);

        buttonGroup1.add(rdAdopciones);
        rdAdopciones.setText("Por adopciones");
        rdAdopciones.addActionListener(this::rdAdopcionesActionPerformed);
        getContentPane().add(rdAdopciones);
        rdAdopciones.setBounds(320, 150, 120, 21);

        setBounds(0, 0, 461, 356);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rdApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdApellidoActionPerformed
        modelo.ordenarFam(true);
        lstFamilias.setListData(modelo.famConAdops().toArray());
    }//GEN-LAST:event_rdApellidoActionPerformed

    private void rdAdopcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAdopcionesActionPerformed
        modelo.ordenarFam(false);
        lstFamilias.setListData(modelo.famConAdops().toArray());
    }//GEN-LAST:event_rdAdopcionesActionPerformed

    private void rdApellidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdApellidoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rdApellidoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstFamilias;
    private javax.swing.JRadioButton rdAdopciones;
    private javax.swing.JRadioButton rdApellido;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
