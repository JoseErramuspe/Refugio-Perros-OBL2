package interfaz;

import dominio.*;
import java.awt.Desktop;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class VentanaImportarDonaciones extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaImportarDonaciones.class.getName());

    public VentanaImportarDonaciones(Sistema sistema) {
        initComponents();
        modelo = sistema;
        ruta = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fldRuta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        botonImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(fldRuta);
        fldRuta.setBounds(40, 80, 500, 30);

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(565, 73, 80, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ubicación del Archivo:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 40, 300, 30);

        botonImportar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonImportar.setText("Importar");
        botonImportar.addActionListener(this::botonImportarActionPerformed);
        getContentPane().add(botonImportar);
        botonImportar.setBounds(40, 190, 120, 40);

        setBounds(0, 0, 691, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JFileChooser selector = new JFileChooser();

        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = selector.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arch = selector.getSelectedFile();
            fldRuta.setText(arch.getAbsolutePath());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void botonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImportarActionPerformed
        ArchivoLectura arch = null;
        ArchivoGrabacion out = null;
        boolean erroresAlCargar = false;
        this.ruta = this.fldRuta.getText();
        if (!ruta.equals("") && Files.exists(Path.of(ruta))) {
            arch = new ArchivoLectura(ruta);
        } else {
            JOptionPane.showMessageDialog(this, "Ruta invalida", "Error", 0);
        }
        if (arch != null) {
            int linea = 0;
            String rutaArchivoErrores = "";
            while (arch.hayMasLineas()) {
                linea++;
                String lineaError = linea + ":\n";
                boolean hayError = false;
                String[] datos = arch.linea().split("#");
                if (datos.length != 3) {
                    lineaError += "Formato de linea incorrecto\n";
                    hayError = true;
                    erroresAlCargar = true;
                } else {
                    Empresa emp = modelo.getEmpresaPorRut(datos[0]);
                    if (emp == null) {
                        lineaError += "Rut de empresa no registrado\n";
                        hayError = true;
                        erroresAlCargar = true;
                    }
                    if (Integer.parseInt(datos[1]) < 1 || Integer.parseInt(datos[1]) > 4) {
                        lineaError += "Tipo de alimento incorrecto\n";
                        hayError = true;
                        erroresAlCargar = true;
                    }
                    if (Integer.parseInt(datos[2]) <= 0) {
                        lineaError += "Cantidad de alimento incorrecta\n";
                        hayError = true;
                        erroresAlCargar = true;
                    }
                }
                lineaError += "\n";
                if (hayError) {
                    if (rutaArchivoErrores.equals("")) {
                        File archivoGuardado = new File(ruta);
                        rutaArchivoErrores = ruta.substring(0, ruta.lastIndexOf(".")) + "Error.txt";
                        out = new ArchivoGrabacion(rutaArchivoErrores);
                    }
                    out.grabarLinea(lineaError);
                } else {
                    Donacion don = new Donacion(modelo.getEmpresaPorRut(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), modelo.getListaDonaciones().size()+1);
                    modelo.agregarDonacion(don);
                }
            }
            modelo.notificarObs();
            this.dispose();
            if (!rutaArchivoErrores.equals("")) {
                out.cerrar();
                int cargar = JOptionPane.showConfirmDialog(this, "Existieron errores al cargar datos, ¿visualizar errores?", "Error", 1);
                if (cargar == JOptionPane.YES_OPTION) {
                    try {
                        Desktop.getDesktop().open(new File(rutaArchivoErrores));
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error al abrir el archivo de errores", "Error", 1);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "No hubieron errores al cargar datos", "Exito", 0);
            }
        }
    }//GEN-LAST:event_botonImportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonImportar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField fldRuta;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private String ruta;
}
