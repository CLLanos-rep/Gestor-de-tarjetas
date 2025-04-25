package com.cll.gestordecompras.modelos;

public class Tarjeta {
    private int id;
    private String usuario;
    private int bin;
    private double cupo;
    private double saldo;

    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {
        this.cupo = cupo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void actualizarSaldo(double compra) {
        this.saldo -= compra;
    }

}
