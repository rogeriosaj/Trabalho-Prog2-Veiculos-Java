package app;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Vehicle;
import util.Dao;
import java.util.List;

import java.io.IOException;

public class ListarVeiculosController {

    @FXML
    private ListView<String> listaVeiculos;

    private Dao<Vehicle> VeiculoDao;

    @FXML
    private void initialize() {
        VeiculoDao = new Dao(Vehicle.class);
        List<Vehicle> veiculos = VeiculoDao.listarTodos();
        List<String> listaVeiculos = FXCollections.observableArrayList();
        for (Vehicle veiculo : veiculos) {
            listaVeiculos.add(veiculo.getBrand() + " -- " + veiculo.getModel() + " -- " + veiculo.getPlate());
        }
        this.listaVeiculos.getItems().addAll(listaVeiculos);
    }

    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
