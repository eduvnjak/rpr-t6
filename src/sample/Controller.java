package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import org.apache.commons.validator.*;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.time.LocalDate.now;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller {
    public TextField firstNameField;
    public ComboBox mjestoRodjenjaField;
    public TextField adressField;
    public TextField phoneNumberField;
    public ChoiceBox odsjekChoiceBox;
    public ChoiceBox godinaChoiceBox;
    public ChoiceBox ciklusChoiceBox;
    public Button potvrdiBtn;
    public RadioButton redovanBtn;
    public RadioButton samofinansirajuciBtn;
    public Button okBtn;
    public DatePicker date;
    public TextField jmbgField;
    private boolean jmbgValid;
    private boolean phoneNumberValid;
    private boolean firstNameValid;
    public TextField lastNameField;
    private boolean lastNameValid;
    public TextField indexNumberField;
    private boolean indexNumberValid;
    public TextField emailField;
    private boolean emailValid;
    private boolean validJmbg(String n){
        if(n.length() != 13) return false;
        for (int i = 0; i < n.length(); i++) {
            if(!isDigit(n.charAt(i))) return false;
        }
        return true;
    }
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
    private boolean validPhoneNumber(String n){
        if(n.length() == 0) return true;
        for (int i = 0; i < n.length(); i++) {
            if(!isDigit(n.charAt(i))) return false;
        }
        return true;
    }
    private boolean validDate(){
        if(date.getValue() == null) return false;
        LocalDate d = date.getValue();
        if(d.isAfter(now())) return false;
        String s1 = jmbgField.getText();
        String s2 = d.toString();
        if(!s1.substring(0,2).equals(s2.substring(8,10))) return false;
        if(!s1.substring(2,4).equals(s2.substring(5,7))) return false;
        if(!s1.substring(4,7).equals(s2.substring(1,4))) return false;
        return true;
    }//1998-06-02 0206998
    @FXML
    public void initialize(){
        firstNameValid = false;
        lastNameValid = false;
        indexNumberValid = false;
        phoneNumberValid = true;
        emailValid = false;
        jmbgValid = false;
        jmbgField.getStyleClass().add("poljeNijeIspravno");
        phoneNumberField.getStyleClass().add("poljeIspravno");
        firstNameField.getStyleClass().add("poljeNijeIspravno");
        lastNameField.getStyleClass().add("poljeNijeIspravno");
        indexNumberField.getStyleClass().add("poljeNijeIspravno");
        emailField.getStyleClass().add("poljeNijeIspravno");
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
        phoneNumberField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validPhoneNumber(n)) {
                    phoneNumberField.getStyleClass().removeAll("poljeNijeIspravno");
                    phoneNumberField.getStyleClass().add("poljeIspravno");
                    phoneNumberValid = true;
                } else {
                    phoneNumberField.getStyleClass().removeAll("poljeIspravno");
                    phoneNumberField.getStyleClass().add("poljeNijeIspravno");
                    phoneNumberValid = false;
                }
            }
        });
        emailField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String o, String n) {
                EmailValidator validator = EmailValidator.getInstance();
                if (validator.isValid(n)) {
                    emailField.getStyleClass().removeAll("poljeNijeIspravno");
                    emailField.getStyleClass().add("poljeIspravno");
                    emailValid = true;
                } else {
                    emailField.getStyleClass().removeAll("poljeIspravno");
                    emailField.getStyleClass().add("poljeNijeIspravno");
                    emailValid = false;
                }
            }
        });
        jmbgField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validJmbg(n)) {
                    jmbgField.getStyleClass().removeAll("poljeNijeIspravno");
                    jmbgField.getStyleClass().add("poljeIspravno");
                    jmbgValid = true;
                } else {
                    jmbgField.getStyleClass().removeAll("poljeIspravno");
                    jmbgField.getStyleClass().add("poljeNijeIspravno");
                    jmbgValid = false;
                }
            }
        });
    }
    public void potvrdi(){
        //System.out.println(date.getValue());
        //System.out.println(now());
        if(validDate() && jmbgValid && emailValid && firstNameValid && lastNameValid && indexNumberValid && phoneNumberValid && odsjekChoiceBox.getValue() != null && godinaChoiceBox.getValue() != null && ciklusChoiceBox.getValue() != null){
            System.out.println(firstNameField.getText() + " " + lastNameField.getText() + " " + indexNumberField.getText() + " " + date.getValue() + " " + emailField.getText()
                    + " " + adressField.getText() + " "+ phoneNumberField.getText() + " " + mjestoRodjenjaField.getEditor().getText());
            System.out.println(odsjekChoiceBox.getValue() + " " + godinaChoiceBox.getValue() + " " + ciklusChoiceBox.getValue());
            if(redovanBtn.isPressed()){
                System.out.println(redovanBtn.getText());
            }else{
                System.out.println(samofinansirajuciBtn.getText());
            }
            Stage stage = (Stage) potvrdiBtn.getScene().getWindow();
            stage.close();
        }else{
            //izbaci error
            Parent root = null;
            try {
                Stage myStage = new Stage();
                root = FXMLLoader.load(getClass().getResource("greska.fxml"));
                myStage.setTitle("Greška");
                myStage.setResizable(false);
                myStage.setScene(new Scene(root, USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
                myStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
