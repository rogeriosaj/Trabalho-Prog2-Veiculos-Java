package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import model.Operator;
import util.Dao;
import util.ExclusaoException;

public class ExcluirOperadorController {

    @FXML
    private ComboBox<Operator> comboOperators;

    private ObservableList<Operator> listaOb;
    private List<Operator> lista;
    private Dao<Operator> dao;

    @FXML
    private void initialize() {
        dao = new Dao(Operator.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboOperators.setItems(listaOb);
    }

    @FXML
    private void excluirOperador() {
        Operator temp = comboOperators.getSelectionModel().getSelectedItem();
        if(temp != null) {
            try {
                dao.excluir(temp);            
            } catch (ExclusaoException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Operador não pode ser excluído");
                alert.show();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Selecione um operador");
            alert.show();
        }
        // atualiza a lista 
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboOperators.setItems(listaOb);
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }

}
