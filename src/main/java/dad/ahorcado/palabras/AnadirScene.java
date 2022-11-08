package dad.ahorcado.palabras;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AnadirScene extends PalabrasController implements Initializable {

	@FXML
    private TextField anadirNuevaPalabra;

    @FXML
    private HBox viewScene;

	@FXML
    private Button anadirButton;
	
    public AnadirScene() {
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/anadirScene.fxml"));
		loader.setController(this);
		loader.load();
//		Stage primaryStage = new Stage();
//		Parent root  = FXMLLoader.load(getClass().getResource("/FXML/anadirScene.fxml"));
//		Scene scene = new Scene(viewScene);
//		primaryStage.setScene(scene):
//		primaryStage.show();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	}
	public HBox getViewScene() {
		return viewScene;
	}
}
