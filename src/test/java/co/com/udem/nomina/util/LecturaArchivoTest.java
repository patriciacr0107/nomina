package co.com.udem.nomina.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LecturaArchivoTest {
	
	private LecturaArchivo lecturaArchivo = new LecturaArchivo();
	
	@Test
	public void leerArchivoTest() {
		String resultado = lecturaArchivo.leerArchivo();
		
		assertEquals("Procesado OK", resultado);
		
	}
	
	@Test
	public void tamanoHashMapTest() {
		lecturaArchivo.leerArchivo();
		int resultado = lecturaArchivo.tamanoHashMap();
		
		assertEquals(3, resultado);
	}
	

}
