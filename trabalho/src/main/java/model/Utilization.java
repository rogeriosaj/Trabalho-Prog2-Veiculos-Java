package model;

import java.util.Date;
import java.io.Serializable;
import java.util.Objects;
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
    private Date firstDayOfUse;
    @Column
    @Temporal(TemporalType.DATE)
    private Date lastDayOfUse;

    public Utilization(Vehicle vehicle, User user, Date firstDayOfUse) {
        this.vehicle = vehicle;
        this.user = user;
        this.firstDayOfUse = firstDayOfUse;
    }

    @Override
    public void registerCheckOut(Date firstDayOfUse) {
        this.firstDayOfUse = firstDayOfUse;
    }

    @Override
    public void registerCheckIn(Date lastDayOfUse) {
        this.lastDayOfUse = lastDayOfUse;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User getUser() {
        return user;
    }

    public Date getFirstDayOfUse() {
        return firstDayOfUse;
    }

    public Date getLastDayOfUse() {
        return lastDayOfUse;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

