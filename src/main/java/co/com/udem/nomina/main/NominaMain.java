package co.com.udem.nomina.main;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.hilo.ProcesadorArchivo;
import co.com.udem.nomina.util.LecturaArchivo;

public class NominaMain {
	
	private static final Logger logger = LogManager.getLogger(NominaMain.class);

	public static void main(String[] args) {
		
		/*BasicConfigurator.configure();
		LecturaArchivo lecturaArchivo = new LecturaArchivo();
		
		logger.info(lecturaArchivo.leerArchivo());*/
		
		//System.out.println(lecturaArchivo.leerArchivo());
		
		ProcesadorArchivo procesadorArchivo = new ProcesadorArchivo();
		procesadorArchivo.iniciarHilo();

	}

}
