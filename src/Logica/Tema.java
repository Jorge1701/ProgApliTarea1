package Logica;



public class Tema {

    private Album a;
    private String nombre;
    private DtTime duracion;
    private int ubicacion;
    private int id;



    public Tema(Album a, String nombre, DtTime duracion, int ubicacion) {
        this.a = a;
        this.nombre = nombre;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
    }
    
    public Tema(String nombre, DtTime duracion, int ubicacion) {
        this(null, nombre, duracion, ubicacion);
    }

    public Album getAlbum() {
        return a;
    }

    public void setAlbum(Album a) {
        this.a = a;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public DtTema getData() {
        return new DtTema(nombre, duracion, ubicacion);
    }

    public String getNombre() {
        return nombre;
    }

    public DtTime getDuracion() {
        return duracion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(DtTime duracion) {
        this.duracion = duracion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
}
