/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import entity.Ambiente;
import entity.Existencia;
import entity.Personal;
import entity.Planta;
import entity.Producto;
import entity.Vivero;
import entity.Zona;
import entity.ZonaPersonal;
import event.AmbienteMg;
import event.ExistenciaMg;
import event.OpCRUD;
import event.PersonalMg;
import event.PlantaMg;
import event.ProductoMg;
import event.ViveroMg;
import event.ZonaMg;
import event.ZonaPersonalMg;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class JFBuscar extends javax.swing.JFrame {
    OpCRUD op = new OpCRUD();
    /**
     * Creates new form JFBuscar
     */
    public JFBuscar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void mostrarResultado2() {
        TableModel tm;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        OpCRUD crud = new OpCRUD();
        String tabla, campo, crit;
        tabla = String.valueOf(cmbentidades.getSelectedItem());
        campo = String.valueOf(cmbcolumna.getSelectedItem().toString());
        crit = txtcriterio.getText();
        
        List<Object> results = new ArrayList<Object>();
        if (crit.equals("")) {
            Query result = session.createQuery("SELECT c FROM "+tabla+" c");
            results = result.list();
            } else if(crud.isNumeric(crit)){
                Query result = session.createQuery("SELECT c FROM " + tabla + " c WHERE c." + campo + " = " + crit + "");
                results = result.list();
            }else{
                Query result = session.createQuery("SELECT c FROM " + tabla + " c WHERE c." + campo + " like '%" + crit + "%'");
                results = result.list();
            }
            if (results != null) {
                tm = crud.listtoTM(results, tabla);
                tbtconsulta.setModel(tm);
            }
            else{
            
                JOptionPane.showMessageDialog(null, "No hay registros que coincidan con la busqueda", "Error", JOptionPane.ERROR_MESSAGE);        
            }
    }
    public void buscareg() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String sentenc, tabla, campo, idsel;
        int i;
        tabla = String.valueOf(cmbentidades.getSelectedItem());
        i = tbtconsulta.getSelectedRow();
        idsel = String.valueOf(tbtconsulta.getValueAt(i, 0));
        campo = tbtconsulta.getColumnName(0);
        sentenc = "SELECT c FROM " + tabla + " c WHERE c." + campo + " = '" + idsel + "'";
        if (tabla.equals("Ambiente"))
        {    
            List<Ambiente> results = new ArrayList<Ambiente>();            
            Query result = session.createQuery(sentenc);
            results = result.list();
            for(Ambiente a : results){
            Ambiente ObjAmbiente= new Ambiente(a.getZona(), a.getHumedad(), a.getTemperatura(), a.getFechahr());
            JDAmbienteModificar ModAmb=new JDAmbienteModificar(ObjAmbiente,idsel);
            ModAmb.setVisible(true);    
            }
        }
        if (tabla.equals("Existencia"))
        {    
            List<Existencia> results = new ArrayList<Existencia>();
            Query result = session.createQuery(sentenc);
            results = result.list();
            for(Existencia a : results){
            Existencia ObjExistencia= new Existencia(a.getProducto(), a.getZona(), a.getCantidad());
            JDExistenciaModificar exi = new JDExistenciaModificar(ObjExistencia,idsel);
            exi.setVisible(true);    
            }
        }
        if (tabla.equals("Personal"))
        {    
            List<Personal> results = new ArrayList<Personal>();
            Query result = session.createQuery(sentenc);
            results = result.list();
            for(Personal a : results){
            Personal ObjPersonal= new Personal(a.getIne(), a.getFechaNac(), a.getTeléfono(), a.getNombre(), a.getDireccion());
            JDPersonalModificar exi = new JDPersonalModificar(ObjPersonal, idsel);
            exi.setVisible(true);    
            }
        }
        if (tabla.equals("Planta"))
        {    
            List<Planta> results = new ArrayList<Planta>();
            Query result = session.createQuery(sentenc);
            results = result.list();
            for(Planta a : results){
            Planta ObjPlanta= new Planta(a.getProducto(), a.getNombre(), a.getClima(), a.getHumedad(), a.getCuidadosEsp(), a.getLuz());
            JDPlantaModificar exi = new JDPlantaModificar(ObjPlanta, idsel);
            exi.setVisible(true);    
            }
        }
        if (tabla.equals("Producto"))
        {    
            List<Producto> results = new ArrayList<Producto>();
            Query result = session.createQuery(sentenc);
            results = result.list();
            for(Producto a : results){
            Producto ObjProducto = new Producto(a.getNombre(), a.getCategoría(), a.getPrecio());
            JDProductoModificar exi = new JDProductoModificar(ObjProducto, idsel);
            exi.setVisible(true);    
            }
        }
        if (tabla.equals("Vivero"))
        {    
            List<Vivero> results = new ArrayList<Vivero>();
            Query result = session.createQuery(sentenc);
            results = result.list();
            for(Vivero a : results){
            Vivero ObjVivero = new Vivero(a.getPersonal(), a.getNombre(), a.getTeléfono(), a.getDirección());
            JDViveroModificar exi = new JDViveroModificar(ObjVivero, idsel);
            exi.setVisible(true);    
            }
        }
        if (tabla.equals("Zona"))
        {    
            List<Zona> results = new ArrayList<Zona>();
            Query result = session.createQuery(sentenc);
            results = result.list();
            for(Zona a : results){
            Zona ObjZona = new Zona(a.getVivero(), a.getNombre(), a.getDescripción(), a.getSuperficie());
            JDZonaModificar exi = new JDZonaModificar(ObjZona, idsel);
            exi.setVisible(true);    
            }
        }
        if (tabla.equals("ZonaPersonal"))
        {    
            List<ZonaPersonal> results = new ArrayList<ZonaPersonal>();
            Query result = session.createQuery(sentenc);
            results = result.list();
            for(ZonaPersonal a : results){
            ZonaPersonal ObjZona = new ZonaPersonal(a.getFechahr_ini(), a.getFechahr_fin(), a.getPersonal(), a.getZona());
            JDZonaPersonalModificar exi = new JDZonaPersonalModificar(ObjZona, idsel);
            exi.setVisible(true);    
            }
        }
    }
    public void eliminareg() throws ParseException {
        String tabla, idsel;
        int i;
        tabla = String.valueOf(cmbentidades.getSelectedItem());
        i = tbtconsulta.getSelectedRow();
        idsel = String.valueOf(tbtconsulta.getValueAt(i, 0));
            if (tabla.equals("Ambiente"))
            {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (resp == 0) {
                        AmbienteMg a = new AmbienteMg();
                        a.deleteAmbiente(Integer.parseInt(idsel));
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
            if (tabla.equals("Existencia"))
            {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (resp == 0) {
                        ExistenciaMg e = new ExistenciaMg();
                        e.deleteExistencia(Integer.parseInt(idsel));
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
            if (tabla.equals("Personal"))
            {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (resp == 0) {
                        PersonalMg p = new PersonalMg();
                        p.deletePersonal(Integer.parseInt(idsel));
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
            if (tabla.equals("Planta"))
            {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (resp == 0) {
                        PlantaMg p = new PlantaMg();
                        p.deletePlanta(Integer.parseInt(idsel));
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
            if (tabla.equals("Producto"))
            {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (resp == 0) {
                        ProductoMg p = new ProductoMg();
                        p.deleteProducto(Integer.parseInt(idsel));
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
            if (tabla.equals("Vivero"))
            {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (resp == 0) {
                        ViveroMg v = new ViveroMg();
                        v.deleteVivero(Integer.parseInt(idsel));
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
            if (tabla.equals("Zona"))
            {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (resp == 0) {
                        ZonaMg z = new ZonaMg();
                        z.deleteZona(Integer.parseInt(idsel));
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
            if (tabla.equals("ZonaPersonal"))
            {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (resp == 0) {
                        ZonaPersonalMg z = new ZonaPersonalMg();
                        z.deleteZona(Integer.parseInt(idsel));
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    }
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
        jLabel1 = new javax.swing.JLabel();
        cmbentidades = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbcolumna = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtcriterio = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtconsulta = new javax.swing.JTable();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busqueda");

        jLabel1.setText("Buscar:");

        cmbentidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Ambiente", "Existencia", "Personal", "Planta", "Producto", "Vivero", "Zona", "ZonaPersonal" }));
        cmbentidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbentidadesItemStateChanged(evt);
            }
        });
        cmbentidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbentidadesActionPerformed(evt);
            }
        });

        jLabel2.setText("Por:");

        jLabel3.setText("Criterio:");

        txtcriterio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcriterioKeyTyped(evt);
            }
        });

        btnbuscar.setForeground(new java.awt.Color(51, 0, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbuscarMouseClicked(evt);
            }
        });
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tbtconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbtconsulta);

        jTabbedPane1.addTab("Resultados", jScrollPane1);

        btneditar.setForeground(new java.awt.Color(0, 0, 255));
        btneditar.setText("Editar");
        btneditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditarMouseClicked(evt);
            }
        });

        btneliminar.setForeground(new java.awt.Color(255, 0, 0));
        btneliminar.setText("Eliminar");
        btneliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneliminarMouseClicked(evt);
            }
        });
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setForeground(new java.awt.Color(153, 0, 51));
        btnsalir.setText("Salir");
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbentidades, 0, 118, Short.MAX_VALUE)
                                    .addComponent(cmbcolumna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel3)
                            .addComponent(txtcriterio)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnbuscar)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btneditar)
                        .addGap(61, 61, 61)
                        .addComponent(btneliminar)
                        .addGap(209, 209, 209)
                        .addComponent(btnsalir))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbentidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbcolumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtcriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneditar)
                    .addComponent(btneliminar)
                    .addComponent(btnsalir))
                .addContainerGap(52, Short.MAX_VALUE))
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

    private void btnsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnsalirMouseClicked

    private void cmbentidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbentidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbentidadesActionPerformed

    private void btnbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscarMouseClicked
        // TODO add your handling code here:
        mostrarResultado2();
    }//GEN-LAST:event_btnbuscarMouseClicked

    private void btneditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditarMouseClicked
        // TODO add your handling code here:
        buscareg();
    }//GEN-LAST:event_btneditarMouseClicked

    private void btneliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarMouseClicked
        try {
            // TODO add your handling code here:
            eliminareg();
        } catch (ParseException ex) {
            Logger.getLogger(JFBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btneliminarMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarActionPerformed

    private void cmbentidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbentidadesItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(cmbentidades.getSelectedItem().equals("Ambiente")){
                cmbcolumna.removeAllItems();
                cmbcolumna.addItem("humedad");
                cmbcolumna.addItem("temperatura");
                cmbcolumna.addItem("fechahr");
            }else if(cmbentidades.getSelectedItem().equals("Producto")){
                cmbcolumna.removeAllItems();
                cmbcolumna.addItem("idProducto");
                cmbcolumna.addItem("nombre");
                cmbcolumna.addItem("categoría");
                cmbcolumna.addItem("precio");
                cmbcolumna.addItem("existencia_total");
            }else if(cmbentidades.getSelectedItem().equals("Personal")){
                cmbcolumna.removeAllItems();
                cmbcolumna.addItem("idPersonal");
                cmbcolumna.addItem("ine");
                cmbcolumna.addItem("fecha_nac");
                cmbcolumna.addItem("teléfono");
                cmbcolumna.addItem("nombre");
                cmbcolumna.addItem("direccion");
            }else if(cmbentidades.getSelectedItem().equals("Existencia")){
                cmbcolumna.removeAllItems();
                cmbcolumna.addItem("cantidad");
            }else if(cmbentidades.getSelectedItem().equals("Planta")){
                cmbcolumna.removeAllItems();
                cmbcolumna.addItem("nombre");
                cmbcolumna.addItem("humedad");
                cmbcolumna.addItem("clima");
                cmbcolumna.addItem("cuidados_esp");
                cmbcolumna.addItem("luz");
            }else if(cmbentidades.getSelectedItem().equals("Vivero")){
                cmbcolumna.removeAllItems();
                cmbcolumna.addItem("idVivero");
                cmbcolumna.addItem("nombre");
                cmbcolumna.addItem("dirección");
                cmbcolumna.addItem("teléfono");
            }else if(cmbentidades.getSelectedItem().equals("Zona")){
                cmbcolumna.removeAllItems();
                cmbcolumna.addItem("nombre");
                cmbcolumna.addItem("descripción");
                cmbcolumna.addItem("superficie");
            }else if(cmbentidades.getSelectedItem().equals("ZonaPersonal")){
                cmbcolumna.removeAllItems();
                cmbcolumna.addItem("fechahr_ini");
                cmbcolumna.addItem("fechahr_fin");
            }
        }
    }//GEN-LAST:event_cmbentidadesItemStateChanged

    private void txtcriterioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcriterioKeyTyped

    }//GEN-LAST:event_txtcriterioKeyTyped

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(JFBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFBuscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cmbcolumna;
    private javax.swing.JComboBox cmbentidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbtconsulta;
    private javax.swing.JTextField txtcriterio;
    // End of variables declaration//GEN-END:variables
}
