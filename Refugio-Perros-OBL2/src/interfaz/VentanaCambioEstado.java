package interfaz;
import dominio.*;
import java.awt.Color;
import java.util.*;

public class VentanaCambioEstado extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCambioEstado.class.getName());

    public VentanaCambioEstado(Sistema sistema) {
        initComponents();
        terminoCargar = false;
        modelo = sistema;
        lstAnimales.setListData(this.noEntregados().toArray());
        for (int i = 0; i < this.noEntregados().size(); i++) {
            lstAnimales.setSelectedIndex(i);
            Animal ani = (Animal) lstAnimales.getSelectedValue();
            if(ani.getEstado().equals("No disponible para adoptar")){
                lstAnimales.setSelectionBackground(Color.red);
            }
            else {
                lstAnimales.setSelectionBackground(Color.green);
            }
        }
        lstAnimales.clearSelection();
        terminoCargar = true;
    }

    public ArrayList<Animal> noEntregados(){
        ArrayList<Animal> listaNoEntre = new ArrayList<>();
        for(Animal ani: modelo.getListaAnimales()){
            if(!ani.getEstado().equals("Entregado")){
                listaNoEntre.add(ani);
            }
        }
        return listaNoEntre;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstAnimales = new javax.swing.JList();
        lblNombre = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        btnCambiar = new javax.swing.JButton();

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
        jScrollPane1.setBounds(40, 66, 110, 150);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(250, 40, 100, 30);

        lblCodigo.setText("Código:");
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(250, 70, 100, 16);

        lblTemp.setText("Temperamento:");
        getContentPane().add(lblTemp);
        lblTemp.setBounds(250, 100, 160, 20);

        lblPeso.setText("Peso:");
        getContentPane().add(lblPeso);
        lblPeso.setBounds(250, 140, 130, 16);

        btnCambiar.setText("Cambiar estado");
        btnCambiar.addActionListener(this::btnCambiarActionPerformed);
        getContentPane().add(btnCambiar);
        btnCambiar.setBounds(270, 220, 120, 23);

        setBounds(0, 0, 521, 345);
    }// </editor-fold>//GEN-END:initComponents

    private void lstAnimalesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAnimalesValueChanged
        if (terminoCargar) {
            Animal ani = (Animal) lstAnimales.getSelectedValue();
            lblNombre.setText("Nombre: "+ani.getNombre());
            lblCodigo.setText("Código: "+ani.getCodigo());
            lblTemp.setText("Temperamento: "+ani.getTemperamento());
            lblPeso.setText("Peso: "+ani.getPeso());
        }
    }//GEN-LAST:event_lstAnimalesValueChanged

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        Animal ani = (Animal) lstAnimales.getSelectedValue();
        ani.cambiarEstado();
    }//GEN-LAST:event_btnCambiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JList lstAnimales;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private boolean terminoCargar;
}
