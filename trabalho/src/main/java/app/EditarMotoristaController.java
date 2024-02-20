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
import model.User;
import util.Dao;
import util.ExclusaoException;

public class EditarMotoristaController {

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
    private ComboBox<User> comboUsers;

    private ObservableList<User> listaOb;
    private List<User> lista;
    private Dao<User> dao;

    @FXML
    private void initialize() {
        dao = new Dao(User.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboUsers.setItems(listaOb);
    }

    @FXML
    private void editarMotorista() {
        User temp = comboUsers.getSelectionModel().getSelectedItem();
        if(temp != null) {
            try {
                temp.setName(campoNome.getText());
                temp.setAddress(campoEndereco.getText());
                temp.setDriverLicense(Long.valueOf(campoCnh.getText()));
                temp.setCategory(campoCategoria.getText());
                temp.setDepartment(campoSetor.getText());     
                Dao<User> dao = new Dao(User.class);
                dao.alterar(temp);
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Motorista editado");
                alert.show();
                
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Motorista não pode ser editado");
                alert.show();
            }
        }
        // atualiza a lista 
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboUsers.setItems(listaOb);
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }

}
