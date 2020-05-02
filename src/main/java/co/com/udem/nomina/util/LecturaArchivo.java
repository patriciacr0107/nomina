package co.com.udem.nomina.util;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.dto.EmpleadoDTO;

public class LecturaArchivo {

	private static final Logger logger = LogManager.getLogger(LecturaArchivo.class);
	private static HashMap<String, EmpleadoDTO> listaEmpleados = new HashMap<String, EmpleadoDTO>();
	
	public String leerArchivo() {
		InputStream archivoEmpleados = null;
		archivoEmpleados=ClassLoader.class.getResourceAsStream("/nominaEmpleados.txt");
		Scanner scanner = null;
		String mensaje = "Procesado OK";
		
		try {
			scanner = new Scanner(archivoEmpleados);
			while (scanner.hasNextLine() ) {
				String registro = scanner.nextLine();
				leerRegistro(registro);
				
			}
			imprimirEmpleadosArchivo();
			
			
		} catch (Exception e) {
			mensaje = "El archivo no existe";
			
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			
		}

		return mensaje;
	}
	
	private void leerRegistro(String registro) {
		Scanner scanner = new Scanner(registro);
		scanner.useDelimiter(",");
		
		llenarDTO(scanner);
		
		scanner.close();
	}
	
	private void llenarDTO(Scanner scanner) {
		try {
			EmpleadoDTO empleadoDTO = new EmpleadoDTO();
			empleadoDTO.setNombres(scanner.next());
			empleadoDTO.setApellidos(scanner.next());
			empleadoDTO.setCedula(scanner.next());
			empleadoDTO.setDepartamento(scanner.next());
			empleadoDTO.setSalario(Double.parseDouble(scanner.next()));
			listaEmpleados.put(empleadoDTO.getCedula(), empleadoDTO);
		} catch (Exception e) {
			logger.error("Error leyendo registro");

		}
	}

	
	
	private void imprimirEmpleadosArchivo() {
		Collection<EmpleadoDTO> coleccionEmpleados= listaEmpleados.values();
		Iterator<EmpleadoDTO> iterator = coleccionEmpleados.iterator();
		
		while (iterator.hasNext() ) {
			EmpleadoDTO empleadoDTO = iterator.next();
			logger.info(empleadoDTO.getNombres());
			logger.info(empleadoDTO.getApellidos());
			logger.info(empleadoDTO.getCedula());
			logger.info(empleadoDTO.getDepartamento());
			logger.info(empleadoDTO.getSalario());
			logger.info("--------------------------------");
			
		}
	}
	
	public int tamanoHashMap() {
		return listaEmpleados.size();
	}
}
