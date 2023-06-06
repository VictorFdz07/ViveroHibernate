package entity;
// Generated 12/11/2021 10:32:51 AM by Hibernate Tools 4.3.1



/**
 * Planta generated by hbm2java
 */
public class Planta  implements java.io.Serializable {


     private Integer idPlanta;
     private Producto producto;
     private String nombre;
     private String clima;
     private float humedad;
     private String cuidadosEsp;
     private String luz;

    public Planta() {
    }

    public Planta(Producto producto, String nombre, String clima, float humedad, String cuidadosEsp, String luz) {
       this.producto = producto;
       this.nombre = nombre;
       this.clima = clima;
       this.humedad = humedad;
       this.cuidadosEsp = cuidadosEsp;
       this.luz = luz;
    }
   
    public Integer getIdPlanta() {
        return this.idPlanta;
    }
    
    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClima() {
        return this.clima;
    }
    
    public void setClima(String clima) {
        this.clima = clima;
    }
    public float getHumedad() {
        return this.humedad;
    }
    
    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }
    public String getCuidadosEsp() {
        return this.cuidadosEsp;
    }
    
    public void setCuidadosEsp(String cuidadosEsp) {
        this.cuidadosEsp = cuidadosEsp;
    }
    public String getLuz() {
        return this.luz;
    }
    
    public void setLuz(String luz) {
        this.luz = luz;
    }




}


