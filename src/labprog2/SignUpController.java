/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labprog2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import labprog2.DataBase.User;
import labprog2.DataBase.UserDAO;

/**
 *
 * @author USER
 */
public class SignUpController implements Initializable {
    
    @FXML
    private Button sendButton;
    
    @FXML
    private TextField nameField,eMailField,loginField;
    
    @FXML
    private PasswordField passField;
    
    @FXML
    private Label resultLabel;
    
    @FXML
    private void sendButtonClick(ActionEvent event) {
        User u = new User();
        UserDAO uDao = new UserDAO();
        
        u.setNome(nameField.getText());
        u.setLogin(loginField.getText());
        u.setEMail(eMailField.getText());
        u.setPassword(passField.getText());
        
        if(uDao.insere(u))
            resultLabel.setText("Usuário criado com sucesso!");
        else
            resultLabel.setText("Login ou e-mail já utilizado!");
    }
    
    @FXML
    private void cancelButtonClick(ActionEvent event) throws IOException{
        Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene main_Scene = new Scene(main);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(main_Scene);
        app_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
