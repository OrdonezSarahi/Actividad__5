package ejercicio1;
import java.util.Objects;
import java.util.Comparator;

public class Prenda implements Comparable<Prenda> {

    private String modelo;
    private String tela;
    private double costoProduccion;
    private String genero;
    private String temporada;

    public Prenda(String modelo, String tela,double costoProduccion,String genero,String temporada)throws GeneroInvalidoException,TemporadaInvalidaException,CostoProduccionException {
        double LIMITE_COSTO = 5000;
        // Aca valide el Genero
        if (!(genero.equalsIgnoreCase("Masculino") ||genero.equalsIgnoreCase("Femenino") || genero.equalsIgnoreCase("Mixto"))) {
            throw new GeneroInvalidoException("El género debe ser Masculino, Femenino o Mixto");
        }
        // Validacion de  temporada
        if (!(temporada.equalsIgnoreCase("Primavera") || temporada.equalsIgnoreCase("Verano") ||temporada.equalsIgnoreCase("Otoño") || temporada.equalsIgnoreCase("Invierno"))) {
            throw new TemporadaInvalidaException( "Temporada inválida");
        }
        // Validacion de costo de produccion
        if (costoProduccion > LIMITE_COSTO || costoProduccion <= 0) {
            throw new CostoProduccionException("El costo de producción es inválido");
        }

        this.modelo = modelo;
        this.tela = tela;
        this.costoProduccion = costoProduccion;
        this.genero = genero;
        this.temporada = temporada;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    public String getGenero() {
        return genero;
    }

    public String getTemporada() {
        return temporada;
    }

    // Precio de venta por pieza del 15%
    public double calcularPrecioVenPieza() {
        return costoProduccion + (costoProduccion * 0.15);
    }

    @Override
    public int compareTo(Prenda otra) {
        return this.modelo.compareTo(otra.modelo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prenda))
            return false;
        Prenda prenda = (Prenda) o;
        return Objects.equals(modelo, prenda.modelo) &&
                Objects.equals(tela, prenda.tela) &&
                Objects.equals(genero, prenda.genero) &&
                Objects.equals(temporada, prenda.temporada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo,tela,genero,temporada);
    }

    public static class CompararPorCosto implements Comparator<Prenda> {
        @Override
        public int compare(Prenda p1, Prenda p2) {
            return Double.compare(p1.getCostoProduccion(), p2.getCostoProduccion());
        }
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "modelo='" + modelo + '\'' +
                ", tela='" + tela + '\'' +
                ", costoProduccion=" + costoProduccion +
                ", genero='" + genero + '\'' +
                ", temporada='" + temporada + '\'' +
                '}';
    }
}