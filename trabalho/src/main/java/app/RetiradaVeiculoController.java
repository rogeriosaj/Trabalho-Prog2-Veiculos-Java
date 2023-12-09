package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

public class RetiradaVeiculoController {
    @FXML
    private ChoiceBox<String> escolhaMotorista;

    @FXML
    private ChoiceBox<String> escolhaVeiculo;

    @FXML
    private DatePicker dataRetirada;      
    
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
    
}