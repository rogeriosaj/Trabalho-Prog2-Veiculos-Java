package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import model.User;
import util.Dao;
import util.ExclusaoException;

public class ExcluirMotoristaController {

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
    private void excluirMotorista() {
        User temp = comboUsers.getSelectionModel().getSelectedItem();
        try {
            dao.excluir(temp);            
        } catch (ExclusaoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User não pode ser excluído");
            alert.show();
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