package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motorista")
@DiscriminatorValue("motorista")

public class User extends Person{
    @Column
    private Long driverLicense;
    @Column(length = 15)
    private String department;
    @Column(length = 15)
    private String category;

    public User(String name, String address, Long driverLicense, String department, String category) {
        super(name, address);
        this.driverLicense = driverLicense;
        this.department = department;
        this.category = category;
    }

    public User(){
        super();
        this.driverLicense = null;
        this.department = null;
        this.category = null;
    }

    public Long getDriverLicense() {
        return driverLicense;
    }

    public String getDepartment(){
        return department;
    }

    public String getCategory(){
        return category;
    }

    public void setDriverLicense(Long driverLicense) {
        this.driverLicense = driverLicense;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setCategory(String category){
        this.category = category;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.driverLicense);
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
        final User other = (User) obj;
        return Objects.equals(this.driverLicense, other.driverLicense);
    }

}
