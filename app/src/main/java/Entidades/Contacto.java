package Entidades;

public class Contacto {
    private int id;
    private String nombre;
    private String numero;
    private String organizacion;

    public Contacto(){

    }

    public Contacto(int id, String n, String np, String o){
        this.id = id;
        this.nombre = n;
        this.numero = np;
        this.organizacion = o;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
