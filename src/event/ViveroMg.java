/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;


import entity.Personal;
import entity.Vivero;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class ViveroMg {
    public void guardaConsulta(String nom, String tel, String dir, Integer med) {
        Personal aMed;
        Vivero aCon;
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();        
        //Cargar producto por clave
            aMed = (Personal) session.get(Personal.class, med);
        //Crear obj consulta           
            aCon = new Vivero(aMed, nom, tel, dir);
        //Almacenarlo
            session.save(aCon);
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Vivero Id: "+ aCon.getIdVivero());
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Vivero");
            exc.printStackTrace();
        }
    }
    public int countVivero() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
        session.beginTransaction();
        //Obtener valor max idpaciente
        Query result = session.createQuery("SELECT MAX(p.idVivero) FROM  Vivero p");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Vivero");
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
            result = session.createQuery("select a.idVivero from Vivero a Order by a.idVivero asc").list();
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();

        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Vivero");
            exc.printStackTrace();
        }        
        return result;
    }
    public void deleteVivero(int idp){
    Vivero pac;
    try {
    //Obtener la sesión actual
        Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
       session.beginTransaction();
       Query result=session.createQuery("from Vivero p where p.idVivero=:idpac");
       result.setParameter("idpac",idp);
       pac=(Vivero)result.uniqueResult();
       session.delete(pac);
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Vivero eliminado");
       session.close();
     }catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Vivero");
            exc.printStackTrace();
        } 
    }
    public void updatePersonal(Vivero per, int id){
    Vivero pac;
    try {
    //Obtener la sesión actual
    Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
    session.beginTransaction();
    Query result=session.createQuery("from Vivero p where p.idVivero=:idpac");
       result.setParameter("idpac",id);
       pac=(Vivero)result.uniqueResult();
       pac.setNombre(per.getNombre());
       pac.setDirección(per.getDirección());
       pac.setTeléfono(per.getTeléfono());
       pac.setPersonal(per.getPersonal());
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Vivero actualizado");
       session.close();
        }catch (Exception exc) {
            System.out.print("Error en actualización de objeto Vivero");
            exc.printStackTrace();
        } 
    }
}
