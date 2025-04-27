package com.cll.gestordecompras.modelos;

import java.time.LocalDateTime;

public class Compra {
    private double valor;
    private String descripcion;
    private LocalDateTime fecha;

    public Compra(double valorCompra, String descripcion) {
        this.valor = valorCompra;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
    }

    public double getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return String.format(getFecha() + " | " + getDescripcion() + ": " + getValor());
    }
}
