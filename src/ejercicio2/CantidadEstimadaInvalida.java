package ejercicio2;
public class CantidadEstimadaInvalida extends Exception {
    private double cantidadIngresada;
    public CantidadEstimadaInvalida(double cantidadIngresada) {
        super(String.format(
                "Cantidad estimada invalida: %.2f ton/ha. Debe estar entre 0.5 y 200.0 ton/ha.",
                cantidadIngresada
        ));
        this.cantidadIngresada = cantidadIngresada;
    }

    public double getCantidadIngresada() { return cantidadIngresada; }
}
