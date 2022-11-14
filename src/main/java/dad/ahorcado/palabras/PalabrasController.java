package dad.ahorcado.palabras;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.ahorcado.partidas.PartidasController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;

public class PalabrasController implements Initializable {

		// model

		private PalabrasLogica logicaPalabra = new PalabrasLogica(); 

		// view

		@FXML
		private BorderPane view;

		@FXML
		private Button nuevoButton;

		@FXML
		private ListView<String> palabrasList;

		@FXML
		private Button quitarButton;
	    

		public PalabrasController() {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PalabrasView.fxml"));
				loader.setController(this);
				loader.load();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {

			// bindings
		
			palabrasList.itemsProperty().bindBidirectional((logicaPalabra.ListapalabrasProperty()));
			palabrasList.itemsProperty().set(logicaPalabra.ListapalabrasProperty());
//			palabra.set(logicaPalabra.palabraElegida());
//			palabras.add(palabra.get());
//			palabrasList.itemsProperty().bind(palabras);
			logicaPalabra.palabraElegida();

		}

		public BorderPane getView() {
			return view;
		}

		@FXML
		void onNuevoPalabraAction(ActionEvent event) throws IOException {
			
			
			TextInputDialog dialog = new TextInputDialog("Nueva Palabra");
			dialog.setTitle("Nueva Palabra");
			dialog.setHeaderText("Se añadira a la lista la nueva palabra que intoduzca");
			dialog.setContentText("Porfavor introduzca la nueva Palabra:");
			Optional<String> result = dialog.showAndWait();
			logicaPalabra.palabraAnadida(result.get());
					
//			palabras.add(anadirNuevaPalabra.getText());
//			palabras.add(logicaPalabra.palabraElegida());
//			partida.palabraSecreta(palabra.get());

		}
		
		@FXML
		void onQuitarAction(ActionEvent event) {
			int selectedIdx = palabrasList.getSelectionModel().getSelectedIndex();
			palabrasList.getItems().remove(selectedIdx);
			
		}
		
}
