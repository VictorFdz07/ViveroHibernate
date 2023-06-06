/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Existencia;
import entity.Producto;
import entity.Zona;
import event.ExistenciaMg;
import event.ProductoMg;
import event.ZonaMg;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class JDExistenciaModificar extends javax.swing.JFrame {
    ExistenciaMg emg = new ExistenciaMg();
    ZonaMg zmg = new ZonaMg();
    ProductoMg pmg = new ProductoMg();
    String idexi;
    int ultimo;

    public JDExistenciaModificar() {
        initComponents();
    }
    
    
    
    public JDExistenciaModificar(Existencia e, String id) {
        Existencia exi = e;
        initComponents();
        comboidpro();
        comboidzon();
        this.setLocationRelativeTo(null);
        txtcantidad.setText(String.valueOf(exi.getCantidad()));
        txtidexi.setText(id);
    }
    
    private void comboidzon() {
        List ids;
        ids = zmg.listidpro();
        Iterator it = ids.iterator();
        while (it.hasNext()) {
            cmbidzona.addItem(it.next());
        }
    }
    private void comboidpro() {
        List ids;
        ids = pmg.listidpro();
        Iterator it = ids.iterator();
        while (it.hasNext()) {
            cmbidproducto.addItem(it.next());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbidzona = new javax.swing.JComboBox();
        cmbidproducto = new javax.swing.JComboBox();
        txtnombreproducto = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        btnsiguiente = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnomzona = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtidexi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de existencias");

        jLabel2.setText("Id Zona");

        jLabel4.setText("Id producto");

        jLabel5.setText("Nombre producto");

        jLabel6.setText("Cantidad");

        cmbidzona.setEditable(true);
        cmbidzona.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbidzonaItemStateChanged(evt);
            }
        });

        cmbidproducto.setEditable(true);
        cmbidproducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbidproductoItemStateChanged(evt);
            }
        });

        txtnombreproducto.setEditable(false);

        btnsiguiente.setForeground(new java.awt.Color(0, 102, 0));
        btnsiguiente.setText("Siguiente");
        btnsiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsiguienteMouseClicked(evt);
            }
        });

        btncancelar.setForeground(new java.awt.Color(102, 0, 0));
        btncancelar.setText("Cancelar");
        btncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarMouseClicked(evt);
            }
        });

        jLabel1.setText("Nombre zona");

        jLabel3.setText("Id Existencia");

        txtidexi.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(21, 21, 21)
                                .addComponent(txtnombreproducto))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(70, 70, 70)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(44, 44, 44)
                                .addComponent(txtnomzona)))
                        .addGap(18, 18, 18)
                        .addComponent(btncancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbidproducto, 0, 176, Short.MAX_VALUE)
                                    .addComponent(cmbidzona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnsiguiente))
                            .addComponent(txtidexi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtidexi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbidzona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsiguiente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnomzona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btncancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbidzonaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbidzonaItemStateChanged
        List result = null;
        if(evt.getStateChange()==ItemEvent.SELECTED){
            try {
            //Obtener la sesión actual
                Session session = HibernateUtil.getSessionFactory().openSession();
            //Comenzar la transacción
                session.beginTransaction();
            //Obtener la lista de ids
                result = session.createQuery("select a.nombre from Zona a where a.idZona="+cmbidzona.getSelectedItem().toString()+"").list();
            //Confirmar transacción
                session.getTransaction().commit();
                txtnomzona.setText(result.toString());
                session.close();
            } catch (Exception exc) {
                System.out.print("Error en lectura objetos Vivero");
                exc.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmbidzonaItemStateChanged

    private void cmbidproductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbidproductoItemStateChanged
        List result = null;
        if(evt.getStateChange()==ItemEvent.SELECTED){
            try {
            //Obtener la sesión actual
                Session session = HibernateUtil.getSessionFactory().openSession();
            //Comenzar la transacción
                session.beginTransaction();
            //Obtener la lista de ids
                result = session.createQuery("select a.nombre from Producto a where a.idProducto="+cmbidproducto.getSelectedItem().toString()+"").list();
            //Confirmar transacción
                session.getTransaction().commit();
                txtnombreproducto.setText(result.toString());
                session.close();
            } catch (Exception exc) {
                System.out.print("Error en lectura objetos Producto");
                exc.printStackTrace();
            }
        
        }
    }//GEN-LAST:event_cmbidproductoItemStateChanged

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncancelarMouseClicked

    private void btnsiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsiguienteMouseClicked
        // TODO add your handling code here:
        if (txtcantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
           int cant = Integer.parseInt(txtcantidad.getText());
           int ide = Integer.parseInt(txtidexi.getText());
           int idpro = Integer.parseInt(cmbidproducto.getSelectedItem().toString());
           int idzon = Integer.parseInt(cmbidzona.getSelectedItem().toString());
           int resp = JOptionPane.showConfirmDialog(null, "¿Los datos ingresados son los correctos?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
           if (resp == 0) {
               Zona z;
               Producto p;
               Session session = HibernateUtil.getSessionFactory().openSession();
               session.beginTransaction();
               z = (Zona) session.get(Zona.class, idzon);
               p = (Producto) session.get(Producto.class, idpro);
               Existencia e = new Existencia(p, z, cant);
               emg.updateExistencia(e, ide);
               JOptionPane.showMessageDialog(this, "Registro realizado", "Listo", JOptionPane.INFORMATION_MESSAGE);            
               }else
                    JOptionPane.showMessageDialog(this, "Modifique los datos correspondientes", "Listo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnsiguienteMouseClicked

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
            java.util.logging.Logger.getLogger(JDExistenciaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDExistenciaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDExistenciaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDExistenciaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JDExistenciaModificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JComboBox cmbidproducto;
    private javax.swing.JComboBox cmbidzona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtidexi;
    private javax.swing.JTextField txtnombreproducto;
    private javax.swing.JTextField txtnomzona;
    // End of variables declaration//GEN-END:variables
}
