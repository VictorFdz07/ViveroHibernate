/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.Personal;
import entity.Zona;
import entity.ZonaPersonal;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class ZonaPersonalMg {
    public void guardaConsulta(Date ini, Date fin, Integer per, Integer zon) {
        Personal aMed;
        Zona aZon;
        ZonaPersonal aCon;
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();        
        //Cargar producto por clave
            aMed = (Personal) session.get(Personal.class, per);
            aZon = (Zona) session.get(Zona.class, zon);
        //Crear obj consulta           
            aCon = new ZonaPersonal(ini, fin, aMed, aZon);
        //Almacenarlo
            session.save(aCon);
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto ZonaPersonal Id: "+ aCon.getIdzona_personal());
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto ZonaPersonal");
            exc.printStackTrace();
        }
    }
    public int countZona() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
        session.beginTransaction();
        //Obtener valor max idpaciente
        Query result = session.createQuery("SELECT MAX(p.idzona_personal) FROM  ZonaPersonal p");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " ZonaPersonal");
        return count;
    }
    public void deleteZona(int idp){
    ZonaPersonal pac;
    try {
    //Obtener la sesión actual
        Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
       session.beginTransaction();
       Query result=session.createQuery("from ZonaPersonal p where p.idzona_personal=:idpac");
       result.setParameter("idpac",idp);
       pac=(ZonaPersonal)result.uniqueResult();
       session.delete(pac);
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto ZonaPersonal eliminado");
       session.close();
     }catch (Exception exc) {
            System.out.print("Error en eliminación de objeto ZonaPersonal");
            exc.printStackTrace();
        } 
    }
    public void updateExistencia(ZonaPersonal per, int id){
    ZonaPersonal pac;
    try {
    //Obtener la sesión actual
    Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
    session.beginTransaction();
    Query result=session.createQuery("from ZonaPersonal p where p.idzona_personal=:idpac");
       result.setParameter("idpac",id);
       pac=(ZonaPersonal)result.uniqueResult();
       pac.setFechahr_fin(per.getFechahr_fin());
       pac.setFechahr_ini(per.getFechahr_ini());
       pac.setPersonal(per.getPersonal());
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
