package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import util.Persistivel;

@Entity
@Table(name = "operador")
@DiscriminatorValue("operador")

public class Operator extends Person implements Serializable, Persistivel{
    @Column(length = 15)
    private String login;
    @Column(length = 15)
    private String senha;

    public Operator(String name, String address, String login, String senha) {
        super(name, address);
        this.login = login;
        this.senha = senha;
    }

    public Operator(){
        super();
        this.login = null;
        this.senha = null;
    }


    public String getlogin(){
        return login;
    }

    public String getsenha(){
        return senha;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.login);
        hash = 83 * hash + Objects.hashCode(this.senha);
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
        if (!Objects.equals(this.login, other.senha)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }
}
