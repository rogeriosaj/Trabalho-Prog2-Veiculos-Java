
package util;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Operator;

/**
 *
 * @author José 
 * Métodos adicionais específicos de Operator que não existem na classe genérica Dao.java
 */

public class DaoOperador implements Serializable{
    EntityManager manager;
    
    public Operator autenticar(String login, String senha) {
        Operator temp = null;
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT o FROM Operator o WHERE o.login = :login AND o.senha = :senha";
        TypedQuery<Operator> query = manager.createQuery(sql, Operator.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  
            temp = null; 
        } finally {
            manager.close();
        }
        return temp;
    }
    
    public boolean jaExiste(String login) {
        Operator temp = null;
        boolean existe = false; 
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT o FROM Operator o WHERE o.login = :login";
        TypedQuery<Operator> query = manager.createQuery(sql, Operator.class);
        query.setParameter("login", login);
        try {
            temp = query.getSingleResult();
            existe = true; 
        } catch (Exception e) {  
            temp = null; 
        } finally {
            manager.close();
        }
        return existe;
    }
    
}