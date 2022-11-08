package dad.ahorcado.palabras;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.ahorcado.partidas.PartidasController;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PalabrasController implements Initializable {

		// model

		private ListProperty<String> palabras = new SimpleListProperty<>(FXCollections.observableArrayList());
		private PalabrasLogica logica = new PalabrasLogica(); 
		
		
		PartidasController partida=new PartidasController();
		
		
		StringProperty palabra= new SimpleStringProperty();
		
		// view

		public StringProperty getPalabra() {
			return palabra;
		}

		public void setPalabra(StringProperty palabra) {
			this.palabra = palabra;
		}

		@FXML
		private BorderPane view;

		@FXML
		private Button nuevoButton;

		@FXML
		private ListView<String> palabrasList;

		@FXML
		private Button quitarButton;
		
		  private TextField anadirNuevaPalabra;

		    @FXML
		    private HBox viewScene;

		    @FXML
		    private Button anadirButton;
	    

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
			palabra.set(logica.palabraElegida());
			palabras.add(palabra.get());
			palabrasList.itemsProperty().bind(palabras);
			

		}

		public BorderPane getView() {
			return view;
		}

		@FXML
		void onNuevoAction(ActionEvent event) throws IOException {

//			AnadirScene scene= new AnadirScene();			
//			scene.getViewScene();
			
//			try {
//			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/FXML/anadirScene.fxml"));
//			Parent root1= (Parent)fxmlLoader.load();
//			Stage stage= new Stage();
//			stage.setScene(new Scene(viewScene));
//			stage.show();
//			
//			palabras.add(anadirNuevaPalabra.getText());
			palabras.add(logica.palabraElegida());
			partida.palabraSecreta(palabra.get());
//			}
//			catch (Exception e) {
//			e.printStackTrace();
//			}
		}

		@FXML
	    void onClick(ActionEvent event) {

	    }
		
		@FXML
		void onQuitarAction(ActionEvent event) {
			int selectedIdx = palabrasList.getSelectionModel().getSelectedIndex();
			palabrasList.getItems().remove(selectedIdx);
			logica.remover(selectedIdx);
			
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
