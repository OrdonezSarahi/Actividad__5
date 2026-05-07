package ejercicio2;
public class PrecioInvalido extends Exception {
    private double precioIngresado;
    private double costoBase;

    public PrecioInvalido(double precioIngresado, double costoBase) {
        super(String.format(
                "Precio de venta invalido: $%.2f. Debe ser entre 5%% y 30%% mayor al costo ($%.2f). " + "Rango valido: $%.2f - $%.2f.",
                precioIngresado, costoBase,
                costoBase * 1.05, costoBase * 1.30
        ));
        this.precioIngresado = precioIngresado;
        this.costoBase = costoBase;
    }

    public double getPrecioIngresado() { return precioIngresado; }
    public double getCostoBase() { return costoBase; }
    public double getMinimoValido() { return costoBase * 1.05; }
    public double getMaximoValido() { return costoBase * 1.30; }
}