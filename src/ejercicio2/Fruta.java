package ejercicio2;
import java.util.ArrayList;
import java.util.Comparator;

public class Fruta implements Comparable<Fruta> {

    private static final int MAX_PERIODOS_ABSOLUTO = 6;
    private static final int MIN_PERIODOS = 1;
    private static final double EXT_MINIMA = 0.5;
    private static final double EXT_MAXIMA_ABSOLUTA = 10.0;
    private static final double MARGEN_MIN = 0.05;
    private static final double MARGEN_MAX = 0.30;

    private String nombre;
    private double extensionHectareas;
    private double costoProdTonelada;
    private double precioVenTonelada;
    private double limiteExtension;
    private ArrayList<PeriodoCosecha> periodos;

    public Fruta(String nombre,
                 double extensionHectareas,
                 double costoProdTonelada,
                 double precioVenTonelada,
                 double limiteExtension)
            throws ExtensionInvalida, PrecioInvalido {

        if (limiteExtension > EXT_MAXIMA_ABSOLUTA || limiteExtension < EXT_MINIMA) {
            throw new IllegalArgumentException(
                    "limiteExtension debe estar entre 0.5 y 10.0. Valor recibido: " + limiteExtension);
        }
        this.limiteExtension = limiteExtension;

        if (extensionHectareas < EXT_MINIMA || extensionHectareas > limiteExtension) {
            throw new ExtensionInvalida(extensionHectareas, limiteExtension);
        }

        double minimoValido = costoProdTonelada * (1 + MARGEN_MIN);
        double maximoValido = costoProdTonelada * (1 + MARGEN_MAX);
        if (precioVenTonelada < minimoValido || precioVenTonelada > maximoValido) {
            throw new PrecioInvalido(precioVenTonelada, costoProdTonelada);
        }

        this.nombre = nombre;
        this.extensionHectareas = extensionHectareas;
        this.costoProdTonelada = costoProdTonelada;
        this.precioVenTonelada = precioVenTonelada;
        this.periodos = new ArrayList<PeriodoCosecha>();
    }

    public void agregarPeriodo(PeriodoCosecha periodo) {
        if (periodos.size() >= MAX_PERIODOS_ABSOLUTO) {
            throw new IllegalStateException(
                    "No se puede agregar mas periodos. Limite maximo de " + MAX_PERIODOS_ABSOLUTO + " periodos alcanzado para la fruta '"
                            + nombre + "'");
        }
        periodos.add(periodo);
        System.out.println("Periodo '" + periodo.getNombrePeriodo() + "' agregado a la fruta " + nombre);
    }

    public void eliminarPeriodo(PeriodoCosecha periodo) {
        if (!periodos.contains(periodo)) {
            System.out.println("El periodo no se encontro en la lista.");
            return;
        }
        if (periodos.size() <= MIN_PERIODOS) {
            throw new IllegalStateException(
                    "No se puede eliminar el periodo. La fruta '" + nombre
                            + "' debe conservar al menos " + MIN_PERIODOS + " periodo de cosecha.");
        }
        periodos.remove(periodo);
        System.out.println("Periodo '" + periodo.getNombrePeriodo() + "' eliminado de la fruta " + nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fruta otraFruta = (Fruta) obj;
        return this.nombre.equalsIgnoreCase(otraFruta.nombre);
    }

    @Override
    public int hashCode() { return nombre.toLowerCase().hashCode(); }

    @Override
    public int compareTo(Fruta otraFruta) {
        return Double.compare(this.extensionHectareas, otraFruta.extensionHectareas);
    }

    public static Comparator<Fruta> porPrecioVenta = new Comparator<Fruta>() {
        @Override
        public int compare(Fruta f1, Fruta f2) {
            return Double.compare(f1.precioVenTonelada, f2.precioVenTonelada);
        }
    };

    public static Comparator<Fruta> porNombre = new Comparator<Fruta>() {
        @Override
        public int compare(Fruta f1, Fruta f2) {
            return f1.nombre.compareToIgnoreCase(f2.nombre);
        }
    };

    public String getNombre() { return nombre; }
    public double getExtensionHectareas() { return extensionHectareas; }
    public double getCostoProdTonelada() { return costoProdTonelada; }
    public double getPrecVenTonelada() { return precioVenTonelada; }
    public double getLimiteExtension() { return limiteExtension; }
    public ArrayList<PeriodoCosecha> getPeriodos() { return periodos; }

    public void mostrarInfo() {
        System.out.println("Fruta: " + nombre);
        System.out.println("Extension (hectareas): " + extensionHectareas);
        System.out.println("Limite de extension configurado: " + limiteExtension + " ha");
        System.out.println("Costo prod. por tonelada: $" + costoProdTonelada);
        System.out.println("Precio venta por tonelada: $" + precioVenTonelada);
        System.out.println("Numero de periodos: " + periodos.size());
        if (periodos.isEmpty()) {
            System.out.println("No hay periodos registrados.");
        } else {
            for (PeriodoCosecha p : periodos) {
                System.out.println("\n-- Periodo: " + p.getNombrePeriodo() + " --");
                System.out.println("  Cantidad estimada por hectarea: " + p.getCantEstimada() + " ton/ha");
                System.out.println("  Produccion total: " + p.calcularProdTotal(extensionHectareas) + " toneladas");
                System.out.println("  Costo total del periodo: $" + p.calcularCostTotPeriodo(costoProdTonelada, extensionHectareas));
                System.out.println("  Ganancia estimada: $"
                        + p.calcularGanaEstiPeriodo(precioVenTonelada, costoProdTonelada, extensionHectareas));
            }
        }
    }
}