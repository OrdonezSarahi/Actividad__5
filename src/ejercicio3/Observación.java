package ejercicio3;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

    public class Observacion implements Comparable<Observacion> {
        private static final List<String> MESES_VALIDOS = Arrays.asList(
                "enero","febrero","marzo","abril","mayo","junio",
                "julio","agosto","septiembre","octubre","noviembre","diciembre"
        );
        private float gradoLatitud;
        private String orientacionLatitud;
        private float gradoLongitud;
        private String orientacionLongitud;
        private String[] periodoUbicacion;
        private float distanciaTierra;
        private String unidadDistancia;

        public Observacion(float gradoLatitud, String orientacionLatitud,
                           float gradoLongitud, String orientacionLongitud,
                           String[] periodoUbicacion, float distanciaTierra,
                           String unidadDistancia) throws GradoInvalidoException, OrientacionInvalidaException, MesInvalidoException {
            if (gradoLatitud < 0 || gradoLatitud > 180)
                throw new GradoInvalidoException(
                        "Grado de latitud invalido: " + gradoLatitud + ". Debe estar entre 0 y 180.");

            if (gradoLongitud < 0 || gradoLongitud > 180)
                throw new GradoInvalidoException(
                        "Grado de longitud invalido: " + gradoLongitud + ". Debe estar entre 0 y 180.");

            if (!orientacionLatitud.equalsIgnoreCase("N") && !orientacionLatitud.equalsIgnoreCase("S"))
                throw new OrientacionInvalidaException(
                        "Orientacion de latitud invalida: '" + orientacionLatitud + "'. Use N o S.");

            if (!orientacionLongitud.equalsIgnoreCase("E") && !orientacionLongitud.equalsIgnoreCase("O"))
                throw new OrientacionInvalidaException(
                        "Orientacion de longitud invalida: '" + orientacionLongitud + "'. Use E u O.");

            for (String mes : periodoUbicacion) {
                if (!MESES_VALIDOS.contains(mes.toLowerCase()))
                    throw new MesInvalidoException("Mes invalido: '" + mes + "'.");
            }
            this.gradoLatitud = gradoLatitud;
            this.orientacionLatitud = orientacionLatitud;
            this.gradoLongitud = gradoLongitud;
            this.orientacionLongitud = orientacionLongitud;
            this.periodoUbicacion = periodoUbicacion;
            this.distanciaTierra = distanciaTierra;
            this.unidadDistancia = unidadDistancia;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (!(obj instanceof Observacion)) return false;

            Observacion otra = (Observacion) obj;
            return Float.compare(this.gradoLatitud, otra.gradoLatitud) == 0
                    && Float.compare(this.gradoLongitud, otra.gradoLongitud) == 0
                    && Objects.equals(this.orientacionLatitud, otra.orientacionLatitud)
                    && Objects.equals(this.orientacionLongitud, otra.orientacionLongitud)
                    && Arrays.equals(this.periodoUbicacion, otra.periodoUbicacion);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(gradoLatitud, orientacionLatitud,
                    gradoLongitud, orientacionLongitud);
            result = 31 * result + Arrays.hashCode(periodoUbicacion);
            return result;
        }

        @Override
        public int compareTo(Observacion otra) {
            return Float.compare(this.distanciaTierra, otra.distanciaTierra);
        }

        public float getGradoLatitud() {
            return gradoLatitud;
        }

        public String getOrientacionLatitud() {
            return orientacionLatitud;
        }

        public float getGradoLongitud() {
            return gradoLongitud;
        }

        public String getOrientacionLongitud() {
            return orientacionLongitud;
        }

        public String[] getPeriodoUbicacion() {
            return periodoUbicacion;
        }

        public float getDistanciaTierra() {
            return distanciaTierra;
        }

        public String getUnidadDistancia() {
            return unidadDistancia;
        }

        public void setGradoLatitud(float gradoLatitud) {
            this.gradoLatitud = gradoLatitud;
        }

        public void setOrientacionLatitud(String orientacionLatitud) {
            this.orientacionLatitud = orientacionLatitud;
        }

        public void setGradoLongitud(float gradoLongitud) {
            this.gradoLongitud = gradoLongitud;
        }

        public void setOrientacionLongitud(String orientacionLongitud) {
            this.orientacionLongitud = orientacionLongitud;
        }

        public void setDistanciaTierra(float distanciaTierra) {
            this.distanciaTierra = distanciaTierra;
        }

        public void setPeriodoUbicacion(String[] periodoUbicacion) {
            this.periodoUbicacion = periodoUbicacion;
        }

        public void setUnidadDistancia(String unidadDistancia) {
            this.unidadDistancia = unidadDistancia;
        }

        @Override
        public String toString() {
            return "Observacion{" +
                    "\nGrado de Latitud: " + gradoLatitud +
                    " Orientacion de la Latitud: " + orientacionLatitud +
                    "\nGrado Longitud: " + gradoLongitud +
                    " OrientacionLongitud: " + orientacionLongitud +
                    "\nPeriodo de Ubicacion: " + Arrays.toString(periodoUbicacion) +
                    "\nDistancia sobre la Tierra: " + distanciaTierra +
                    " Unidad de Distancia: " + unidadDistancia +
                    "\n}";
        }
    }