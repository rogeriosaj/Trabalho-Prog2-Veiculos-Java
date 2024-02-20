package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Operator;
import util.Dao;
import util.ExclusaoException;

public class EditarOperadorController {

    @FXML
    private TextField campoNome; 
    
    @FXML
    private TextField campoEndereco; 
    
    @FXML
    private TextField campoLogin;
    
    @FXML
    private TextField campoSenha; 

    @FXML
    private ComboBox<Operator> comboOperators;

    private ObservableList<Operator> listaOb;
    private List<Operator> lista;
    private Dao<Operator> dao;

    @FXML
    private void initialize() {
        dao = new Dao(Operator.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboOperators.setItems(listaOb);
    }

    @FXML
    private void editarOperador() {
        Operator temp = comboOperators.getSelectionModel().getSelectedItem();
        if(temp != null) {
            try {
                temp.setName(campoNome.getText());
                temp.setAddress(campoEndereco.getText());
                temp.setLogin(campoLogin.getText());
                temp.setSenha(campoSenha.getText());     
                Dao<Operator> dao = new Dao(Operator.class);
                dao.alterar(temp);
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Operador editado");
                alert.show();
                
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Operador não pode ser editado");
                alert.show();
            }
        }
        // atualiza a lista 
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboOperators.setItems(listaOb);
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }

}
