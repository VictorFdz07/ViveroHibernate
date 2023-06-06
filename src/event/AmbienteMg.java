/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.Ambiente;
import entity.Vivero;
import entity.Zona;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class AmbienteMg {
    public void guardaConsulta(float hum, float tem, Date fecha, Integer med) {
        Zona aMed;
        Ambiente aCon;
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();        
        //Cargar producto por clave
            aMed = (Zona) session.get(Zona.class, med);
        //Crear obj consulta           
            aCon = new Ambiente(aMed, hum, tem, fecha);
        //Almacenarlo
            session.save(aCon);
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Ambiente Id: "+ aCon.getIdAmbiente());
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Ambiente");
            exc.printStackTrace();
        }
    }
    public int countAmbiente() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
        session.beginTransaction();
        //Obtener valor max idpaciente
        Query result = session.createQuery("SELECT MAX(p.idAmbiente) FROM  Ambiente p");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Ambiente");
        return count;
    }
    public void deleteAmbiente(int idp){
    Ambiente pac;
    try {
    //Obtener la sesión actual
        Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
       session.beginTransaction();
       Query result=session.createQuery("from Ambiente p where p.idAmbiente=:idpac");
       result.setParameter("idpac",idp);
       pac=(Ambiente)result.uniqueResult();
       session.delete(pac);
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Ambiente eliminado");
       session.close();
     }catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Ambiente");
            exc.printStackTrace();
        } 
    }
    public void updatePersonal(Ambiente per, int id){
    Ambiente pac;
    try {
    //Obtener la sesión actual
    Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
    session.beginTransaction();
    Query result=session.createQuery("from Ambiente p where p.idAmbiente=:idpac");
       result.setParameter("idpac",id);
       pac=(Ambiente)result.uniqueResult();
       pac.setTemperatura(per.getTemperatura());
       pac.setFechahr(per.getFechahr());
       pac.setHumedad(per.getHumedad());
       pac.setZona(per.getZona());
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Personal actualizado");
       session.close();
        }catch (Exception exc) {
            System.out.print("Error en actualización de objeto Personal");
            exc.printStackTrace();
        }
    }
}
