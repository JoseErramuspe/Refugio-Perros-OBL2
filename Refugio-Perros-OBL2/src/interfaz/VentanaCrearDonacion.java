package interfaz;
import dominio.*;
import java.awt.Color;
import java.util.*;

public class VentanaCrearDonacion extends javax.swing.JFrame implements Observer{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCrearDonacion.class.getName());

    public VentanaCrearDonacion(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        lstEmpresas.setListData(modelo.getListaEmpresas().toArray());
    }
    
    @Override
    public void update(Observable o, Object arg) {
        lstEmpresas.setListData(modelo.getListaEmpresas().toArray());
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmpresas = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fldCant = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTipos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lstEmpresas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstEmpresas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 100, 146);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Cantidad (kg)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 90, 220, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Empresa:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 40, 110, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tipo de alimento");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 40, 220, 30);

        fldCant.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fldCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fldCantKeyTyped(evt);
            }
        });
        getContentPane().add(fldCant);
        fldCant.setBounds(290, 120, 190, 40);

        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(this::btnCrearActionPerformed);
        getContentPane().add(btnCrear);
        btnCrear.setBounds(170, 230, 130, 50);

        lstTipos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1-Para perros grandes", "2-Para perros chicos", "3-Para perros adultos", "4-Otra" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstTipos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(140, 70, 140, 146);

        setBounds(0, 0, 505, 330);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        Empresa emp = (Empresa) lstEmpresas.getSelectedValue();
        String tipo = lstTipos.getSelectedValue();
        int cant = 0;
        try {
            cant = Integer.parseInt(fldCant.getText());
            if(emp != null && tipo != null){
                Donacion don = new Donacion(emp, Integer.parseInt(tipo.charAt(0)+""), cant, modelo.getListaDonaciones().size()+1);
                modelo.agregarDonacion(don);
                modelo.notificarObs();
            }
        }
        catch (NumberFormatException e){
            fldCant.setText("ERROR. No puede tener letras o ser vacío");
            fldCant.setForeground(Color.red);
        }
        modelo.notificarObs();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void fldCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fldCantKeyTyped
        fldCant.setForeground(Color.black);
    }//GEN-LAST:event_fldCantKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JTextField fldCant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstEmpresas;
    private javax.swing.JList<String> lstTipos;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
