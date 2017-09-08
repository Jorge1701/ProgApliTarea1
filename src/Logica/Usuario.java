package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Usuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaNac;
    private String imagen;
    private HashMap<String,Cliente> seguidores;
    
    public Usuario(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.seguidores = new HashMap();
    }

    public abstract String getTipo();
    public abstract DtUsuario getData();
    public abstract DtPerfilUsuario obtenerPerfil();
    
    public ArrayList<DtCliente> getSeguidores() {
        ArrayList<DtCliente> dtSeguidores = new ArrayList<>();
        
        Iterator i = this.seguidores.entrySet().iterator();
        while (i.hasNext()) {
            Cliente c = (Cliente) ((Map.Entry) i.next()).getValue();
            dtSeguidores.add(c.getData());
        }
        
        return dtSeguidores;
    }
    
    public void clienteMeDejoDeSeguir(Cliente c) {
        seguidores.remove(c.getNickname());
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(DtFecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }
    
     public void setSeguidores(HashMap<String,Cliente> seguidores) {
        this.seguidores = seguidores;
    }
     
    public String getNickname() {
        return this.nickname;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public DtFecha getFechaNac() {
        return this.fechaNac;
    }

    public void agregar(Cliente cliente){
        this.seguidores.put(cliente.getNickname(), cliente); 
    }
    
    public boolean meComenzoASeguir(Cliente cliente){
        if(seguidores.get(cliente.getNickname())!= null){
            return false;
        }
        seguidores.put(cliente.getNickname(), cliente);
        return true;
    }
    
    public boolean meDejoDeSeguir(Cliente cliente){
       if(seguidores.get(cliente.getNickname())== null){
            return false;
        }
        seguidores.remove(cliente.getNickname());
        return true; 
    }
}
