package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import model.Vehicle;
import util.Dao;
import util.ExclusaoException;

public class ExcluirVeiculoController {

    @FXML
    private ComboBox<Vehicle> comboVeiculos;

    private ObservableList<Vehicle> listaOb;
    private List<Vehicle> lista;
    private Dao<Vehicle> dao;

    @FXML
    private void initialize() {
        dao = new Dao<>(Vehicle.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVeiculos.setItems(listaOb);
    }

    @FXML
    private void excluirVeiculo() {
        Vehicle temp = comboVeiculos.getSelectionModel().getSelectedItem();
        if (temp != null) {
            try {
                dao.excluir(temp);
            } catch (ExclusaoException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Veiculo não pode ser excluído");
                alert.show();
            }
        } 
        // atualiza a lista
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVeiculos.setItems(listaOb);
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
}
