package set.tictactoe;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class gameController {

    @FXML
    private Button b0_0;

    @FXML
    private Button b0_1;

    @FXML
    private Button b0_2;

    @FXML
    private Button b1_0;

    @FXML
    private Button b1_1;

    @FXML
    private Button b1_2;

    @FXML
    private Button b2_0;

    @FXML
    private Button b2_1;

    @FXML
    private Button b2_2;

    @FXML
    private GridPane grid;
    public static char currentSym = 'x';

    public static char[][] board = new char[3][3];
    public static int hasWinner(char[][] board) {
        if ((board[0][0] == 'x' || board[0][0] == 'o') && (board[0][0] == board[0][1] && board[0][0] == board[0][2])) {
            if (board[0][0] == 'x') {
                return 1;
            } else {
                return 2;
            }
        } else if ((board[1][0] == 'x' || board[1][0] == 'o')
                && (board[1][0] == board[1][1] && board[1][0] == board[1][2])) {
            if (board[1][0] == 'x') {
                return 1;
            } else {
                return 2;
            }
        }
        if ((board[2][0] == 'x' || board[2][0] == 'o') && (board[2][0] == board[2][1] && board[2][0] == board[2][2])) {
            if (board[2][0] == 'x') {
                return 1;
            } else {
                return 2;
            }
        } else if ((board[0][0] == 'x' || board[0][0] == 'o')
                && (board[0][0] == board[1][0] && board[0][0] == board[2][0])) {
            if (board[0][0] == 'x') {
                return 1;
            } else {
                return 2;
            }
        } else if ((board[0][1] == 'x' || board[0][1] == 'o')
                && (board[0][1] == board[1][1] && board[0][1] == board[2][1])) {
            if (board[0][1] == 'x') {
                return 1;
            } else {
                return 2;
            }
        } else if ((board[0][2] == 'x' || board[0][2] == 'o')
                && (board[0][2] == board[1][2] && board[0][2] == board[2][2])) {
            if (board[0][2] == 'x') {
                return 1;
            } else {
                return 2;
            }
        } else if ((board[0][0] == 'x' || board[0][0] == 'o')
                && (board[0][0] == board[1][1] && board[0][0] == board[2][2])) {
            if (board[0][0] == 'x') {
                return 1;
            } else {
                return 2;
            }
        } else if ((board[0][2] == 'x' || board[0][2] == 'o')
                && (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
            if (board[0][2] == 'x') {
                return 1;
            } else {
                return 2;
            }
        } else
            return 0;
    }

    @FXML
    void buttonClick(ActionEvent event){
        Button btn = (Button) event.getSource();
        if(hasWinner(board) != 0 ) {
            openNewPage();
            return;
        } else if (btn.getText() != "" && !noEmptyCell()) {
            return;
        } else if(noEmptyCell()){
            openNewPage();
            return;
        }
        int row = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
            int col = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

            board[row][col] = currentSym;

            btn.setText(String.valueOf(currentSym));
            currentSym = currentSym == 'x' ? 'o' : 'x';

    }
    private void openNewPage(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("restart-view.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) grid.getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static char getWinner(){
        return currentSym;
    }

    public static boolean noEmptyCell(){
        boolean result = true ;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] != 'x' && board[i][j] != 'o') {
                    result = false;
                    break;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(" we have no empty cell: " + result);

        return result;
    }


    @FXML
    void initialize() {

    }

}
