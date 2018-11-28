package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class greskaController {
    public void zatvori(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }
}
