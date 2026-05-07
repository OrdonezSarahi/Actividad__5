package ejercicio3;
import java.util.Comparator;

public class ComparadorLatitud implements Comparator<Observacion> {
    @Override
    public int compare(Observacion a, Observacion b) {
        return Float.compare(a.getGradoLatitud(), b.getGradoLatitud());
    }
}