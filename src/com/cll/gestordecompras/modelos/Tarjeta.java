package com.cll.gestordecompras.modelos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tarjeta {
    private final int id;
    private String usuario;
    private double cupo;
    private double saldo;
    private List<Compra> transacciones;

    public Tarjeta(int id, String usuario, double cupo) {
        this.id = id;
        this.usuario = usuario;
        this.cupo = cupo;
        this.saldo = cupo;
        this.transacciones = new ArrayList<>();
    }

    // Chequea si existe cupo suficiente, crea la compra, la añade a la lista y actualiza saldo
    public boolean procesarCompra(double valorCompra, String descripcion ){
        if (this.getSaldo() - valorCompra < 0) {
            return false;
        } else {
            Compra nuevaCompra = new Compra(valorCompra, descripcion);
            this.transacciones.add(nuevaCompra);
            this.saldo -= valorCompra;
            return true;
        }
    }

    public void ordenarListaDeCompras() {
        this.transacciones.sort(Comparator.comparing(Compra::getValor));
    }

    public double getCupo() {
        return cupo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public List<Compra> getTransacciones() {
        return transacciones;
    }
}
