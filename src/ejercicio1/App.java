package ejercicio1;
import java.time.LocalDate;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) {

        List<Prenda> prendas = new ArrayList<>();
        List<Lote> lotes = new ArrayList<>();

        try {
            Prenda p1 = new Prenda("Camisa Casual","Algodón",200,"Masculino","Verano");
            Prenda p2 = new Prenda("blusa","Algodón",300,"Femenino","Verano");

            prendas.add(p1);
            prendas.add(p2);

            Lote lote1 = new Lote(101,50,LocalDate.of(2026, 3, 15),p1);
            Lote lote2 = new Lote(102,52,LocalDate.of(2026, 3, 20),p2);

            lotes.add(lote1);
            lotes.add(lote2);

            System.out.println(p1);
            System.out.println("Precio venta por pieza: " + p1.calcularPrecioVenPieza());
            System.out.println(lote1);
            System.out.println("Costo producción lote: " + lote1.calcularCostoProduccionLote());
            System.out.println("Monto recuperación lote: " + lote1.calcularMontoRecuperacion());
            System.out.println("\nColeccion de las prendas");
            System.out.println(prendas);
            System.out.println("\nColeccion de los lotes");
            System.out.println(lotes);

            List<Prenda> lista = new ArrayList<>();
            lista.add(p1);
            lista.add(new Prenda("Playera","Poliéster",150,"Femenino","Verano"));
            // Comparable
            Collections.sort(lista);
            System.out.println("Orden por modelo:");
            System.out.println(lista);
            // Comparator
            Collections.sort(lista,new Prenda.CompararPorCosto());
            System.out.println("Orden por costo:");
            System.out.println(lista);
        }
        catch (GeneroInvalidoException e) {
            System.out.println("Error de género: " + e.getMessage());
        }
        catch (TemporadaInvalidaException e) {
            System.out.println("Error de temporada: " + e.getMessage());
        }
        catch (CostoProduccionException e) {
            System.out.println("Error de costo: " + e.getMessage());
        }
        catch (NumeroPiezasException e) {
            System.out.println("Error en lote: " + e.getMessage());
        }
    }
}