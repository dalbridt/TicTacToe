package set.tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class restartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button restartButton;

    @FXML
    private ImageView startPic;

    @FXML
    private Label winnerText;
    @FXML
    void initialize() {
        gameController.currentSym = gameController.getWinner() == 'x'? 'o':'x';
        showNewText();
        gameController.board  = new char[3][3];
        restartButton.setOnAction(event -> {
            openNewPage();
        });
    }
    private void openNewPage(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("init-view.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) restartButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));
            // currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showNewText(){
        String input = new String();
        if(gameController.hasWinner(gameController.board) == 1){
            input = "Player \"X\" wins!";
        } else if (gameController.hasWinner(gameController.board) == 2){
            input = "Player \"O\" wins!";
        } else  if(gameController.hasWinner(gameController.board) == 0) {
            input = "It's a draw!";
        }
        winnerText.setText(input);
    }
}
