package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Suscripcion {

    private String estado;
    private String cuota;
    private DtFecha fecha_venc;
    private DtFecha fecha;
    private int monto;

    public Suscripcion(String estado, String cuota, DtFecha fecha_venc, DtFecha fecha, int monto) {
        this.estado = estado;
        this.cuota = cuota;
        this.fecha_venc = fecha_venc;
        this.monto = monto;
        this.fecha = fecha;
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

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public void setFecha_venc(DtFecha fecha_venc) {
        this.fecha_venc = fecha_venc;
    }

    public DtSuscripcion getData() {
        return new DtSuscripcion(getEstado(), getCuota(), getFechaVenc(), getFecha(), getMonto());
    }

}
