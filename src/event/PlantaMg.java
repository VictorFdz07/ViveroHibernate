/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.Planta;
import entity.Producto;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vfern
 */
public class PlantaMg {
    public void guardaConsulta(String nom,String clim,Float hum,String cui,String luz, Integer med) {
        Producto aMed;
        Planta aCon;
        try {
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
            session.beginTransaction();        
        //Cargar producto por clave
            aMed = (Producto) session.get(Producto.class, med);
        //Crear obj consulta           
            aCon = new Planta(aMed, nom, clim, hum, cui, luz);
        //Almacenarlo
            session.save(aCon);
        //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Producto Planta Id: "+ aCon.getIdPlanta());
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Planta");
            exc.printStackTrace();
        }
    }
    public int countPlanta() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Comenzar la transacción
        session.beginTransaction();
        //Obtener valor max idpaciente
        Query result = session.createQuery("SELECT MAX(p.idPlanta) FROM  Planta p");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Planta");
        return count;
    }
    public void updatePlanta(Planta per, int id){
    Planta pac;
    try {
    //Obtener la sesión actual
    Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
    session.beginTransaction();
    Query result=session.createQuery("from Planta p where p.idPlanta=:idpac");
       result.setParameter("idpac",id);
       pac=(Planta)result.uniqueResult();
       pac.setNombre(per.getNombre());
       pac.setClima(per.getClima());
       pac.setCuidadosEsp(per.getCuidadosEsp());
       pac.setHumedad(per.getHumedad());
       pac.setLuz(per.getLuz());
       
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Producto actualizado");
       session.close();
        }catch (Exception exc) {
            System.out.print("Error en actualización de objeto Producto");
            exc.printStackTrace();
        } 
    }
    
    public void deletePlanta(int idp){
    Planta pac;
    try {
    //Obtener la sesión actual
        Session session = HibernateUtil.getSessionFactory().openSession();
    //Comenzar la transacción
       session.beginTransaction();
       Query result=session.createQuery("from Planta p where p.idPlanta=:idpac");
       result.setParameter("idpac",idp);
       pac=(Planta)result.uniqueResult();
       session.delete(pac);
       //Confirmar transacción
       session.getTransaction().commit();
       System.out.print("Objeto Planta eliminado");
       session.close();
     }catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Planta");
            exc.printStackTrace();
        } 
    }
}
