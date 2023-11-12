package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class VehicleManagementSys {
    private List<Vehicle> vehicles;
    private List<User> users;
    private List<Operator> operators;

    public VehicleManagementSys(){
        vehicles = new ArrayList<>();
        users = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addOperator(Operator operator){
        operators.add(operator);
    }

    //Função para registrar a retirada de um veículo
    public void checkOutVehicle (Vehicle vehicle, String username, String operatorUsername, String operatorPassword){
        
        Operator operator = null;
        for (Operator op : operators) {
            if (op.getUsername().equals(operatorUsername) && op.getPassword().equals(operatorPassword)) {
                operator = op;
            }
        }
        if (operator == null) {
            throw new RuntimeException("Operador não encontrado.");
        }

        User user = null;
        for (User u : users) {
            if (u.getName().equals(username)) {
                user = u;
            }
        }
        if (user == null) {
            throw new RuntimeException("Usuário não encontrado.");
        }

        if (vehicle.isBeingUsed()) {
            throw new RuntimeException("O veículo já está sendo usado.");
        }

        vehicle.checkOut(user.getName());
        //Utilization utilization = new Utilization(vehicle, user, new Date());
    }

    public void checkInVehicle(Vehicle vehicle) {
        vehicle.checkIn();
    }

    //Função para verificar o motorista de determinado carro em determinada data
    public User getDriverForVehicle(Vehicle vehicle, Date date) {
        if (vehicle.isBeingUsed() && vehicle.getLastUsage().equals(date)) {
            for (User user : users) {
                if (user.getName().equals(vehicle.getCurrentUser())) {
                    return user;
                }
            }
        }
        return null;
    }
}
