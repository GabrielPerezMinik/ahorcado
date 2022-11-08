package dad.ahorcado.partidas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import dad.ahorcado.palabras.PalabrasController;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PartidasController implements Initializable {

	//PalabrasController palabrascontrol= new  PalabrasController();
	Partidalogica logica= new Partidalogica();
	StringProperty palabra= new SimpleStringProperty();
	
	static int contador = 8;
	static int puntuacion=100;
	
	@FXML
	private ImageView ahorcadoImagen;

	@FXML
	private Button letraButton;

	@FXML
	private Label palabraAdivinarlabel;

	@FXML
	private Label palabrasUsadaslabel;

	@FXML
	private Label puntoLetraLabel;

	@FXML
	private Label puntoPalabrasLabel;

	@FXML
	private Button resolverButton;

	@FXML
	private TextField textoLetratextField;

	@FXML
	private BorderPane view;

	public PartidasController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PartidaView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		palabraAdivinarlabel.setText(palabra.get());
		palabraAdivinarlabel.textProperty().addListener((o,ov,nv)-> palabraSecreta(palabra.get()));
		
	}

	@FXML
	void onLetra(ActionEvent event) throws FileNotFoundException {

		palabraSecreta(palabra.get());
		if(true) {}
		else {}
		resultImage();

	}



	
	@FXML
	void onResolver(ActionEvent event) {

//		System.out.println(palabra.get());
		int resolver=palabra.get().compareToIgnoreCase((textoLetratextField.getText()));
//		System.out.println(resolver);
		if(resolver==0) {
			
			System.out.println("es correcto");
			
		}
		else {
			System.out.println(contador+=1);
			resultImage();
		}
		
	}

	public void palabraSecreta(String llegada) {
		char[] gi = new char[llegada.length()];
		String llegoString = "";
		for (int i = 0; i < llegada.length(); i++) {
			gi[i] = '_';
		}

		for (int i = 0; i < gi.length; i++) {

			llegoString=llegoString +gi[i];
			
		}
		palabraAdivinarlabel.setText(llegoString);
	}

	public BorderPane getView() {
		return view;
	}

	
	private void resultImage() {
		switch (contador) {

		case 1: {

			ahorcadoImagen.setImage(new Image("/images/1.png"));
			break;
		}
		case 2: {

			ahorcadoImagen.setImage(new Image("/images/2.png"));
			break;
		}
		case 3: {

			ahorcadoImagen.setImage(new Image("/images/3.png"));
			break;
		}
		case 4: {

			ahorcadoImagen.setImage(new Image("/images/4.png"));
			break;
		}
		case 5: {

			ahorcadoImagen.setImage(new Image("/images/5.png"));
			break;
		}
		case 6: {

			ahorcadoImagen.setImage(new Image("/images/6.png"));
			break;
		}
		case 7: {

			ahorcadoImagen.setImage(new Image("/images/7.png"));
			break;
		}
		case 8: {

			ahorcadoImagen.setImage(new Image("/images/8.png"));
			break;
		}
		case 9: {

			ahorcadoImagen.setImage(new Image("/images/9.png"));
			Alert alertaFin= new Alert(AlertType.INFORMATION);
			alertaFin.setTitle("Fin del Juego");
			alertaFin.setHeaderText("Se te han acabado las vidas! \nConseguiste un total de :" + puntuacion +"PTS");
			alertaFin.setContentText("la palabra era: "+palabra.get().toUpperCase()+"\nIntentalo de nuevo en otra partida");
			alertaFin.show();
			logica.reset();
			break;
		}
		 default:
			 	ahorcadoImagen.setImage(new Image("/images/1.png"));
			    System.out.println("siendo default");
		}
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
