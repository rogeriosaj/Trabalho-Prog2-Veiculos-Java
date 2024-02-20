package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Operator;
import util.Dao;

public class ListarOperadoresController implements Initializable {
    
    @FXML
    private ListView<Operator> listaOperadores;

    private final Dao<Operator> operadorDao = new Dao<>(Operator.class);

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        carregarListaOperadores();
    }

    private void carregarListaOperadores() {
        List<Operator> operadores = operadorDao.listarTodos();
        listaOperadores.getItems().addAll(operadores);
    }

    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
