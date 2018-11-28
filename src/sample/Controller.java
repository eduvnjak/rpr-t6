package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class Controller {
    public TextField firstNameField;
    private boolean firstNameValid;
    public TextField lastNameField;
    private boolean lastNameValid;
    public TextField indexNumberField;
    private boolean indexNumberValid;
    public TextField emailField;
    private boolean emailValid;
    private boolean validName(String n){
        if(n.length() == 0 || n.length() > 20) return false;
        for (int i = 0; i < n.length() ; i++) {
            if(!isLetter(n.charAt(i))) return false;
        }
        return true;
    }
    private boolean validIndexNumber(String n){
        if(n.length() == 0 ) return false;
        for (int i = 0; i < n.length() ; i++) {
            if(!isDigit(n.charAt(i))) return false;
        }
        return true;
    }
    @FXML
    public void initialize(){
        firstNameValid = false;
        lastNameValid = false;
        indexNumberValid = false;
        //emailValid = false;
        firstNameField.getStyleClass().add("poljeNijeIspravno");
        lastNameField.getStyleClass().add("poljeNijeIspravno");
        indexNumberField.getStyleClass().add("poljeNijeIspravno");
        //emailField.getStyleClass().add("poljeNijeIspravno");
        firstNameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validName(n)) {
                    firstNameField.getStyleClass().removeAll("poljeNijeIspravno");
                    firstNameField.getStyleClass().add("poljeIspravno");
                    firstNameValid = true;
                } else {
                    firstNameField.getStyleClass().removeAll("poljeIspravno");
                    firstNameField.getStyleClass().add("poljeNijeIspravno");
                    firstNameValid = false;
                }
            }
        });
        lastNameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validName(n)) {
                    lastNameField.getStyleClass().removeAll("poljeNijeIspravno");
                    lastNameField.getStyleClass().add("poljeIspravno");
                    lastNameValid = true;
                } else {
                    lastNameField.getStyleClass().removeAll("poljeIspravno");
                    lastNameField.getStyleClass().add("poljeNijeIspravno");
                    lastNameValid = false;
                }
            }
        });
        indexNumberField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validIndexNumber(n)) {
                    indexNumberField.getStyleClass().removeAll("poljeNijeIspravno");
                    indexNumberField.getStyleClass().add("poljeIspravno");
                    indexNumberValid = true;
                } else {
                    indexNumberField.getStyleClass().removeAll("poljeIspravno");
                    indexNumberField.getStyleClass().add("poljeNijeIspravno");
                    indexNumberValid = false;
                }
            }
        });
        /*
        emailField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String o, String n) {
                EmailValidator validator = EmailValidator.getInstance();
                if (validator.isValid(n)) {
                    emailField.getStyleClass().removeAll("poljeNijeIspravno");
                    emailField.getStyleClass().add("poljeIspravno");
                } else {
                    emailField.getStyleClass().removeAll("poljeIspravno");
                    emailField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });*/
    }
    public void potvrdi(){
        if(firstNameValid && lastNameValid && indexNumberValid){
            System.out.println(firstNameField.getText() + " " + lastNameField.getText() + " " + indexNumberField.getText());
        }
    }
}
