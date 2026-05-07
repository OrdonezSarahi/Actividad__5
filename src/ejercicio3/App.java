package ejercicio3;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        System.out.println("\n PRUEBA GradoInvalidoException ");
        try {
            Observacion obsInvalida = new Observacion(
                    200.0f, "N", 20.3f, "E",        // 200 grados → inválido
                    new String[]{"enero"}, 100f, "km");
        } catch (GradoInvalidoException e) {
            System.out.println("Capturada: " + e.getMessage());
        } catch (OrientacionInvalidaException | MesInvalidoException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

// 2. Orientación inválida
        System.out.println("\n PRUEBA OrientacionInvalidaException ");
        try {
            Observacion obsInvalida = new Observacion(
                    10.0f, "X", 20.3f, "E",         // "X" no es N ni S → inválido
                    new String[]{"enero"}, 100f, "km");
        } catch (OrientacionInvalidaException e) {
            System.out.println("Capturada: " + e.getMessage());
        } catch (GradoInvalidoException | MesInvalidoException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

// 3. Mes inválido
        System.out.println("\n PRUEBA MesInvalidoException ");
        try {
            Observacion obsInvalida = new Observacion(
                    10.0f, "N", 20.3f, "E",
                    new String[]{"enero", "enro"},   // "enro" no es un mes → inválido
                    100f, "km");
        } catch (MesInvalidoException e) {
            System.out.println("Capturada: " + e.getMessage());
        } catch (GradoInvalidoException | OrientacionInvalidaException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}