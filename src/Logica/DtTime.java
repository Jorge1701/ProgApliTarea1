package Logica;

public class DtTime {
    
    private int horas;
    private int minutos;
    private int segundos;

    public DtTime(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }
    
    @Override
    public String toString() {
        return this.horas + ":" + this.minutos + ":" + this.segundos;
    }
}
