/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;


public class ZonaPersonal implements java.io.Serializable {
    
    private Integer idzona_personal;
    private Date fechahr_ini;
    private Date fechahr_fin;
    private Personal personal;
    private Zona zona;
    
    
    public ZonaPersonal() {
    }

    public ZonaPersonal(Date fechahr_ini, Date fechahr_fin, Personal personal, Zona zona) {
        this.fechahr_ini = fechahr_ini;
        this.fechahr_fin = fechahr_fin;
        this.personal = personal;
        this.zona = zona;
    }

    public Integer getIdzona_personal() {
        return idzona_personal;
    }

    public void setIdzona_personal(Integer idzona_personal) {
        this.idzona_personal = idzona_personal;
    }

    public Date getFechahr_ini() {
        return fechahr_ini;
    }

    public void setFechahr_ini(Date fechahr_ini) {
        this.fechahr_ini = fechahr_ini;
    }

    public Date getFechahr_fin() {
        return fechahr_fin;
    }

    public void setFechahr_fin(Date fechahr_fin) {
        this.fechahr_fin = fechahr_fin;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    
    
    
}
