package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtListaUsuarios")
public class DtListaUsuarios {

    private ArrayList<DtUsuario> usuarios;

    public DtListaUsuarios() {
        this.usuarios = null;
    }

    public DtListaUsuarios(ArrayList<DtUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<DtUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<DtUsuario> usuarios) {
        this.usuarios = usuarios;
    }

}
