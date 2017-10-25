package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtUsuario")
@XmlSeeAlso({DtCliente.class, DtArtista.class})
public class DtUsuario {

    //@XmlElement(name = "nickname")
    protected String nickname;
    //@XmlElement(name = "nombre")
    protected String nombre;
    //@XmlElement(name = "apellido")
    protected String apellido;
    //@XmlElement(name = "email")
    protected String email;
    //@XmlElement(name = "fechaNac")
    protected DtFecha fechaNac;
    //@XmlElement(name = "imagen")
    protected String imagen;
    //@XmlElement(name = "contrasenia")
    protected String contrasenia;

    public DtUsuario(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String contrasenia) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.contrasenia = contrasenia;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public DtFecha getFechaNac() {
        return fechaNac;
    }

    public String getImagen() {
        return imagen;
    }

    public String getContrasenia() {
        return contrasenia;
    }

}
