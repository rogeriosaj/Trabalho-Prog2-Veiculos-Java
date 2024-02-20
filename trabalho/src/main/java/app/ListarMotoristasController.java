package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.User;
import util.Dao;

public class ListarMotoristasController implements Initializable {
    
    @FXML
    private ListView<User> listaMotoristas;

    private final Dao<User> motoristaDao = new Dao<>(User.class);

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        carregarListaMotoristas();
    }

    private void carregarListaMotoristas() {
        List<User> motoristas = motoristaDao.listarTodos();
        listaMotoristas.getItems().addAll(motoristas);
    }

    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
