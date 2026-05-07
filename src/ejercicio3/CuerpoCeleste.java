package ejercicio3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

    public class CuerpoCeleste  implements Comparable<CuerpoCeleste>{
        private String nombre;
        private String[] composicion;
        private ArrayList<Observacion> observaciones;

        public CuerpoCeleste(String nombre, String[] composicion) {
            this.nombre = nombre;
            this.composicion = composicion;
            this.observaciones = new ArrayList<>();
        }

        public void agregarObservacion(Observacion observacion) {
            this.observaciones.add(observacion);
        }

        public String calcularDesplazamiento(Observacion obs1, Observacion obs2) {
            float difLatitud = obs2.getGradoLatitud() - obs1.getGradoLatitud();
            float difLongitud = obs2.getGradoLongitud() - obs1.getGradoLongitud();
            return "Diferencia en grados de la Latitud: " + difLatitud +
                    "\nDiferencia en grados de la Longitud: " + difLongitud;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (!(obj instanceof CuerpoCeleste)) return false;

            CuerpoCeleste otro = (CuerpoCeleste) obj;
            return Objects.equals(this.nombre, otro.nombre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre);
        }
        @Override
        public int compareTo(CuerpoCeleste otro) {
            return this.nombre.compareTo(otro.nombre);
        }

        public String getNombre() {
            return nombre;
        }

        public String[] getComposicion() {
            return composicion;
        }

        public ArrayList<Observacion> getObservaciones() {
            return observaciones;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setComposicion(String[] composicion) {
            this.composicion = composicion;
        }

        @Override
        public String toString() {
            return "CuerpoCeleste{" +
                    "Nombre: " + nombre + '\'' +
                    " Composicion: " + Arrays.toString(composicion) +
                    " Observaciones: " + observaciones +
                    '}';
        }

    }