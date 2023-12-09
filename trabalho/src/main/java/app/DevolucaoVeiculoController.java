package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
//import model.Operator;

public class DevolucaoVeiculoController {
    @FXML
    private ChoiceBox<String> escolhaMotorista;

    @FXML
    private ChoiceBox<String> escolhaVeiculo;

    @FXML
    private DatePicker dataDevolucao;      
    
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
    
}