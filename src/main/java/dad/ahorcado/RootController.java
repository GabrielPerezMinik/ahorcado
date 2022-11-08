package dad.ahorcado;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.ahorcado.palabras.PalabrasController;
import dad.ahorcado.partidas.PartidasController;
import dad.ahorcado.puntuaciones.PuntuacionesController;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class RootController implements Initializable {
		
		// controllers
		
		private PalabrasController palabrasController = new PalabrasController(); 
		private PartidasController partidasController = new PartidasController();
		private PuntuacionesController puntuacionesController= new PuntuacionesController();
		
		// model
		
		private ListProperty<String> palabras = new SimpleListProperty<>(FXCollections.observableArrayList());
		
		// view
		
		@FXML
		private TabPane view;
		
		@FXML 
		private Tab partidaTab, palabrasTab, puntuacionesTab;
		
		public RootController() {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/RootView.fxml"));
				loader.setController(this);
				loader.load();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {

			palabrasTab.setContent(palabrasController.getView());
			partidaTab.setContent(partidasController.getView());
			puntuacionesTab.setContent(puntuacionesController.getView());
			
			// bindings
			
			palabrasController.palabrasProperty().bind(palabras);
			partidasController.palabraProperty().bind(palabrasController.getPalabra());
			
		}
		
		public TabPane getView() {
			return view;
		}

		public final ListProperty<String> palabrasProperty() {
			return this.palabras;
		}
		

		public final ObservableList<String> getPalabras() {
			return this.palabrasProperty().get();
		}
		

		public final void setPalabras(final ObservableList<String> palabras) {
			this.palabrasProperty().set(palabras);
		}

	}
