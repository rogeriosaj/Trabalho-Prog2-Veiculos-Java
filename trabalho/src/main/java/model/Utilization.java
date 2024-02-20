package model;

import java.util.Date;
import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import util.Persistivel;

@Entity
@Table(name = "uso_veiculo")

public class Utilization implements Register, Serializable, Persistivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @JoinColumn(name = "veiculo", referencedColumnName = "codigo")
    @ManyToOne
    private Vehicle vehicle;
    @JoinColumn(name = "motorista", referencedColumnName = "codigo")
    @ManyToOne
    private User user;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate firstDayOfUse;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate lastDayOfUse;

    public Utilization(Vehicle vehicle, User user, LocalDate firstDayOfUse, LocalDate lastDayOfUse) {
        this.vehicle = vehicle;
        this.user = user;
        this.firstDayOfUse = firstDayOfUse;
        this.lastDayOfUse = lastDayOfUse;
    }

    public Utilization(){
        this.vehicle = null;
        this.user = null;
        this.firstDayOfUse = null;
        this.lastDayOfUse = null;
    }

    @Override
    public void registerCheckOut(LocalDate firstDayOfUse) {
        this.firstDayOfUse = firstDayOfUse;
    }

    @Override
    public void registerCheckIn(LocalDate lastDayOfUse) {
        this.lastDayOfUse = lastDayOfUse;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getFirstDayOfUse() {
        return firstDayOfUse;
    }

    public void setFirstDayOfUse(LocalDate firstDayOfUse) {
        this.firstDayOfUse = firstDayOfUse;
    }

    public LocalDate getLastDayOfUse() {
        return lastDayOfUse;
    }

    public void setLastDayOfUse(LocalDate lastDayOfUse) {
        this.lastDayOfUse = lastDayOfUse;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return vehicle.getModel() + " - " + user.getName();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + Objects.hashCode(this.vehicle);
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
        final Utilization other = (Utilization) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.vehicle, other.vehicle);
    }
}

