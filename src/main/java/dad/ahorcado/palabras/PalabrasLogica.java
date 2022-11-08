package dad.ahorcado.palabras;

import java.util.ArrayList;

public class PalabrasLogica {

	String palabraElegida;
	
	ArrayList<String> listaPalabras=new ArrayList<>();
	ArrayList<String> palabrasbaneadas=new ArrayList<>();
	
	public PalabrasLogica() {
		
		listaPalabras.add("perico");
		listaPalabras.add("palotes");
		listaPalabras.add("raton");
		listaPalabras.add("java");
		listaPalabras.add("teclado");
	}
	
	public String palabraElegida() {
		
		
		for (int i = 0; i < palabrasbaneadas.size(); i++) {
			for (int j = 0; j < listaPalabras.size(); j++) {
				if(palabrasbaneadas.get(i).equals(listaPalabras.get(j))) {
					System.out.println("Removida:"+listaPalabras.remove(j));
				}
			}
		}
		
		int b= (int) (Math.random()* (listaPalabras.size() - 0) + 0);
		palabraElegida=listaPalabras.get(b);
		palabrasbaneadas.add(palabraElegida);
		System.out.println(palabraElegida);
		return palabraElegida;
	}
	
	public void remover(int i) {
		
		listaPalabras.remove(i);
		
	}
	
	public boolean palabraAnadida(String s) {
		
		try {
		
			listaPalabras.add(s);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		PalabrasLogica pal= new PalabrasLogica();
		pal.palabraElegida();
		pal.palabraElegida();
		pal.palabraElegida();
		pal.palabraElegida();
		pal.palabraElegida();
		
	}
	
}
