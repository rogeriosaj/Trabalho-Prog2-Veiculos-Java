
package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.User;

public class NovoMotoristaController {
    @FXML
    private TextField campoNome; 
    
    @FXML
    private TextField campoEndereco; 
    
    @FXML
    private TextField campoCnh; 
    
    @FXML
    private TextField campoCategoria; 
    
    @FXML
    private TextField campoSetor; 
    
    
    
    @FXML
    private void cadastrarMotorista(){
        User user = new User();
        user.setName(campoNome.getText());
        user.setAddress(campoEndereco.getText());
        user.setDriverLicense(Long.valueOf(campoCnh.getText()));
        user.setCategory(campoCategoria.getText());
        user.setDepartment(campoSetor.getText());
        limparCampos();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("user cadastrado");
        alert.show();
    }
    
    @FXML
    private void limparCampos(){
        campoNome.setText("");
        campoEndereco.setText("");
        campoCnh.setText("");
        campoCategoria.setText("");
        campoSetor.setText("");
    }
      
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
    
}