package set.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class initController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startButton;

    @FXML
    private ImageView startPic;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {
    startButton.setOnAction(event -> {
            openNewPage();
        });

    }
    private void openNewPage(){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) startButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));
            // currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
