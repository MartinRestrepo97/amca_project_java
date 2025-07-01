package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa la entidad Cultivo en el sistema AMCA.
 * Contiene información sobre cultivos agrícolas incluyendo nombre y extensión.
 * 
 * @author AMCA Development Team
 * @version 1.0
 * @since 2024
 */
public class Cultivos {
    
    /** Identificador único del cultivo */
    private int id;
    
    /** Nombre del cultivo */
    private String nombre;
    
    /** Extensión del cultivo en hectáreas */
    private int extended;
    
    /**
     * Constructor por defecto.
     */
    public Cultivos() {
        this.id = 0;
        this.nombre = "";
        this.extended = 0;
    }
    
    /**
     * Constructor con parámetros.
     * 
     * @param nombre Nombre del cultivo
     * @param extended Extensión en hectáreas
     */
    public Cultivos(String nombre, int extended) {
        this.nombre = nombre != null ? nombre.trim() : "";
        this.extended = Math.max(0, extended);
    }
    
    // Getters y Setters con validación
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = Math.max(0, id);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : "";
    }
    
    public int getExtended() {
        return extended;
    }
    
    public void setExtended(int extended) {
        this.extended = Math.max(0, extended);
    }
    
    /**
     * Obtiene la lista de cultivos de ejemplo.
     * 
     * @return Lista de cultivos predefinidos
     */
    public static List<Cultivos> obtenerListaCultivos() {
        List<Cultivos> cultivos = new ArrayList<>();
        
        cultivos.add(new Cultivos("Papa", 3));
        cultivos.add(new Cultivos("Cebolla", 5));
        cultivos.add(new Cultivos("Zanahoria", 6));
        cultivos.add(new Cultivos("Tomate", 4));
        cultivos.add(new Cultivos("Lechuga", 2));
        
        return cultivos;
    }
    
    /**
     * Valida si el cultivo tiene datos válidos.
     * 
     * @return true si los datos son válidos, false en caso contrario
     */
    public boolean esValido() {
        return nombre != null && !nombre.trim().isEmpty() && extended > 0;
    }
    
    @Override
    public String toString() {
        return String.format("Cultivo{id=%d, nombre='%s', extended=%d}", 
                           id, nombre, extended);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Cultivos cultivos = (Cultivos) obj;
        return id == cultivos.id && 
               extended == cultivos.extended && 
               nombre.equals(cultivos.nombre);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + nombre.hashCode();
        result = 31 * result + extended;
        return result;
    }
}
