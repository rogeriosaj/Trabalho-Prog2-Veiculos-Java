package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operador")
@DiscriminatorValue("operador")

public class Operator extends Person{
    @Column(length = 15)
    private String username;
    @Column(length = 15)
    private String password;

    public Operator(String name, String address, String username, String password) {
        super(name, address);
        this.username = username;
        this.password = password;
    }

    public Operator(){
        super();
        this.username = null;
        this.password = null;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.password);
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
        final Operator other = (Operator) obj;
        if (!Objects.equals(this.username, other.password)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }
}
