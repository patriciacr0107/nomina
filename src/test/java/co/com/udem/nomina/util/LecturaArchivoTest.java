package co.com.udem.nomina.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LecturaArchivoTest {
	
	@Test
	public void leerArchivoTest() {
		LecturaArchivo lecturaArchivo = new LecturaArchivo();
		String resultado = lecturaArchivo.leerArchivo();
		
		assertEquals("Procesado OK", resultado);
	
		
		
	}

}
