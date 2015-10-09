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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MainController implements Initializable {
    
    @FXML
    private Button signupButton,signinButton;
    @FXML
    private void signUpClick(ActionEvent event) throws IOException{
        Parent signUp = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene signUp_Scene = new Scene(signUp);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(signUp_Scene);
        app_stage.show();
    }
    
    @FXML
    private void signInClick(ActionEvent event) throws IOException{
        Parent signIn = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene signIn_Scene = new Scene(signIn);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(signIn_Scene);
        app_stage.show();
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
