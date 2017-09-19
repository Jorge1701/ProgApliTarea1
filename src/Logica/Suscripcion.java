package Logica;

public class Suscripcion {

    private String estado;
    private String cuota;
    private DtFecha fecha_venc;
    private int monto;

    public Suscripcion(String estado, String cuota, DtFecha fecha_venc, int monto) {
        this.estado = estado;
        this.cuota = cuota;
        this.fecha_venc = fecha_venc;
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
        return new DtSuscripcion(getEstado(), getCuota(), getFechaVenc(), getMonto());
    }

}
