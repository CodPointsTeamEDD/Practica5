
/**
 * Clase que representa un historial de páginas web,
 * almacenadas en una lista ligada simple.
 * 
 * @author Erick Xavier Martinez Briones
 * @author Luis Fernando Quintana López
 * @version 1.0.0
 * @since 2026
 */
public class Historial {

    /**
     * Lista ligada simple que almacena las páginas del historial.
     */
    private Lista<Pagina> historial;

    /**
     * Crea un historial nuevo con la lista ligada simple proporcionada.
     *
     * @param historial la lista ligada simple de páginas inicial
     */
    public Historial(Lista<Pagina> historial) {
        this.historial = historial;
    }

    /**
     * Agrega una página al historial
     * Si la página ya existe elimina la existente y agrega la nueva al inicio,
     * en otro caso, simplemente la agrega al inicio.
     *
     * @param p la página a agregar
     */
    public void agregarPagina(Pagina p) {

        if (this.historial.buscar(p)) {
            this.historial.eliminar(p);
        }

        this.historial.agregar(p);

    }

    /**
     * Devuelve una representación en cadena del historial,
     * que corresponde a la representación en cadena
     * de la lista ligada simple de páginas.
     *
     * @return una cadena con el historial completo
     */
    @Override
    public String toString() {
        String separacion = "--------------------------------";
        String nom = "Nombre de la pagina web: ";
        String ult = "Ultima visita: ";
        String interfaz = " ";

        for (Pagina pag : historial) {

            interfaz += separacion + "\n" +
                    nom + pag.getNombre() + "\n" +
                    ult + pag.getFecha() + "\n" +
                    separacion
                    + "\n";

        }

        return interfaz;

    }
}
