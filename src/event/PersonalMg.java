/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.Personal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class PersonalMg {

    public void opCreatePersonal(Personal per) {
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();
        //Crear obj paciente
            Personal p = per;
        //Almacenarlo
            session.save(p);
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Personal almacenado Id: " +per.getIdPersonal());
            
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Personal");
            exc.printStackTrace();
        }
    }

    public int countPersonal() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
        session.beginTransaction();
        //Obtener valor max idpaciente
        Query result = session.createQuery("SELECT MAX(p.idPersonal) FROM  Personal p");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Pacientes");
        return count;
    }
    
    public void updatePersonal(Personal per, int id){
    Personal pac;
    try {
    //Obtener la sesión actual
    Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
    session.beginTransaction();
    Query result=session.createQuery("from Personal p where p.idPersonal=:idpac");
       result.setParameter("idpac",id);
       pac=(Personal)result.uniqueResult();
       pac.setNombre(per.getNombre());
       pac.setDireccion(per.getDireccion());
       pac.setFechaNac(per.getFechaNac());
       pac.setIne(per.getIne());
       pac.setTeléfono(per.getTeléfono());
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Personal actualizado");
       session.close();
        }catch (Exception exc) {
            System.out.print("Error en actualización de objeto Personal");
            exc.printStackTrace();
        } 
    }
    
    public void deletePersonal(int idp){
    Personal pac;
    try {
    //Obtener la sesión actual
        Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
       session.beginTransaction();
       Query result=session.createQuery("from Personal p where p.idPersonal=:idpac");
       result.setParameter("idpac",idp);
       pac=(Personal)result.uniqueResult();
       session.delete(pac);
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Personal eliminado");
       session.close();
     }catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Personal");
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
            result = session.createQuery("select a.idPersonal from Personal a Order by a.idPersonal asc").list();
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();

        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Personal");
            exc.printStackTrace();
        }        
        return result;
    }
}
