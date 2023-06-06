/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import event.PersonalMg;
import event.ZonaMg;
import event.ZonaPersonalMg;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import util.HibernateUtil;


/**
 *
 * @author vfern
 */
public class JDZonaPersonal extends javax.swing.JFrame {
    ZonaMg zmg = new ZonaMg();
    PersonalMg pmg = new PersonalMg();
    ZonaPersonalMg zpmg = new ZonaPersonalMg();
    DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
    String idzp;
    int ultimo;
    /**
     * Creates new form JDZonaPersonal
     */
    public JDZonaPersonal() {
        initComponents();
        comboidper();
        comboidzon();
        dcfechaini.setDateFormatString("yyyy-MM-dd");
        dcfechafin.setDateFormatString("yyyy-MM-dd");
        this.setLocationRelativeTo(null);
        if (zpmg.countZona()!= 0) {
            ultimo = zpmg.countZona()+ 1;
            idzp = String.valueOf(ultimo);
        } else {
            idzp = "1";
        }
        txtidzp.setText(idzp);
        System.out.println(ultimo);
    }
    private void comboidzon() {
        List ids;
        ids = zmg.listidpro();
        Iterator it = ids.iterator();
        while (it.hasNext()) {
            cmbidzona.addItem(it.next());
        }
    }
    private void comboidper() {
        List ids;
        ids = pmg.listidpro();
        Iterator it = ids.iterator();
        while (it.hasNext()) {
            cmbidpersonal.addItem(it.next());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbidpersonal = new javax.swing.JComboBox();
        txtnombrepersona = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnsiguiente = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dcfechaini = new com.toedter.calendar.JDateChooser();
        dcfechafin = new com.toedter.calendar.JDateChooser();
        cmbidzona = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtidzp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnombrezon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de asignacios a zonas");

        jLabel1.setText("Registre los datos correspondientes");

        jLabel3.setText("Id personal");

        cmbidpersonal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbidpersonalItemStateChanged(evt);
            }
        });

        txtnombrepersona.setEditable(false);
        txtnombrepersona.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Nombre");

        btnsiguiente.setForeground(new java.awt.Color(51, 153, 0));
        btnsiguiente.setText("Siguiente");
        btnsiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsiguienteMouseClicked(evt);
            }
        });

        btncancelar.setForeground(new java.awt.Color(204, 0, 0));
        btncancelar.setText("Cancelar");
        btncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarMouseClicked(evt);
            }
        });

        jLabel6.setText("Id zona");

        jLabel7.setText("Fecha Inicio");

        jLabel8.setText("Fecha Fin");

        cmbidzona.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbidzonaItemStateChanged(evt);
            }
        });

        jLabel2.setText("Id Historial");

        txtidzp.setEditable(false);
        txtidzp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Nombre zona");

        txtnombrezon.setEditable(false);
        txtnombrezon.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(21, 21, 21)
                        .addComponent(btnsiguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncancelar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dcfechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbidzona, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombrepersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbidpersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(txtidzp, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtnombrezon)))
                        .addComponent(dcfechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidzp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbidpersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombrepersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbidzona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombrezon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcfechaini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(dcfechafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsiguiente)
                    .addComponent(btncancelar))
                .addContainerGap())
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

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncancelarMouseClicked

    private void cmbidpersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbidpersonalItemStateChanged
        // TODO add your handling code here:
        List result = null;
        if(evt.getStateChange()==ItemEvent.SELECTED){
            try {
            //Obtener la sesión actual
                Session session = HibernateUtil.getSessionFactory().openSession();
            //Comenzar la transacción
                session.beginTransaction();
            //Obtener la lista de ids
                result = session.createQuery("select a.nombre from Personal a where a.idPersonal="+cmbidpersonal.getSelectedItem().toString()+"").list();
            //Confirmar transacción
                session.getTransaction().commit();
                txtnombrepersona.setText(result.toString());
                session.close();
            } catch (Exception exc) {
                System.out.print("Error en lectura objetos Personal");
                exc.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmbidpersonalItemStateChanged

    private void btnsiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsiguienteMouseClicked
        // TODO add your handling code here:
        if(txtnombrepersona.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
           int idp = Integer.parseInt(cmbidpersonal.getSelectedItem().toString());
           int idz = Integer.parseInt(cmbidzona.getSelectedItem().toString());
           int resp = JOptionPane.showConfirmDialog(null, "¿Los datos ingresados son los correctos?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
           if (resp == 0) {
            zpmg.guardaConsulta(dcfechaini.getDate(), dcfechafin.getDate(), idp, idz);
            JOptionPane.showMessageDialog(this, "Registro realizado", "Listo", JOptionPane.INFORMATION_MESSAGE);            
            }else
                JOptionPane.showMessageDialog(this, "Modifique los datos correspondientes", "Listo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnsiguienteMouseClicked

    private void cmbidzonaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbidzonaItemStateChanged
        // TODO add your handling code here:
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
                txtnombrezon.setText(result.toString());
                session.close();
            } catch (Exception exc) {
                System.out.print("Error en lectura objetos Vivero");
                exc.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmbidzonaItemStateChanged

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
            java.util.logging.Logger.getLogger(JDZonaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDZonaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDZonaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDZonaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDZonaPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JComboBox cmbidpersonal;
    private javax.swing.JComboBox cmbidzona;
    private com.toedter.calendar.JDateChooser dcfechafin;
    private com.toedter.calendar.JDateChooser dcfechaini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtidzp;
    private javax.swing.JTextField txtnombrepersona;
    private javax.swing.JTextField txtnombrezon;
    // End of variables declaration//GEN-END:variables
}
