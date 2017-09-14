package Logica;

public class Suscripcion {

    private String estado;
    private String cuota;
    private DtFecha fecha_venc;

    public Suscripcion(String estado, String cuota, DtFecha fecha_venc) {
        this.estado=estado;
        this.cuota=cuota;
        this.fecha_venc=fecha_venc;
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public void setFecha_venc(DtFecha fecha_venc) {
        this.fecha_venc = fecha_venc;
    }
    
    
}
