package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;
import model.Utilization;
import model.Vehicle;
import util.Dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class RetiradaVeiculoController {

    @FXML
    private ComboBox<Vehicle> comboVeiculos;

    @FXML
    private ComboBox<User> comboMotoristas;

    @FXML
    private DatePicker datePickerRetirada;

    private Dao<Utilization> utilizacaoDao = new Dao<>(Utilization.class);

    @FXML
    private ObservableList<Vehicle> listaObV;
    private List<Vehicle> listaV;
    private Dao<Vehicle> daoV;

    private ObservableList<User> listaObU;
    private List<User> listaU;
    private Dao<User> daoU;


    @FXML
    public void initialize() {
        // Carregar veículos e motoristas nos ComboBoxes
        daoV = new Dao(Vehicle.class);
        listaV = daoV.listarTodos();
        listaObV = FXCollections.observableArrayList(listaV);
        comboVeiculos.setItems(listaObV);
        
        daoU = new Dao(User.class);
        listaU = daoU.listarTodos();
        listaObU = FXCollections.observableArrayList(listaU);
        comboMotoristas.setItems(listaObU);
    }

    @FXML
    public void registrarRetirada() {
        try {
            // Obter os valores selecionados nos ComboBoxes e DatePicker
            Vehicle veiculoSelecionado = comboVeiculos.getValue();
            User motoristaSelecionado = comboMotoristas.getValue();
            LocalDate dataRetirada = datePickerRetirada.getValue();

            // Validar se todos os campos foram preenchidos
            if (veiculoSelecionado == null || motoristaSelecionado == null || dataRetirada == null) {
                exibirAlerta("Preencha todos os campos antes de registrar a retirada.");
                return;
            }

            // Criar objeto Utilization
            Utilization utilizacao = new Utilization(veiculoSelecionado, motoristaSelecionado, dataRetirada, null);

            // Salvar no banco de dados
            utilizacaoDao.inserir(utilizacao);

            // Exibir mensagem de sucesso
            exibirAlerta("Retirada registrada com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exibirAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informação");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
