package dad.ahorcado.partidas;

import java.lang.ModuleLayer.Controller;

public class Partidalogica {
	Controller controller;
	static int contador=1; 
	
	public void respuestaLetra(char letra) {
		CharSequence letraRecibida= letra+"";
		if(controller.palabra.get().contains(letraRecibida)) {
			controller.puntuacion+=1;
//			revelarLetra(letra);
		}
		else {
			 controller.contador+=1;
		}
		
		controller.setTextoLetratextField(""); 
		
	}
	
	public void reset() {
		controller.puntuacion=0;
		controller.contador=1;
		controller.setTextoLetratextField(""); 
	}
	

	
//}
}