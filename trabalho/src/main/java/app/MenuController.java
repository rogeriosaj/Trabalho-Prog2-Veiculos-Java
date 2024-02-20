package app;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;


public class MenuController {
    
    @FXML
    private void cadastrarMotorista() throws IOException {
        App.setRoot("novoMotorista");
    }

    @FXML
    private void listarMotoristas() throws IOException {
        App.setRoot("listarMotoristas");
    }

    @FXML
    private void excluirMotorista() throws IOException{
        App.setRoot("excluirMotorista");
    }

    @FXML
    private void cadastrarVeiculo() throws IOException {
        App.setRoot("novoVeiculo");
    }

    @FXML
    private void listarVeiculos() throws IOException {
        App.setRoot("listarVeiculos");
    }

    @FXML
    private void excluirVeiculo() throws IOException{
        App.setRoot("excluirVeiculo");
    }

    @FXML
    private void cadastrarOperador() throws IOException {
        App.setRoot("novoOperador");
    }

    @FXML
    private void cadastrarOperadorLogin() throws IOException {
        App.setRoot("novoOperadorLogin");
    }

    @FXML
    private void listarOperadores() throws IOException {
        App.setRoot("listarOperadores");
    }
    
    @FXML
    private void excluirOperador() throws IOException{
        App.setRoot("excluirOperador");
    }

    @FXML
    private void retirarVeiculo() throws IOException {
        App.setRoot("retiradaVeiculo");
    }    

    @FXML
    private void buscarUtilizacao() throws IOException{
        App.setRoot("buscaUtilizacao");
    }

    @FXML
    private void devolverVeiculo() throws IOException {
        App.setRoot("devolucaoVeiculo");
    }

    @FXML
    private void login() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void sair(){
        Platform.exit();
        System.exit(0);
    }
    
}