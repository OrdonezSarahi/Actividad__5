package ejercicio1;
import java.time.LocalDate;
import java.util.Objects;

public class Lote {

    private int numeroLote;
    private int numeroPiezas;
    private LocalDate fechaFabricacion;
    private Prenda prenda;

    public Lote(int numeroLote,int numeroPiezas,LocalDate fechaFabricacion,Prenda prenda)throws NumeroPiezasException {
        // Validacion de piezas
        if (numeroPiezas < 50 || numeroPiezas > 350) {
            throw new NumeroPiezasException( "El número de piezas debe estar entre 50 y 350");
        }
        this.numeroLote = numeroLote;
        this.numeroPiezas = numeroPiezas;
        this.fechaFabricacion = fechaFabricacion;
        this.prenda = prenda;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public double calcularCostoProduccionLote() {
        return numeroPiezas * prenda.getCostoProduccion();
    }

    // Recuperacion del lote 5%
    public double calcularMontoRecuperacion() {
        double precioPieza = prenda.getCostoProduccion() + (prenda.getCostoProduccion() * 0.05);
        return numeroPiezas * precioPieza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lote))
            return false;
        Lote lote = (Lote) o;
        return numeroLote == lote.numeroLote;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroLote);
    }

    @Override
    public String toString() {
        return "Lote{" +
                "numeroLote=" + numeroLote +
                ", numeroPiezas=" + numeroPiezas +
                ", fechaFabricacion=" + fechaFabricacion +
                ", prenda=" + prenda +
                '}';
    }
}