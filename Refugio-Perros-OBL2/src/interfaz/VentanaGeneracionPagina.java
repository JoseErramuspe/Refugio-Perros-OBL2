package interfaz;

import dominio.*;
import java.awt.Desktop;
import javax.swing.*;
import java.io.*;

public class VentanaGeneracionPagina extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaGeneracionPagina.class.getName());

    public VentanaGeneracionPagina(Sistema sistema) {
        initComponents();
        modelo = sistema;
        ruta = "";
        nombre = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fldRuta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnCrearPagina = new javax.swing.JButton();
        fldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(fldRuta);
        fldRuta.setBounds(40, 80, 500, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nombre de la página:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 160, 300, 30);

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(565, 73, 80, 40);

        btnCrearPagina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCrearPagina.setText("Crear página");
        btnCrearPagina.addActionListener(this::btnCrearPaginaActionPerformed);
        getContentPane().add(btnCrearPagina);
        btnCrearPagina.setBounds(300, 190, 160, 40);
        getContentPane().add(fldNombre);
        fldNombre.setBounds(40, 190, 210, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ubicación de la página:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 40, 300, 30);

        btnAbrir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(this::btnAbrirActionPerformed);
        getContentPane().add(btnAbrir);
        btnAbrir.setBounds(490, 190, 120, 40);

        setBounds(0, 0, 691, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JFileChooser selector = new JFileChooser();

        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int resultado = selector.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File carpeta = selector.getSelectedFile();
            fldRuta.setText(carpeta.getAbsolutePath());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCrearPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPaginaActionPerformed
        String rutNom;
        String rutaAnt = ruta;
        String nombreAnt = nombre;
        ruta = fldRuta.getText();
        nombre = fldNombre.getText();
        if (nombre.equals("")) {
            nombre = "index.html";
        }
        if (!nombre.endsWith(".html")) {
            nombre += ".html";
        }
        if (!ruta.equals("")) {
            rutNom = ruta + File.separator + nombre;
        }
        else {
            rutNom = nombre;
        }
        try {
            ArchivoGrabacion arch = new ArchivoGrabacion(rutNom);
            System.out.println(arch);
            arch.grabarLinea("<html>");
            arch.grabarLinea("<head>");
            arch.grabarLinea("<meta charset=\"utf-8\">");
            arch.grabarLinea("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            arch.grabarLinea("<title>Reporte de adopciones</title>");
            arch.grabarLinea("</head>");
            arch.grabarLinea("<body>");
            arch.grabarLinea("<h1>Reporte de adopciones</h1>");
            arch.grabarLinea("<h3>Total de adopciones: " + modelo.getListaAdopciones().size() + "</h3>");
            arch.grabarLinea("<table border=1px >");
            arch.grabarLinea("<tr>");
            arch.grabarLinea("<th>Número</th>");
            arch.grabarLinea("<th>Código</th>");
            arch.grabarLinea("<th>Animal</th>");
            arch.grabarLinea("<th>Familia</th>");
            arch.grabarLinea("<th>Comentarios</th>");
            arch.grabarLinea("</tr>");
            for (Adopcion ad : modelo.getListaAdopciones()) {
                arch.grabarLinea("<tr>");
                arch.grabarLinea("<td>"+ad.getNumero()+"</td>");
                arch.grabarLinea("<td>"+ad.getAnimal().getCodigo()+"</td>");
                arch.grabarLinea("<td>"+ad.getAnimal().getNombre()+"</td>");
                arch.grabarLinea("<td>"+ad.getFamilia().getApellido()+"</td>");
                arch.grabarLinea("<td>"+ad.getComentarios()+"</td>");
                arch.grabarLinea("</tr>");
            }
            arch.grabarLinea("</table>");
            arch.grabarLinea("</body>");
            arch.grabarLinea("</html>");
            arch.cerrar();
            JOptionPane.showMessageDialog(this, "¡¡Página realizada con éxito!!", "REGISTRO", 1);            
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "No se ingresó una dirección válida","ERROR",0);
            this.ruta=rutaAnt;
            this.nombre=nombreAnt;
        }
    }//GEN-LAST:event_btnCrearPaginaActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        File arch;
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(this, "La página todavía no fue creada", "ERROR", 0);
        }
        else{
            if(ruta.equals("")){
                arch = new File(nombre);
            }
            else {
                arch = new File(ruta, nombre);
            }
            try{
                Desktop.getDesktop().open(arch);
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(this, "Error al abrir la página", "ERROR", 0);
            }
            catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(this, "Error al abrir la página", "ERROR", 0);
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearPagina;
    private javax.swing.JTextField fldNombre;
    private javax.swing.JTextField fldRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private String ruta;
    private String nombre;
}
