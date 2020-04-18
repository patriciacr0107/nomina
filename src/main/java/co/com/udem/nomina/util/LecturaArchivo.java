package co.com.udem.nomina.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.dto.EmpleadoDTO;

public class LecturaArchivo {

	private static final Logger logger = LogManager.getLogger(LecturaArchivo.class);
	private Hashtable<String, EmpleadoDTO> listaEmpleados = new Hashtable<String, EmpleadoDTO>();
	private int cantidadRegistros =0;
	
	public String leerArchivo() {
		BasicConfigurator.configure();
		File archivoNomina = new File("c:\\nominaEmpleados.txt");
		Scanner scanner = null;
		String mensaje = "";
		
		try {
			scanner = new Scanner(archivoNomina);
			while (scanner.hasNextLine() ) {
				String registro = scanner.nextLine();
				leerRegistro(registro);
				cantidadRegistros++;
			}
			
		} catch (FileNotFoundException e) {
			mensaje = "El archivo no existe";
			logger.error(e.getMessage());
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
		
		while (scanner.hasNext()) {
			EmpleadoDTO empleadoDTO = new EmpleadoDTO();
			empleadoDTO.setNombres(scanner.next());
			empleadoDTO.setApellidos(scanner.next());
			empleadoDTO.setCedula(scanner.next());
			empleadoDTO.setDepartamento(scanner.next());
			empleadoDTO.setSalario(Double.parseDouble(scanner.next()));
			listaEmpleados.put(empleadoDTO.getCedula(), empleadoDTO);
		}
		imprimirEmpleadosArchivo(listaEmpleados);
		scanner.close();
	}
	
	public int devolverCantidadRegistros() {
		return cantidadRegistros;
	}
	
	public void imprimirEmpleadosArchivo(Hashtable<String, EmpleadoDTO> listaEmpleados) {
		BasicConfigurator.configure();
		//logger.info(listaEmpleados);
		EmpleadoDTO empleadounico = new EmpleadoDTO();
		Enumeration<EmpleadoDTO> enumeracion = listaEmpleados.elements();
		
		while (enumeracion.hasMoreElements() ) {
			empleadounico =enumeracion.nextElement();
			logger.info(empleadounico.getNombres());
			logger.info(empleadounico.getApellidos());
			logger.info(empleadounico.getCedula());
			
		}
	}
}
