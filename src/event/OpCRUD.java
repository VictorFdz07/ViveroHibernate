/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import entity.Ambiente;
import entity.Existencia;
import entity.Personal;
import entity.Planta;
import entity.Producto;
import entity.Vivero;
import entity.Zona;
import entity.ZonaPersonal;
/**
 *
 * @author vfern
 */
public class OpCRUD {
    public TableModel listtoTM(List rs, String entit) {
        Vector columnNames = new Vector();
        Vector rows = new Vector();
        
        // Nombres de campos
        if (entit.equals("Ambiente")) {
            Ambiente a;
            columnNames.addElement("idAmbiente");
            columnNames.addElement("Humedad");
            columnNames.addElement("Temperatura");
            columnNames.addElement("Fecha");
            columnNames.addElement("Zona");

            Iterator it = rs.iterator();
            while (it.hasNext()) {
                a = (Ambiente) it.next();
                Vector newRow = new Vector();
                newRow.addElement(a.getIdAmbiente());
                newRow.addElement(a.getHumedad());
                newRow.addElement(a.getTemperatura());
                newRow.addElement(a.getFechahr());
                newRow.addElement(a.getZona());
                rows.addElement(newRow);
            }
        }
        if(entit.equals("Producto")){
            Producto p;
            columnNames.addElement("idProducto");
            columnNames.addElement("Nombre");
            columnNames.addElement("Categoria");
            columnNames.addElement("Precio");
            columnNames.addElement("Existenciat");
            
            Iterator it = rs.iterator();
            while (it.hasNext()) {
                p = (Producto) it.next();
                Vector newRow = new Vector();
                newRow.addElement(p.getIdProducto());
                newRow.addElement(p.getNombre());
                newRow.addElement(p.getCategoría());
                newRow.addElement(p.getPrecio());
                newRow.addElement(p.getExistenciaTotal());
                //newRow.addElement(a.getAmb_zon());
                rows.addElement(newRow);
            }
        }if(entit.equals("Existencia")){
            Existencia p;
            columnNames.addElement("idExistencia");
            columnNames.addElement("Cantidad");
            columnNames.addElement("Zona");
            columnNames.addElement("Producto");
            
            Iterator it = rs.iterator();
            while (it.hasNext()) {
                p = (Existencia) it.next();
                Vector newRow = new Vector();
                newRow.addElement(p.getIdExistencia());
                newRow.addElement(p.getCantidad());
                newRow.addElement(p.getZona());                
                newRow.addElement(p.getProducto());
                //newRow.addElement(a.getAmb_zon());
                rows.addElement(newRow);
            }
        }
        if(entit.equals("Personal")){
            Personal p;
            columnNames.addElement("idPersonal");
            columnNames.addElement("INE");
            columnNames.addElement("Nombre");
            columnNames.addElement("Telefono");
            columnNames.addElement("Direccion");
            columnNames.addElement("Fecha nacimiento");
            
            Iterator it = rs.iterator();
            while (it.hasNext()) {
                p = (Personal) it.next();
                Vector newRow = new Vector();
                newRow.addElement(p.getIdPersonal());
                newRow.addElement(p.getIne());
                newRow.addElement(p.getNombre());
                newRow.addElement(p.getTeléfono());
                newRow.addElement(p.getDireccion());
                newRow.addElement(p.getFechaNac());
                //newRow.addElement(a.getAmb_zon());
                rows.addElement(newRow);
            }
        }
        if(entit.equals("Planta")){
            Planta p;
            columnNames.addElement("idPlanta");
            columnNames.addElement("Nombre");
            columnNames.addElement("Clima");
            columnNames.addElement("Humedad");
            columnNames.addElement("Cuidados");
            columnNames.addElement("Luz");
            
            Iterator it = rs.iterator();
            while (it.hasNext()) {
                p = (Planta) it.next();
                Vector newRow = new Vector();
                newRow.addElement(p.getIdPlanta());
                newRow.addElement(p.getNombre());
                newRow.addElement(p.getClima());
                newRow.addElement(p.getHumedad());
                newRow.addElement(p.getCuidadosEsp());
                newRow.addElement(p.getLuz());
                //newRow.addElement(a.getAmb_zon());
                rows.addElement(newRow);
            }
        }
        if(entit.equals("Vivero")){
            Vivero p;
            columnNames.addElement("idVivero");
            columnNames.addElement("Nombre");
            columnNames.addElement("Telefono");
            columnNames.addElement("Direccion");
            
            Iterator it = rs.iterator();
            while (it.hasNext()) {
                p = (Vivero) it.next();
                Vector newRow = new Vector();
                newRow.addElement(p.getIdVivero());
                newRow.addElement(p.getNombre());
                newRow.addElement(p.getTeléfono());
                newRow.addElement(p.getDirección());
                //newRow.addElement(a.getAmb_zon());
                rows.addElement(newRow);
            }
        }
        if(entit.equals("Zona")){
            Zona p;
            columnNames.addElement("idZona");
            columnNames.addElement("Nombre");
            columnNames.addElement("Descripcion");
            columnNames.addElement("Superficie");
            
            Iterator it = rs.iterator();
            while (it.hasNext()) {
                p = (Zona) it.next();
                Vector newRow = new Vector();
                newRow.addElement(p.getIdZona());
                newRow.addElement(p.getNombre());
                newRow.addElement(p.getDescripción());
                newRow.addElement(p.getSuperficie());
                //newRow.addElement(a.getAmb_zon());
                rows.addElement(newRow);
            }
        }
        if(entit.equals("ZonaPersonal")){
            ZonaPersonal p;
            columnNames.addElement("idzona_personal");
            columnNames.addElement("Fecha inicio");
            columnNames.addElement("Fecha fin");
            
            Iterator it = rs.iterator();
            while (it.hasNext()) {
                p = (ZonaPersonal) it.next();
                Vector newRow = new Vector();
                newRow.addElement(p.getIdzona_personal());
                newRow.addElement(p.getFechahr_ini());
                newRow.addElement(p.getFechahr_fin());
                //newRow.addElement(a.getAmb_zon());
                rows.addElement(newRow);
            }
        }
        return new DefaultTableModel(rows, columnNames);
    }
    public boolean isNumeric(String str)
    {
      try
      {
          double d = Double.parseDouble(str);
      }
      catch(NumberFormatException nfe)
      {  
          return false;
      }
      return true;
    }
}
