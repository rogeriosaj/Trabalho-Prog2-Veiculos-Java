package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Operator;
import model.User;
import util.Dao;

public class NovoOperadorController {
    @FXML
    private TextField campoNome; 
    
    @FXML
    private TextField campoEndereco; 
    
    @FXML
    private TextField campoLogin;
    
    @FXML
    private TextField campoSenha;
    
    @FXML
    private void cadastrarOperador(){
        Operator operator = new Operator();
        operator.setName(campoNome.getText());
        operator.setAddress(campoEndereco.getText());
        operator.setUsername(campoLogin.getText());
        operator.setPassword(campoSenha.getText());
        Dao<Operator> dao = new Dao(Operator.class);
        dao.inserir(operator);
        limparCampos();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Operador cadastrado");
        alert.show();
    }
    
    @FXML
    private void limparCampos(){
        campoNome.setText("");
        campoEndereco.setText("");
        campoLogin.setText("");
        campoSenha.setText("");
    }
      
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
    
}
