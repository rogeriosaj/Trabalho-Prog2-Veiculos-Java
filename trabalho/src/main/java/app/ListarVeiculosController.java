package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Vehicle;
import util.Dao;

public class ListarVeiculosController implements Initializable{

    @FXML
    private ListView<Vehicle> listaVeiculos;

    private Dao<Vehicle> veiculoDao = new Dao<>(Vehicle.class);

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        carregarListaVeiculos();
    }

    private void carregarListaVeiculos() {
        List<Vehicle> veiculos = veiculoDao.listarTodos();
        listaVeiculos.getItems().addAll(veiculos);
    }

    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
