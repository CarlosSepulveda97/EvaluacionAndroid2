package Models;

import java.io.Serializable;

public class Prestamo implements Serializable {

    private String nombrePrestamo;
    private int valorPrestamo;
    private int cuotas;

    public Prestamo(String nombrePrestamo, int valorPrestamo, int cuotas) {
        this.nombrePrestamo = nombrePrestamo;
        this.valorPrestamo = valorPrestamo;
        this.cuotas = cuotas;
    }

    public String getNombrePrestamo() {
        return nombrePrestamo;
    }

    public void setNombrePrestamo(String nombrePrestamo) {
        this.nombrePrestamo = nombrePrestamo;
    }

    public int getValorPrestamo() {
        return valorPrestamo;
    }

    public void setValorPrestamo(int valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }
}
