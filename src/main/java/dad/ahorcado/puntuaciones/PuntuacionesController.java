package dad.ahorcado.puntuaciones;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class PuntuacionesController implements Initializable{

	@FXML
	private ListView<String> puntuacionListView;

	private ListProperty<String> palabras = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	@FXML
	private VBox view;

	public PuntuacionesController() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PuntuacionesView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		puntuacionListView.itemsProperty().bind(palabras);
		
		palabras.add("PALABRA");
		palabras.add("hola");
		palabras.add("PALABRA");
		palabras.add("hola");
		palabras.add("PALABRA");
		palabras.add("hola");
		palabras.add("PALABRA");
		palabras.add("hola");
		palabras.add("PALABRA");
		palabras.add("hola");
		
	}

	public VBox getView() {
		return view;
	}

}
