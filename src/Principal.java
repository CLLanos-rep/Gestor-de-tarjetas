import com.cll.gestordecompras.modelos.Compra;
import com.cll.gestordecompras.modelos.Tarjeta;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String idTarjeta = "123456789";
        String usuarioTarjeta = "Nobody";
        double limiteDeTarjeta;
        String descripcion;
        double valor;
        boolean continuar = true;
        var input = new Scanner(System.in);

        System.out.println("Escriba el limite de la tarjeta: ");
        limiteDeTarjeta = Double.parseDouble(input.next());
        var tarjeta = new Tarjeta(idTarjeta, usuarioTarjeta, limiteDeTarjeta);

        while (continuar) {
            System.out.println("Escriba la descripción de la compra: ");
            descripcion = input.next();

            System.out.println("Escriba el valor de la compra: ");
            valor = Double.parseDouble(input.next());

            if (tarjeta.procesarCompra(valor, descripcion)) {
                // Ordenar las compras por valor de menor a mayor
                tarjeta.ordenarListaDeCompras();

                System.out.println("Compra realizada!");
                System.out.println("Escriba cualquier tecla para salir o 1 para realizar otra compra");

                continuar = input.next().equals("1");

            } else {
                System.out.println("Saldo insuficiente!");
                continuar = false;
            }
        }

        // MOSTRAR LAS COMPRAS REALIZADAS
        System.out.println("*******************************");
        System.out.println("Compras Realizadas");
        for (Compra compra:tarjeta.getTransacciones()) {
            System.out.println(compra.getDescripcion() + " - " + compra.getValor());
        }
        System.out.println("*******************************");
        System.out.println("Saldo de la tarjeta: " + tarjeta.getSaldo());
        System.out.println("Cupo de la tarjeta: " + tarjeta.getCupo());
    }
}
