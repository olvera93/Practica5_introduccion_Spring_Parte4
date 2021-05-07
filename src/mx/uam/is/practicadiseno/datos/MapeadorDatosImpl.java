package mx.uam.is.practicadiseno.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapeadorDatosImpl implements MapeadorDatos{

	// La estructura que contiene los datos
		private List <String> datos = new ArrayList <String> ();

		/**
		 * Constructor que inicializa con algunos datos
		 * @return 
		 *
		 */
		public MapeadorDatosImpl() {
			datos.add("Entrada 1");
			datos.add("Entrada 2");
			datos.add("Entrada 3");
		}

		/**
		 * Recupera los datos
		 *
		 * @return la lista de datos
		 */
		public String[] dameDatos() {
			// Convierte la lista a un arreglo de cadenas y lo regresa
			String arregloDatos [] = new String[datos.size()];
			datos.toArray(arregloDatos);
			
			return arregloDatos;

		}

		/**
		 * Agrega un dato mientras no este vacio y no este ya en la lista
		 *
		 * @param dato el dato a agregar
		 * @return true si se agrego exitosamente false sino
		 */
		public boolean agrega(String dato) {
			if(!dato.equals("") && !datos.contains(dato)) {
				datos.add(dato);
				return true;
			}
			return false;
		}
		
		/**
		 * Agrega un dato a un archivo mientras no este vacio y que no este ya en el archivo
		 */
		
		@Override
		public boolean agregaArchivo(String dato) {
			FileWriter ficheroAgregar = null;
			PrintWriter pw = null;

			try {
				ficheroAgregar = new FileWriter("prueba.txt", true);
				pw = new PrintWriter(ficheroAgregar);				
				BufferedReader br = new BufferedReader(new FileReader(new File("prueba.txt")));
				
				String linea; // Va estar leyendo linea por linea 
				boolean existeLinea = false;
				
				while((linea = br.readLine()) != null) { // Para recorrer las lineas del archivo
					if(linea.equals(dato)) { // Verifica si el dato 
						existeLinea = true;
						break;
					}
				}
				
				if(!existeLinea && !dato.equals("")) { // Verifica para que se pueda agregar el dato
					ficheroAgregar.write(dato + "\n");
					return true; // Se agrega el dato
				} else {
					return false; // Significa que ya hay un dato igual al que se quiere insertar
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(ficheroAgregar != null) {
						ficheroAgregar.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return false;
		}
		
		/**
		 * Borra un dato de la list
		 *
		 * @return true si se borro exitosamente, false sino
		 */
		public boolean borra(String dato) {
			return datos.remove(dato);
		}

		/**
		 * Metodo llamado cuando se cierra la ventana
		 *
		 */
		public void finaliza() {
			System.exit(0);
		}

		@Override
		public boolean contiene(String dato) {
			// TODO Auto-generated method stub
			return false;
		}

		

	

}
