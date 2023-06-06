/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.Producto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class ProductoMg {
    public void opCreateProducto(Producto per) {
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();
        //Crear obj paciente
            Producto p = per;
        //Almacenarlo
            session.save(p);
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Producto almacenado Id: "+ per.getIdProducto());
            
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Producto");
            exc.printStackTrace();
        }
    }
    public int countProducto() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
        session.beginTransaction();
        //Obtener valor max idpaciente
        Query result = session.createQuery("SELECT MAX(p.idProducto) FROM  Producto p");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Producto");
        return count;
    }
    public void updateProducto(Producto per, int id){
    Producto pac;
    try {
    //Obtener la sesión actual
    Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
    session.beginTransaction();
    Query result=session.createQuery("from Producto p where p.idProducto=:idpac");
       result.setParameter("idpac",id);
       pac=(Producto)result.uniqueResult();
       pac.setNombre(per.getNombre());
       pac.setCategoría(per.getCategoría());
       pac.setPrecio(per.getPrecio());
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Producto actualizado");
       session.close();
        }catch (Exception exc) {
            System.out.print("Error en actualización de objeto Producto");
            exc.printStackTrace();
        } 
    }
    
    public void deleteProducto(int idp){
    Producto pac;
    try {
    //Obtener la sesión actual
        Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
       session.beginTransaction();
       Query result=session.createQuery("from Producto p where p.idProducto=:idpac");
       result.setParameter("idpac",idp);
       pac=(Producto)result.uniqueResult();
       session.delete(pac);
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Producto eliminado");
       session.close();
     }catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Producto");
            exc.printStackTrace();
        } 
    }
    public List listidpro() {
        List result = null;
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();
        //Obtener la lista de ids
            result = session.createQuery("select a.idProducto from Producto a Order by a.idProducto asc").list();
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();

        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Producto");
            exc.printStackTrace();
        }        
        return result;
    }
}
