package model;

import java.util.Date;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.Persistivel;

@Entity
@Table(name = "veiculo")

public class Vehicle implements Serializable, Persistivel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(length = 20)
    private String brand;
    @Column(length = 20)
    private String model;
    @Column(length = 20)
    private String plate;
    private boolean beingUsed;
    private String currentUser;
    private Date lastUsage;

    public Vehicle(String brand, String model, String plate) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.beingUsed = false;
        this.currentUser = null;
        this.lastUsage = null;
    }

    public Vehicle(){
        this.brand = null;
        this.model = null;
        this.plate = null;
        this.beingUsed = false;
        this.currentUser = null;
        this.lastUsage = null;
    }

    //Função para finalizar o uso de um veículo
    public void checkIn(){
        if (beingUsed == false) {
            throw new RuntimeException("O veículo não está sendo usado.");
        }
        beingUsed = false;
        currentUser = null;
        lastUsage = new Date();
    }

    //Função para iniciar o uso de um veículo
    public void checkOut(String user){
        if (beingUsed == true) {
            throw new RuntimeException("O veículo já está sendo usado.");
        }
        beingUsed = true;
        currentUser = user;
        lastUsage = new Date();
    }

    @Override
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public boolean isBeingUsed() {
        return beingUsed;
    }

    public String getCurrentUser(){
        return currentUser;
    }

    public Date getLastUsage(){
        return lastUsage;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.brand = model;
    }

    public void setPlate(String plate) {
        this.brand = plate;
    }

    public void setBeingUsed(boolean beingUsed) {
        this.beingUsed = beingUsed;
    }

    public void setCurrentUser(String currentUser){
        this.currentUser = currentUser;
    }

    public void setLastUsage(Date lastUsage){
        this.lastUsage = lastUsage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
        hash = 41 * hash + Objects.hashCode(this.plate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.plate, other.plate)) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }
}
