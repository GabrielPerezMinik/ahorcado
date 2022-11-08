package dad.ahorcado.partidas;

public class Partidalogica {

	PartidasController controller;
	static int contador=1; 
	String hola="hola";
	
	public int respuestaLetra(char letra) {
		
	
		
		if(hola=="hola") {
			return contador;
		}
		else {
			return contador+=1;
		}
	}
	
	public void reset() {
		controller.puntuacion=0;
		controller.contador=1;
		
	}
	
}
