// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package interfaz;
import dominio.*;
import java.util.*;

public class VentanaConsultaFamilias extends javax.swing.JFrame implements Observer{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaConsultaFamilias.class.getName());

    public VentanaConsultaFamilias(Sistema sistema, boolean porApellido) {
        initComponents();
        modelo = sistema;
        ordPorApe = porApellido;
        modelo.addObserver(this);
        modelo.ordenarFam(ordPorApe);
        lstFamilias.setListData(listaConAdops().toArray());
    }
    
    public ArrayList<String> listaConAdops(){
        ArrayList<String> lista = new ArrayList<>();
        for(Familia fam: modelo.getListaFamilias()){
            String datos = "Familia: "+fam;
            int adopciones = 0;
            for(Adopcion ad : modelo.getListaAdopciones()){
                if(ad.getFamilia().equals(fam)){
                    adopciones++;
                }
            }
            datos += " Adopciones: " +adopciones;
            lista.add(datos);
        }
        return lista;
    }

    @Override
    public void update(Observable o, Object arg) {
        modelo.ordenarFam(ordPorApe);
        lstFamilias.setListData(listaConAdops().toArray());        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFamilias = new javax.swing.JList();
        btnSalir = new javax.swing.JButton();

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

        setBounds(0, 0, 414, 336);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstFamilias;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private boolean ordPorApe;
}
