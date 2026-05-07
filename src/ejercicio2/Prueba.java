package ejercicio2;
import java.util.ArrayList;
import java.util.Collections;

public class Prueba {
    public static void main(String[] args) {

        //  1. Probamos: ExtensionInvalida
        System.out.println("=== 1. PRUEBA ExtensionInvalidaException ===");

        try {
            Fruta frutaMala = new Fruta("Sandia", 12.0, 500.0, 600.0, 8.0);
            System.out.println("ERROR: no se lanzo la excepcion.");
        } catch (ExtensionInvalida e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        } catch (PrecioInvalido e) {
            System.out.println("Excepcion inesperada: " + e.getMessage());
        }

        try {
            Fruta frutaMala2 = new Fruta("Kiwi", 0.3, 500.0, 600.0, 5.0);
            System.out.println("ERROR: no se lanzo la excepcion.");
        } catch (ExtensionInvalida e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        } catch (PrecioInvalido e) {
            System.out.println("Excepcion inesperada: " + e.getMessage());
        }

        try {
            Fruta frutaMala3 = new Fruta("Pera", 5.0, 500.0, 600.0, 15.0);
            System.out.println("ERROR: no se lanzo la excepcion.");
        } catch (IllegalArgumentException e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepcion inesperada: " + e.getMessage());
        }

        //  2. Probamos: PrecioInvalidoException
        System.out.println("\n=== 2. PRUEBA PrecioInvalidoException ===");

        try {
            Fruta frutaMala = new Fruta("Melon", 3.0, 500.0, 480.0, 6.0);
            System.out.println("ERROR: no se lanzo la excepcion.");
        } catch (ExtensionInvalida e) {
            System.out.println("Excepcion inesperada: " + e.getMessage());
        } catch (PrecioInvalido e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }

        try {
            Fruta frutaMala2 = new Fruta("Melon", 3.0, 500.0, 700.0, 6.0);
            System.out.println("ERROR: no se lanzo la excepcion.");
        } catch (ExtensionInvalida e) {
            System.out.println("Excepcion inesperada: " + e.getMessage());
        } catch (PrecioInvalido e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }

        //  3. Probamos: CantidadEstimadaInvalida
        System.out.println("\n=== 3. PRUEBA CantidadEstimadaInvalidaException ===");

        try {
            PeriodoCosecha periodoMalo = new PeriodoCosecha("Verano", 250.0);
            System.out.println("ERROR: no se lanzo la excepcion.");
        } catch (CantidadEstimadaInvalida e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }

        try {
            PeriodoCosecha periodoMalo2 = new PeriodoCosecha("Invierno", 0.1);
            System.out.println("ERROR: no se lanzo la excepcion.");
        } catch (CantidadEstimadaInvalida e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }

        //  4. Probamos: límite de periodos (IllegalStateException)
        System.out.println("\n=== 4. PRUEBA limite maximo de periodos ===");

        try {
            Fruta manzana = new Fruta("Manzana", 5.0, 500.0, 600.0, 8.0);

            for (int i = 1; i <= 6; i++) {
                manzana.agregarPeriodo(new PeriodoCosecha("Periodo" + i, 10.0 * i));
            }
            System.out.println("6 periodos agregados correctamente.");

            manzana.agregarPeriodo(new PeriodoCosecha("PeriodoExtra", 5.0));
            System.out.println("ERROR: no se lanzo la excepcion.");

        } catch (IllegalStateException e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepcion inesperada: " + e.getMessage());
        }

        //  5. Probamos eliminar hasta quedar sin periodos
        System.out.println("\n=== 5. PRUEBA minimo de periodos al eliminar ===");

        try {
            Fruta naranja = new Fruta("Naranja", 4.0, 600.0, 720.0, 7.0);
            PeriodoCosecha p1 = new PeriodoCosecha("Primavera", 15.0);
            naranja.agregarPeriodo(p1);

            naranja.eliminarPeriodo(p1);
            System.out.println("ERROR: no se lanzo la excepcion.");

        } catch (IllegalStateException e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepcion inesperada: " + e.getMessage());
        }

        //  6. Probamos el flujo normal sin errores
        System.out.println("\n=== 6. FLUJO NORMAL (sin excepciones) ===");

        try {
            Fruta mango = new Fruta("Mango", 7.0, 800.0, 960.0, 10.0);
            PeriodoCosecha periodo1 = new PeriodoCosecha("Temporada Alta",  50.0);
            PeriodoCosecha periodo2 = new PeriodoCosecha("Temporada Media", 30.0);
            PeriodoCosecha periodo3 = new PeriodoCosecha("Temporada Baja",  15.0);

            mango.agregarPeriodo(periodo1);
            mango.agregarPeriodo(periodo2);
            mango.agregarPeriodo(periodo3);

            mango.mostrarInfo();

            mango.eliminarPeriodo(periodo3);
            System.out.println("Periodos restantes: " + mango.getPeriodos().size());

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        //  7. Probamos Comparable y Comparator
        System.out.println("\n=== 7. PRUEBA Comparable y Comparator ===");

        try {
            ArrayList<Fruta> lista = new ArrayList<Fruta>();
            lista.add(new Fruta("Naranja", 7.0, 700.0, 840.0, 10.0));  // +20%
            lista.add(new Fruta("Manzana", 5.0, 800.0, 960.0, 8.0));   // +20%
            lista.add(new Fruta("Mango",   3.0, 600.0, 720.0, 6.0));   // +20%
            lista.add(new Fruta("Papaya",  2.0, 400.0, 480.0, 5.0));   // +20%

            System.out.println("Antes de ordenar:");
            for (Fruta f : lista) {
                System.out.println("  " + f.getNombre() + " -> " + f.getExtensionHectareas() + " ha");
            }

            Collections.sort(lista);
            System.out.println("Por hectareas (Comparable):");
            for (Fruta f : lista) {
                System.out.println("  " + f.getNombre() + " -> " + f.getExtensionHectareas() + " ha");
            }

            Collections.sort(lista, Fruta.porPrecioVenta);
            System.out.println("Por precio de venta (Comparator):");
            for (Fruta f : lista) {
                System.out.println("  " + f.getNombre() + " -> $" + f.getPrecVenTonelada());
            }

            Collections.sort(lista, Fruta.porNombre);
            System.out.println("Por nombre A-Z (Comparator):");
            for (Fruta f : lista) {
                System.out.println("  " + f.getNombre());
            }

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}