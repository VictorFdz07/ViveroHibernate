package entity;
// Generated 12/11/2021 10:32:51 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Integer idProducto;
     private String nombre;
     private String categoría;
     private float precio;
     private Integer existenciaTotal;
     private Set plantas = new HashSet(0);
     private Set existencias = new HashSet(0);

    public Producto() {
    }
    
	
    public Producto(String nombre, String categoría, float precio) {
        this.nombre = nombre;
        this.categoría = categoría;
        this.precio = precio;
    }
    public Producto(String nombre, String categoría, float precio, Integer existenciaTotal, Set plantas, Set existencias) {
       this.nombre = nombre;
       this.categoría = categoría;
       this.precio = precio;
       this.existenciaTotal = existenciaTotal;
       this.plantas = plantas;
       this.existencias = existencias;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Integer getExistenciaTotal() {
        return existenciaTotal;
    }

    public void setExistenciaTotal(Integer existenciaTotal) {
        this.existenciaTotal = existenciaTotal;
    }

    public Set getPlantas() {
        return plantas;
    }

    public void setPlantas(Set plantas) {
        this.plantas = plantas;
    }

    public Set getExistencias() {
        return existencias;
    }

    public void setExistencias(Set existencias) {
        this.existencias = existencias;
    }
    
    
}


