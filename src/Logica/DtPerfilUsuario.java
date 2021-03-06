package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtPerfilUsuario")
public class DtPerfilUsuario {
    
    public DtUsuario info;
    public ArrayList<DtCliente> seguidores;

    public DtPerfilUsuario(DtUsuario info, ArrayList<DtCliente> seguidores) {
        this.info = info;
        this.seguidores = seguidores;
    }

    public DtUsuario getInfo() {
        return info;
    }

    public ArrayList<DtCliente> getSeguidores() {
        return seguidores;
    }
}
