package ejercicio3;
import java.util.Comparator;

public class ComparadorDistancia implements Comparator<Observacion> {
    @Override
    public int compare(Observacion a, Observacion b) {
        return Float.compare(b.getDistanciaTierra(), a.getDistanciaTierra());
    }
}