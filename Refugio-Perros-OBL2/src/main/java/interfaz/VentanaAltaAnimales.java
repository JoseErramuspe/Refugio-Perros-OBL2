package interfaz;
import dominio.*;

public class VentanaAltaAnimales extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAltaAnimales.class.getName());

    public VentanaAltaAnimales(Sistema sistema) {
        initComponents();
        modelo = sistema;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fldCodigo = new javax.swing.JTextField();
        fldNombre = new javax.swing.JTextField();
        fldTemp = new javax.swing.JTextField();
        fldPeso = new javax.swing.JTextField();
        btnCrearAnimal = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(fldCodigo);
        fldCodigo.setBounds(30, 100, 110, 22);
        getContentPane().add(fldNombre);
        fldNombre.setBounds(230, 100, 110, 22);
        getContentPane().add(fldTemp);
        fldTemp.setBounds(30, 170, 110, 22);
        getContentPane().add(fldPeso);
        fldPeso.setBounds(230, 170, 110, 22);

        btnCrearAnimal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCrearAnimal.setText("Crear");
        btnCrearAnimal.addActionListener(this::btnCrearAnimalActionPerformed);
        getContentPane().add(btnCrearAnimal);
        btnCrearAnimal.setBounds(130, 230, 120, 50);

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCodigo.setText("Código");
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(30, 70, 110, 30);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(230, 70, 100, 30);

        lblTemp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTemp.setText("Temperamento");
        getContentPane().add(lblTemp);
        lblTemp.setBounds(30, 140, 140, 30);

        lblPeso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPeso.setText("Peso (kg)");
        getContentPane().add(lblPeso);
        lblPeso.setBounds(230, 140, 100, 30);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Ingrese los datos del animal");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(30, 10, 340, 50);

        setBounds(0, 0, 414, 342);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAnimalActionPerformed
        String codigo = fldCodigo.getText();
        String nombre = fldNombre.getText();
        String temp = fldTemp.getText();
        int peso = 0;
        String error = "";
        for(Animal ani: modelo.getListaAnimales()){
            if((ani.getCodigo().equals(codigo) || codigo.equals("")) && error.equals("")){
                error += "El código está repetido o es vacío.\n";
            }
        }
        if(nombre.equals("")){
            error += "El nombre es vacío.\n";
        }
        if(temp.equals("")){
            error += "El temperamento es vacío.\n";
        }
        try{
            peso = Integer.parseInt(fldPeso.getText());
        } catch(NumberFormatException e){
            error += "El peso tiene letras o es vacío";
        }
        VentanaResultado vent;
        if(error.equals("")){
            Animal ani = new Animal(codigo, nombre, temp, peso, "No disponible para adoptar");
            modelo.agregarAnimal(ani);
            vent = new VentanaResultado("EXITO", "El animal fue creado con éxito");
        }
        else {
            vent = new VentanaResultado("ERROR", error);
        }
        vent.setVisible(true);
    }//GEN-LAST:event_btnCrearAnimalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearAnimal;
    private javax.swing.JTextField fldCodigo;
    private javax.swing.JTextField fldNombre;
    private javax.swing.JTextField fldPeso;
    private javax.swing.JTextField fldTemp;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
