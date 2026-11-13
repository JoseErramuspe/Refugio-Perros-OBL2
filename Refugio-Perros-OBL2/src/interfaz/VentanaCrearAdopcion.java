package interfaz;

import dominio.*;
import java.util.*;

public class VentanaCrearAdopcion extends javax.swing.JFrame implements Observer {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCrearAdopcion.class.getName());

    public VentanaCrearAdopcion(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        lstAnimales.setListData(modelo.getListaAnimales().toArray());
        lstFamilias.setListData(modelo.getListaFamilias().toArray());
    }

    @Override
    public void update(Observable o, Object arg) {
        lstAnimales.setListData(modelo.getListaAnimales().toArray());
        lstFamilias.setListData(modelo.getListaFamilias().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstAnimales = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFamilias = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        fldComen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lstAnimales.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstAnimales.addListSelectionListener(this::lstAnimalesValueChanged);
        jScrollPane1.setViewportView(lstAnimales);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 90, 146);

        lstFamilias.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstFamilias);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(170, 70, 100, 146);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Familia:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 30, 90, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Animal:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 90, 40);

        lblTemp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTemp.setText("Temperamento:");
        getContentPane().add(lblTemp);
        lblTemp.setBounds(10, 210, 170, 40);

        lblPeso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPeso.setText("Peso: ");
        getContentPane().add(lblPeso);
        lblPeso.setBounds(10, 230, 160, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Comentarios:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 90, 250, 30);

        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(this::btnCrearActionPerformed);
        getContentPane().add(btnCrear);
        btnCrear.setBounds(300, 210, 130, 50);
        getContentPane().add(fldComen);
        fldComen.setBounds(300, 130, 240, 40);

        setBounds(0, 0, 570, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        Animal ani = (Animal) lstAnimales.getSelectedValue();
        Familia fam = (Familia) lstFamilias.getSelectedValue();
        String com = fldComen.getText();
        if(ani != null && fam != null){
            Adopcion adop = new Adopcion(ani,fam,com);
            modelo.agregarAdopcion(adop);
            modelo.notificarObs();
            VentanaExitoRegistro vent = new VentanaExitoRegistro("ADOPCIÓN");
            vent.setVisible(true);
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void lstAnimalesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAnimalesValueChanged
        Animal ani = (Animal) lstAnimales.getSelectedValue();
        lblTemp.setText("Temperamento: "+ani.getTemperamento());
        lblPeso.setText("Peso: "+ani.getPeso());
    }//GEN-LAST:event_lstAnimalesValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JTextField fldComen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JList lstAnimales;
    private javax.swing.JList lstFamilias;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;

}
