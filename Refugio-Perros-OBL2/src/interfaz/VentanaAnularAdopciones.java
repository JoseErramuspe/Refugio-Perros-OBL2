// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package interfaz;

import dominio.*;
import java.util.*;

public class VentanaAnularAdopciones extends javax.swing.JFrame implements Observer {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAnularAdopciones.class.getName());

    public VentanaAnularAdopciones(Sistema sistema) {
        this.modelo = sistema;
        initComponents();
        this.lstAdopciones.setListData(modelo.getListaAdopciones().toArray());
        modelo.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.lstAdopciones.setListData(modelo.getListaAdopciones().toArray());
        this.AF.setText("Apellido Familia: ");
            this.CT.setText("Cedula Titular: ");
            this.NA.setText("Nombre Animal: ");
            this.CA.setText("Codigo Animal: ");
            this.C.setText("Comentarios: ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstAdopciones = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        AF = new javax.swing.JLabel();
        NA = new javax.swing.JLabel();
        botonAnularAdopcion = new javax.swing.JButton();
        CA = new javax.swing.JLabel();
        CT = new javax.swing.JLabel();
        C = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstAdopciones.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstAdopciones.addListSelectionListener(this::lstAdopcionesValueChanged);
        jScrollPane1.setViewportView(lstAdopciones);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Adopciones:");

        AF.setText("Apellido Familia:");

        NA.setText("Nombre Animal:");

        botonAnularAdopcion.setText("Anular Adopcion");
        botonAnularAdopcion.addActionListener(this::botonAnularAdopcionActionPerformed);

        CA.setText("Codigo Animal:");

        CT.setText("Cedula Titular:");

        C.setText("Comentarios:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(botonAnularAdopcion))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CT)
                            .addComponent(AF)
                            .addComponent(NA)
                            .addComponent(CA)
                            .addComponent(C))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(AF)
                        .addGap(18, 18, 18)
                        .addComponent(CT)
                        .addGap(18, 18, 18)
                        .addComponent(NA)
                        .addGap(18, 18, 18)
                        .addComponent(CA)
                        .addGap(18, 18, 18)
                        .addComponent(C)
                        .addGap(40, 40, 40)
                        .addComponent(botonAnularAdopcion)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnularAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnularAdopcionActionPerformed
        Adopcion adop = (Adopcion)this.lstAdopciones.getSelectedValue();
        if (adop != null) {
            modelo.anularAdopcion(adop);
        }
        modelo.notificarObs();
    }//GEN-LAST:event_botonAnularAdopcionActionPerformed

    private void lstAdopcionesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAdopcionesValueChanged
        Adopcion adop = (Adopcion)this.lstAdopciones.getSelectedValue();
        if (adop != null) {
            this.AF.setText("Apellido Familia: " + adop.getFamilia().getApellido());
            this.CT.setText("Cedula Titular: " + adop.getFamilia().getCedulaTitular());
            this.NA.setText("Nombre Animal: " + adop.getAnimal().getNombre());
            this.CA.setText("Codigo Animal: " + adop.getAnimal().getCodigo());
            this.C.setText("Comentarios: " + adop.getComentarios());
        }
    }//GEN-LAST:event_lstAdopcionesValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AF;
    private javax.swing.JLabel C;
    private javax.swing.JLabel CA;
    private javax.swing.JLabel CT;
    private javax.swing.JLabel NA;
    private javax.swing.JButton botonAnularAdopcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstAdopciones;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
