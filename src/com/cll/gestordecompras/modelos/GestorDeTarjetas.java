package com.cll.gestordecompras.modelos;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorDeTarjetas {
    private final Map<String, Tarjeta> tarjetas;

    public GestorDeTarjetas() {
        this.tarjetas = new HashMap<>();
    }

    // Guardar tarjeta en el hashmap
    public void registrarTarjeta(String id, String usuario, double cupo) {
        tarjetas.put(id, new Tarjeta(id, usuario, cupo));
    }

    // Check si la tarjeta existe, si existe procesa la compra.
    public boolean hacerCompra(String id, Double valor, String descripcion) {
        var tarjeta = tarjetas.get(id);
        if (tarjeta == null) return false;
        return tarjeta.procesarCompra(valor, descripcion);
    }

    // Obtener la lista de compras o transacciones, si no existe la tarjeta entrega lista vacia.
    public List<Compra> getTransacciones(String id) {
        var tarjeta = tarjetas.get(id);
        return tarjeta == null ? Collections.emptyList() : tarjeta.getTransacciones();
    }

    // Obtener saldo disponible en la tarjeta por id
    public double getSaldoDisponible (String id) {
        var tarjeta = tarjetas.get(id);
        return tarjeta == null ? 0 : tarjeta.getCupo() - tarjeta.getSaldo();
    }
}
