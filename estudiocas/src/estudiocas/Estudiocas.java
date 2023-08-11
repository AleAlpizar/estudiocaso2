/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiocas;

import javax.swing.JOptionPane;

/**
 *
 * @author 11alp
 */
public class Estudiocas {

   public static void main(String[] args) {
        GestorDeudas deudas = new GestorDeudas();
        deudas.agregarAmigo(new Amigo("david"));
        deudas.agregarAmigo(new Amigo("tavo"));
        deudas.agregarAmigo(new Amigo("andres"));
        deudas.agregarAmigo(new Amigo("guillermo"));
        deudas.agregarAmigo(new Amigo("greivin"));
        deudas.agregarAmigo(new Amigo("joshua"));
        while (true) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite el numero con la opcion que desee...\n " + "1-movimiento \n" +
                "2-deuda \n" +
                "3-salir\n" +
                ""
            ));
            switch (opcion) {
                case 1:
                    deudas.ingresarMovimiento();
                    break;
                case 2:
                    String nombreAmigo = JOptionPane.showInputDialog("Nombre del amigo(escribir correctamente el nombre y en minuscula):");
                    Amigo amigo = deudas.buscarAmigo(nombreAmigo);
                    deudas.mostrarDeudasDeAmigo(amigo);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "error");
                    break;
            }
        }
    }
}
