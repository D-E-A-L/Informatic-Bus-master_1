package Interface;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import publictransport.DB.*;

public class AddCliente extends javax.swing.JFrame {
    
    public String cedula;
    public String nombre;
    public String apellido;
    public String telefono;
    public String TipoUsuario;
    public double saldo;
    public String fecha;
    public String codImagen;
    public String nombreImagen;
    public String urlImagen;

    public AddCliente() {
        initComponents();
        setTitle("Nuevo Cliente");
        setBounds(700, 300, 700, 520);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ciField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellidosField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtFoto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fechaNacField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TUsuarioBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        saldoField = new javax.swing.JTextField();
        guardarBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbl10 = new javax.swing.JLabel();
        cargarFoto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        telefonoField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("nuevo cliente");
        setPreferredSize(new java.awt.Dimension(580, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("CEDULA DE IDENTIDAD:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, -1, -1));

        ciField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ciField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciFieldActionPerformed(evt);
            }
        });
        getContentPane().add(ciField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 260, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("NOMBRE:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 165, -1, -1));

        nombreField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(nombreField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 260, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("APELLIDO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 205, -1, -1));

        apellidosField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(apellidosField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 260, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("FOTO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, -1));

        jtxtFoto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jtxtFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 260, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("NACIMIENTO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        fechaNacField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(fechaNacField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 260, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("USUARIO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        TUsuarioBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TUsuarioBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Niño", "Colegial", "Universitario", "Adulto Mayor" }));
        getContentPane().add(TUsuarioBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 358, 120, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("SALDO DISPONIBLE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, -1, -1));

        saldoField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(saldoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 90, -1));

        guardarBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        guardarBtn.setText("GUARDAR");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(guardarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 104, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DATOS PERSONALES DEL CLIENTE");
        jLabel9.setAlignmentX(0.5F);
        jLabel9.setAutoscrolls(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 460, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jbl10);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 150, 140));

        cargarFoto.setBackground(new java.awt.Color(255, 255, 255));
        cargarFoto.setText("CARGAR FOTO");
        cargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(cargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("TELEFONO:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 285, -1, -1));

        telefonoField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(telefonoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 260, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publictransport/imagenes/fondo.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        Tableo insertador = new Tableo();
        TableroImagen ti = new TableroImagen();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        cedula=ciField.getText();
        nombre = nombreField.getText();
        apellido = apellidosField.getText();
        telefono = telefonoField.getText();
        TipoUsuario = (String)TUsuarioBox.getSelectedItem();
        saldo = Double.valueOf(saldoField.getText());
        fecha = fechaNacField.getText();
        
        codImagen=ciField.getText();
        nombreImagen=nombreField.getText();
        urlImagen=jtxtFoto.getText();
        
        
                
        System.out.println(this.TipoUsuario);
        System.out.println(this.nombre);
        System.out.println(this.apellido);
        System.out.println(this.cedula);
        

        /*Date fecha = null;
        try {
            fecha = formatter.parse(fechaNacField.getText());
        } catch (ParseException ex) {
            Logger.getLogger(AddCliente.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {        
            insertador.insertCliente(cedula, nombre, apellido, telefono, fecha, TipoUsuario, saldo);
            ti.insertImagen(codImagen, nombreImagen, urlImagen);
        } catch (SQLException ex) {
            Logger.getLogger(AddCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jbl10.setIcon(null);
        ciField.setText(null);
        nombreField.setText(null);
        apellidosField.setText(null);
        telefonoField.setText(null);
        TUsuarioBox.setSelectedItem(null);
        saldoField.setText(null);
        fechaNacField.setText(null);
        jtxtFoto.setText(null);   
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void ciFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciFieldActionPerformed

    private void cargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarFotoActionPerformed
       File archivo;
       JFileChooser flcArchivo = new JFileChooser();
       flcArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de Imagen","jpg","jpeg","png"));
       int res = flcArchivo.showOpenDialog(this);
       //int ress=flcArchivo.getDialogType();
       if(res == JFileChooser.APPROVE_OPTION)
       {
           archivo = flcArchivo.getSelectedFile();
           jtxtFoto.setText(archivo.getAbsolutePath());
           Image fts = getToolkit().getImage(jtxtFoto.getText());
           fts = fts.getScaledInstance(255, 255, 1);
           jbl10.setIcon(new ImageIcon(fts));
       }
    }//GEN-LAST:event_cargarFotoActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCliente().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox TUsuarioBox;
    private javax.swing.JTextField apellidosField;
    private javax.swing.JButton cargarFoto;
    private javax.swing.JTextField ciField;
    private javax.swing.JTextField fechaNacField;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jbl10;
    private javax.swing.JTextField jtxtFoto;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField saldoField;
    private javax.swing.JTextField telefonoField;
    // End of variables declaration//GEN-END:variables
}
