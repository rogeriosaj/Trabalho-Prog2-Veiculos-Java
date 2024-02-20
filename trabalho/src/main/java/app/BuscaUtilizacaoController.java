package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Vehicle;
import model.User;
import model.Utilization;
import util.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class BuscaUtilizacaoController {

    @FXML
    private ComboBox<Vehicle> comboVeiculos;

    @FXML
    private DatePicker datePickerConsulta;

    @FXML
    private Button botaoConsultar;

    @FXML
    private Button botaoCancelar;

    private Dao<Vehicle> veiculoDao = new Dao<>(Vehicle.class);

    @FXML
    public void initialize() {
        carregarVeiculos();
    }

    private void carregarVeiculos() {
        List<Vehicle> veiculos = veiculoDao.listarTodos();
        comboVeiculos.getItems().addAll(veiculos);
    }

    @FXML
    public void consultarUtilizacao() {
        try {
            Vehicle veiculoSelecionado = comboVeiculos.getValue();
            LocalDate dataConsulta = datePickerConsulta.getValue();

            if (veiculoSelecionado == null || dataConsulta == null) {
                exibirAlerta("Selecione um veículo e informe a data para consultar.");
                return;
            }

            String motorista = buscarMotorista(veiculoSelecionado, dataConsulta);

            if (motorista != null) {
                exibirAlerta("Motorista: " + motorista);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private String buscarMotorista(Vehicle veiculo, LocalDate dataConsulta) {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("veiculosPU");

    
        EntityManager em = emf.createEntityManager();

        try {
        
            String jpql = "SELECT u FROM Utilization u WHERE u.vehicle = :veiculo AND :dataConsulta BETWEEN u.firstDayOfUse AND u.lastDayOfUse";

        try {
            Utilization utilizacao = em.createQuery(jpql, Utilization.class)
                    .setParameter("veiculo", veiculo)
                    .setParameter("dataConsulta", dataConsulta)
                    .getSingleResult();

            
            return utilizacao.getUser().getName();
        } catch (NoResultException e) {
            
            exibirAlerta("O veículo não foi utilizado na data especificada.");
            return null;
        }

    } finally {

        em.close();
    }
}


    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }

    private void exibirAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informação");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
