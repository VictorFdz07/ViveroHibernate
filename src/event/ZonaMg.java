/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.Vivero;
import entity.Zona;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class ZonaMg {
   public void guardaConsulta(String nom, String des, Float sup, Integer med) {
        Vivero aMed;
        Zona aCon;
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();        
        //Cargar producto por clave
            aMed = (Vivero) session.get(Vivero.class, med);
        //Crear obj consulta           
            aCon = new Zona(aMed, nom, des, sup);
        //Almacenarlo
            session.save(aCon);
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Zona Id: "+ aCon.getIdZona());
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Zona");
            exc.printStackTrace();
        }
    } 
    public int countZona() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
        session.beginTransaction();
        //Obtener valor max idpaciente
        Query result = session.createQuery("SELECT MAX(p.idZona) FROM  Zona p");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Zona");
        return count;
    }
    public List listidpro() {
        List result = null;
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();
        //Obtener la lista de ids
            result = session.createQuery("select a.idZona from Zona a Order by a.idZona asc").list();
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();

        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Zona");
            exc.printStackTrace();
        }        
        return result;
    }
    public void deleteZona(int idp){
    Zona pac;
    try {
    //Obtener la sesión actual
        Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
       session.beginTransaction();
       Query result=session.createQuery("from Zona p where p.idZona=:idpac");
       result.setParameter("idpac",idp);
       pac=(Zona)result.uniqueResult();
       session.delete(pac);
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Zona eliminado");
       session.close();
     }catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Zona");
            exc.printStackTrace();
        } 
    }
    public void updateZona(Zona per, int id){
    Zona pac;
    try {
    //Obtener la sesión actual
    Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
    session.beginTransaction();
    Query result=session.createQuery("from Zona p where p.idZona=:idpac");
       result.setParameter("idpac",id);
       pac=(Zona)result.uniqueResult();
       pac.setDescripción(per.getDescripción());
       pac.setNombre(per.getNombre());
       pac.setSuperficie(per.getSuperficie());
       pac.setVivero(per.getVivero());
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Zona actualizado");
       session.close();
        }catch (Exception exc) {
            System.out.print("Error en actualización de objeto Zona");
            exc.printStackTrace();
        } 
    }
}
