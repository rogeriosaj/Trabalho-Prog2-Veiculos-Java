package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Utilization;
import util.Dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class DevolucaoVeiculoController {

    @FXML
    private ComboBox<Utilization> comboUtilizacoes;

    @FXML
    private DatePicker datePickerDevolucao;

    @FXML
    private Button botaoRegistrarDevolucao;

    @FXML
    private Button botaoCancelar;

    private Dao<Utilization> utilizacaoDao = new Dao<>(Utilization.class);

    @FXML
    public void initialize() {
        carregarUtilizacoes();
    }

    private void carregarUtilizacoes() {
        List<Utilization> utilizacoes = utilizacaoDao.listarTodos();
        comboUtilizacoes.getItems().addAll(utilizacoes);
    }

    @FXML
    public void registrarDevolucao() {
        try {
            Utilization utilizacaoSelecionada = comboUtilizacoes.getValue();
            LocalDate dataDevolucao = datePickerDevolucao.getValue();

            if (utilizacaoSelecionada == null || dataDevolucao == null) {
                exibirAlerta("Preencha todos os campos antes de registrar a devolução.");
                return;
            }

            utilizacaoSelecionada.registerCheckIn(dataDevolucao);
            utilizacaoDao.alterar(utilizacaoSelecionada);

            exibirAlerta("Devolução registrada com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
            // Trate a exceção de acordo com a sua lógica de tratamento de erros
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
