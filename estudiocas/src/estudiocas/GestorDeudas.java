/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiocas;
import javax.swing.JOptionPane;
import java.util.Vector;
/**
 *
 * @author 11alp
 */
public class GestorDeudas {
    private Vector<Amigo> amigos;
    private Vector<Movimiento> movimientos;
    public GestorDeudas() {
        amigos = new Vector<>();
        movimientos = new Vector<>();
    }
    public void agregarAmigo(Amigo amigo) {
        amigos.add(amigo);
    }
    public Amigo buscarAmigo(String nombre) {
        for (Amigo amigo : amigos) {
            if (amigo.getNombre().equals(nombre)) {
                return amigo;
            }
        }
        return null;
    }

    public void agregarMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }
    public void ingresarMovimiento() {
        String descripcion = JOptionPane.showInputDialog("Movimiento(actividad):");

        String nombrePagador = JOptionPane.showInputDialog("Quien pago el total de la cuenta(escribir correctamente el nombre y en minuscula):");
        Amigo pagador = buscarAmigo(nombrePagador);
        double montoTotal = Double.parseDouble(JOptionPane.showInputDialog("Monto pagado:"));
        String nombresBeneficiados = JOptionPane.showInputDialog("Nombres de las personas que deben en la cuenta(siga los nombres por comas): ");
        String[] nombresArray = nombresBeneficiados.split(",");
        Vector<Amigo> beneficiados = new Vector<>();
        for (String nombre : nombresArray) {
            beneficiados.add(buscarAmigo(nombre.trim()));
        }
        Movimiento movimiento = new Movimiento(descripcion, beneficiados, pagador, montoTotal);
        agregarMovimiento(movimiento);
    }
    public void mostrarDeudasDeAmigo(Amigo amigo) {
        String deudas = amigo.mostrarDeudas();
        JOptionPane.showMessageDialog(null, deudas);
    }
}
