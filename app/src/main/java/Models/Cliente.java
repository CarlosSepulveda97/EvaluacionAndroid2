package Models;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String nombre;
    private int saldo;

    public Cliente(String nombre, int saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
