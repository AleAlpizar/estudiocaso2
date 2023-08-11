/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiocas;
import java.util.HashMap;

/**
 *
 * @author 11alp
 */
public class Amigo {
    private String nombre;
    private HashMap<Amigo, Double> deudas;
    public Amigo(String nombre) {
        this.nombre = nombre;
        this.deudas = new HashMap<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void incrementarDeudaCon(Amigo amigo, double monto) {
        deudas.put(amigo, deudas.getOrDefault(amigo, 0.0) + monto);
    }
    public void decrementarDeuda(double monto) {
        for (Amigo amigo : deudas.keySet()) {
            double deudaActual = deudas.get(amigo);
            deudas.put(amigo, deudaActual - monto);
        }
    }
    public String mostrarDeudas() {
        StringBuilder sb = new StringBuilder();
        for (Amigo amigo : deudas.keySet()) {
            double deuda = deudas.get(amigo);
            if (deuda > 0) {
                sb.append("Debe a ").append(amigo.getNombre()).append(": $").append(deuda).append("\n");
            }
        }
        return sb.toString();
    }
}
