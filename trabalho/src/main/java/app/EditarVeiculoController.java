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
import model.Vehicle;
import util.Dao;
import util.ExclusaoException;

public class EditarVeiculoController {

    @FXML
    private TextField campoMarca; 
    
    @FXML
    private TextField campoModelo; 
    
    @FXML
    private TextField campoPlaca;

    @FXML
    private ComboBox<Vehicle> comboVehicles;

    private ObservableList<Vehicle> listaOb;
    private List<Vehicle> lista;
    private Dao<Vehicle> dao;

    @FXML
    private void initialize() {
        dao = new Dao(Vehicle.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVehicles.setItems(listaOb);
    }

    @FXML
    private void editarVeiculo() {
        Vehicle temp = comboVehicles.getSelectionModel().getSelectedItem();
        if(temp != null) {
            try {
                temp.setBrand(campoMarca.getText());
                temp.setModel(campoModelo.getText());
                temp.setPlate(campoPlaca.getText());     
                Dao<Vehicle> dao = new Dao(Vehicle.class);
                dao.alterar(temp);
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Veiculo editado");
                alert.show();
                
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Veiculo não pode ser editado");
                alert.show();
            }
        }
        // atualiza a lista 
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVehicles.setItems(listaOb);
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }

}
