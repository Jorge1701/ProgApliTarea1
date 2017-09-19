package Logica;

public class DtSuscripcion {

    private final String estado;
    private final String cuota;
    private final DtFecha fecha_venc;
    private final int monto;
    
     public DtSuscripcion(String estado, String cuota, DtFecha fecha_venc, int monto) {
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
}
