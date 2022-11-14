package dad.ahorcado.palabras;

import java.util.ArrayList;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PalabrasLogica {

	String palabraElegida;
	
	ArrayList<String> listaPalabrasArray=new ArrayList<>();
	ArrayList<String> palabrasbaneadas=new ArrayList<>();
	
	ListProperty<String> Listapalabras = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	StringProperty palabra= new SimpleStringProperty();
	
	
	public PalabrasLogica() {
		
		listaPalabrasArray.add("perico");
		listaPalabrasArray.add("palotes");
		listaPalabrasArray.add("raton");
		listaPalabrasArray.add("java");
		listaPalabrasArray.add("teclado");

		//Listapalabras.add("perico");
		
		Listapalabras.setAll(listaPalabrasArray);
		
		System.out.println(listaPalabrasArray.toString());
		
	}
	
	public String palabraElegida() {
		
		
		for (int i = 0; i < palabrasbaneadas.size(); i++) {
			for (int j = 0; j < Listapalabras.size(); j++) {
				if(palabrasbaneadas.get(i).equals(Listapalabras.get(j))) {
					System.out.println("Removida:"+Listapalabras.remove(j));
				}
			}
		}
		
		int b= (int) (Math.random()* (Listapalabras.size() - 0) + 0);
		palabraElegida=Listapalabras.get(b);
		palabrasbaneadas.add(palabraElegida);
		System.out.println(palabraElegida);
		return palabraElegida;
	}
	
	public boolean palabraAnadida(String s) {
		
		try {
		
			Listapalabras.add(s);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
//	public static void main(String[] args) {
//		PalabrasLogica pal= new PalabrasLogica();
//		pal.palabraElegida();
//		pal.palabraElegida();
//		pal.palabraElegida();
//		pal.palabraElegida();
//		pal.palabraElegida();
//		
//	}

	public final ListProperty<String> ListapalabrasProperty() {
		return this.Listapalabras;
	}
	

	public final ObservableList<String> getListapalabras() {
		return this.ListapalabrasProperty().get();
	}
	

	public final void setListapalabras(final ObservableList<String> Listapalabras) {
		this.ListapalabrasProperty().set(Listapalabras);
	}
	

	public final StringProperty palabraProperty() {
		return this.palabra;
	}
	

	public final String getPalabra() {
		return this.palabraProperty().get();
	}
	

	public final void setPalabra(final String palabra) {
		this.palabraProperty().set(palabra);
	}
	
	
}
