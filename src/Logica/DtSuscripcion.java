package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtSuscripcion")
public class DtSuscripcion {

    private final String estado;
    private final String cuota;
    private final DtFecha fecha_venc;
    private final DtFecha fecha;
    private final int monto;

    public DtSuscripcion(String estado, String cuota, DtFecha fecha_venc, DtFecha fecha, int monto) {
        this.estado = estado;
        this.cuota = cuota;
        this.fecha_venc = fecha_venc;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public String getCuota() {
        return cuota;
    }

    public DtFecha getFechaVenc() {
        return fecha_venc;
    }

    public int getMonto() {
        return monto;
    }

    public DtFecha getFecha() {
        return fecha;
    }
}
