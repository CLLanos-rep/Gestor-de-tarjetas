import com.cll.gestordecompras.modelos.Compra;
import com.cll.gestordecompras.modelos.Tarjeta;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        var tarjeta = new Tarjeta();
        var input = new Scanner(System.in);
        double limiteDeTarjeta;
        String descripcion;
        int valor;
        var listaDeCompras = new ArrayList<Compra>();
        int aux = 1;

        System.out.println("Escriba el limite de la tarjeta: ");
        limiteDeTarjeta = input.nextDouble();
        tarjeta.setCupo(limiteDeTarjeta);
        tarjeta.setSaldo(tarjeta.getCupo());


        while (aux != 0) {
            var nuevaCompra = new Compra();
            System.out.println("Escriba la descripción de la compra: ");
            descripcion = input.next();
            nuevaCompra.setDescripcion(descripcion);

            System.out.println("Escriba el valor de la compra: ");
            valor = input.nextInt();
            nuevaCompra.setValor(valor);

            if (tarjeta.getSaldo() - nuevaCompra.getValor() >= 0) {
                tarjeta.actualizarSaldo(nuevaCompra.getValor());

                // Añadir a la lista la compra, la lista tiene metodo add
                listaDeCompras.add(nuevaCompra);

                // Ordenar las compras por valor de menor a mayor
                listaDeCompras.sort(Comparator.comparing(Compra::getValor));

                System.out.println("Compra realizada!");
                System.out.println("Escriba 0 para salir o 1 para realizar otra compra");
                aux = input.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                aux = 0;
            }
        }

        // MOSTRAR LAS COMPRAS REALIZADAS
        System.out.println("*******************************");
        System.out.println("Compras Realizadas");
        for (Compra compra:listaDeCompras) {
            //HACER FOR DE LA LISTA
            System.out.println(compra.getDescripcion() + " - " + compra.getValor());
        }
        System.out.println("*******************************");
        System.out.println("Saldo de la tarjeta: " + tarjeta.getSaldo());
        System.out.println("Cupo de la tarjeta: " + tarjeta.getCupo());
    }

}
