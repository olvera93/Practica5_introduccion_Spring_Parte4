package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;
import java.util.List;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;
import mx.uam.is.practicadiseno.datos.MapeadorDatosImpl;

public class ManejadorImpl implements Manejador {

	// La estructura que contiene los datos
	private List <String> datos = new ArrayList <String> ();
	
	// La estructura que contiene los observadores
	private List<Observador> observadores = new ArrayList<Observador>();
	
	// Referencia al programa
	private MapeadorDatosImpl mapeadorDatosImpl;
	
	/**
	 * Constructor para conectar con el 
	 * mapeardor de datos
	 * 
	 */
	public ManejadorImpl(MapeadorDatosImpl mapeadorDatosImpl){
		this.mapeadorDatosImpl = mapeadorDatosImpl;
	}

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	public String[] dameDatos() {
		return mapeadorDatosImpl.dameDatos();
	}

	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar
	 * @return true si se agrego exitosamente false sino
	 */
	public boolean agrega(String dato) {
		return mapeadorDatosImpl.agrega(dato);
	}
	
	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar en el archivo
	 * @return true si se agrego exitosamente false sino
	 */
	public boolean agregaArchivo(String dato) {
		return mapeadorDatosImpl.agregaArchivo(dato);
	}
	

	/**
	 * Borra un dato de la list
	 *
	 * @param dato el dato a borrar
	 * @return true si se borro exitosamente, false sino
	 */
	public boolean borra(String dato) {
		return mapeadorDatosImpl.borra(dato);
	}

	/**
	 * Metodo llamado cuando se cierra la ventana
	 *
	 */
	public void finaliza() {
		if(observadores.size()-1 == -1) {
			System.exit(0);
		} else {
			System.out.println("Observadores: " + observadores.size());
		}
	}
	
	/**
	 * Se agrega un observador a lista de Observadores
	 * 
	 */
	public boolean agregaObservador(Observador o) {
		// agregar un observador a la lista de observadores
		return observadores.add(o);
	}
	
	/**
	 * Se borra un observador de la lista de Observadores
	 * 
	 */
	public boolean quitaObservador(Observador o) {
		// quitar un observador de la lista de observadores
		if(observadores.isEmpty())
			System.exit(0);
		return observadores.remove(o);
	}

	/**
	 * Llamar actualizar() a todos los observadore
	 * se empieza a recorrer la lista
	 */
	@Override
	public void notificar() {
		// llamar actualiza() sobre todos los observadores
		for(Observador o: observadores) {
			o.actualiza();
		}
		
	}
	
	

	
}
