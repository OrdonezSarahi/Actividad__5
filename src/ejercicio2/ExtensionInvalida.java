package ejercicio2;

public class ExtensionInvalida extends Exception {
    private double valorIngresado;
    private double limiteMaximo;

    public ExtensionInvalida(double valorIngresado, double limiteMaximo) {
        super(String.format(
                "Extension invalida: %.2f ha. Debe estar entre 0.5 y %.2f ha (limite maximo configurado).",
                valorIngresado, limiteMaximo
        ));
    }
}