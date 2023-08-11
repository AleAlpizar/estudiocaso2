/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiocas;
import java.util.Vector;

/**
 *
 * @author 11alp
 */
public class Movimiento {
    private String descripcion;
    private Vector<Amigo> beneficiados;
    private Amigo pagador;
    private double montoTotal;
    public Movimiento(String descripcion, Vector<Amigo> beneficiados, Amigo pagador, double montoTotal) {
        this.descripcion = descripcion;
        this.beneficiados = beneficiados;
        this.pagador = pagador;
        this.montoTotal = montoTotal;
        distribuirGastos();
    }
    private void distribuirGastos() {
        double montoIndividual = montoTotal / beneficiados.size();
        for (Amigo amigo : beneficiados) {
            if (amigo != pagador) {
                amigo.incrementarDeudaCon(pagador, montoIndividual);
            }
        }
        pagador.decrementarDeuda(montoTotal - montoIndividual * beneficiados.size());
    }
}
