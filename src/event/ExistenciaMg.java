/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.Existencia;
import entity.Producto;
import entity.Zona;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class ExistenciaMg {
    public void guardaConsulta(int can, Integer med, Integer pr) {
        Zona aMed;
        Producto aPro;
        Existencia aCon;
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();        
        //Cargar producto por clave
            aMed = (Zona) session.get(Zona.class, med);
            aPro = (Producto) session.get(Producto.class, pr);
        //Crear obj consulta           
            aCon = new Existencia(aPro, aMed, can);
        //Almacenarlo
            session.save(aCon);
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Existencia Id: "+ aCon.getIdExistencia());
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Existencia");
            exc.printStackTrace();
        }
    }
    public int countExistencia() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
        session.beginTransaction();
        //Obtener valor max idpaciente
        Query result = session.createQuery("SELECT MAX(p.idExistencia) FROM  Existencia p");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Existencia");
        return count;
    }
    public void deleteExistencia(int idp){
    Existencia pac;
    try {
    //Obtener la sesión actual
        Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
       session.beginTransaction();
       Query result=session.createQuery("from Existencia p where p.idExistencia=:idpac");
       result.setParameter("idpac",idp);
       pac=(Existencia)result.uniqueResult();
       session.delete(pac);
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Existencia eliminado");
       session.close();
     }catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Existencia");
            exc.printStackTrace();
        } 
    }
    public void updateExistencia(Existencia per, int id){
    Existencia pac;
    try {
    //Obtener la sesión actual
    Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
    session.beginTransaction();
    Query result=session.createQuery("from Existencia p where p.idExistencia=:idpac");
       result.setParameter("idpac",id);
       pac=(Existencia)result.uniqueResult();
       pac.setCantidad(per.getCantidad());
       pac.setProducto(per.getProducto());
       pac.setZona(per.getZona());
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Existencia actualizado");
       session.close();
        }catch (Exception exc) {
            System.out.print("Error en actualización de objeto Existencia");
            exc.printStackTrace();
        }
    }
}
