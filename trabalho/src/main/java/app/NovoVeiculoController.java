package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Vehicle;
import util.Dao;

public class NovoVeiculoController {
    @FXML
    private TextField campoMarca; 
    
    @FXML
    private TextField campoModelo; 
    
    @FXML
    private TextField campoPlaca;
    
    @FXML
    private void cadastrarVeiculo(){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(campoMarca.getText());
        vehicle.setModel(campoModelo.getText());
        vehicle.setPlate(campoPlaca.getText());
        Dao<Vehicle> dao = new Dao(Vehicle.class);
        dao.inserir(vehicle);
        limparCampos();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Veículo cadastrado");
        alert.show();
    }
    
    @FXML
    private void limparCampos(){
        campoMarca.setText("");
        campoModelo.setText("");
        campoPlaca.setText("");
    }
      
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
    
}
