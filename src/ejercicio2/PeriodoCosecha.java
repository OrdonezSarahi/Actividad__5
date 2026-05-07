package ejercicio2;
import java.util.Comparator;
public class PeriodoCosecha implements Comparable<PeriodoCosecha> {

    private static final double CANT_MINIMA = 0.5;
    private static final double CANT_MAXIMA = 200.0;

    private String nombrePeriodo;
    private double cantidadEstTonxHectarea;

    public PeriodoCosecha(String nombrePeriodo, double cantidadEstTonxHectarea)
            throws CantidadEstimadaInvalida {

        if (cantidadEstTonxHectarea < CANT_MINIMA || cantidadEstTonxHectarea > CANT_MAXIMA) {
            throw new CantidadEstimadaInvalida(cantidadEstTonxHectarea);
        }

        this.nombrePeriodo = nombrePeriodo;
        this.cantidadEstTonxHectarea = cantidadEstTonxHectarea;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PeriodoCosecha otroPeriodo = (PeriodoCosecha) obj;
        return this.nombrePeriodo.equalsIgnoreCase(otroPeriodo.nombrePeriodo);
    }

    @Override
    public int hashCode() { return nombrePeriodo.toLowerCase().hashCode(); }

    @Override
    public int compareTo(PeriodoCosecha otroPeriodo) {
        return Double.compare(this.cantidadEstTonxHectarea, otroPeriodo.cantidadEstTonxHectarea);
    }

    public static Comparator<PeriodoCosecha> porNombre = new Comparator<PeriodoCosecha>() {
        @Override
        public int compare(PeriodoCosecha p1, PeriodoCosecha p2) {
            return p1.nombrePeriodo.compareToIgnoreCase(p2.nombrePeriodo);
        }
    };

    public String getNombrePeriodo()  { return nombrePeriodo; }
    public double getCantEstimada()   { return cantidadEstTonxHectarea; }

    public double calcularProdTotal(double extensionHectareas) {
        return cantidadEstTonxHectarea * extensionHectareas;
    }

    public double calcularCostTotPeriodo(double costoProdTonelada, double extensionHectareas) {
        return calcularProdTotal(extensionHectareas) * costoProdTonelada;
    }

    public double calcularGanaEstiPeriodo(double precioVenTonelada, double costoProdTonelada, double extensionHectareas) {
        double ingresos = calcularProdTotal(extensionHectareas) * precioVenTonelada;
        double costos = calcularCostTotPeriodo(costoProdTonelada, extensionHectareas);
        return ingresos - costos;
    }

    @Override
    public String toString() {
        return "PeriodoCosecha{nombrePeriodo='" + nombrePeriodo + "', cantidadEstTonxHectarea=" + cantidadEstTonxHectarea + '}';
    }
}