package co.com.udem.nomina.main;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.hilo.ProcesadorArchivo;
import co.com.udem.nomina.util.LecturaArchivo;

public class NominaMain {
	
	public static void main(String[] args) {
		
		/*String mensaje="";
		BasicConfigurator.configure();
		LecturaArchivo lecturaArchivo = new LecturaArchivo();
		mensaje=lecturaArchivo.leerArchivo();
		logger.info(mensaje);
		*/
		
		
		ProcesadorArchivo procesadorArchivo = new ProcesadorArchivo();
		procesadorArchivo.iniciarHilo();

	}

}
