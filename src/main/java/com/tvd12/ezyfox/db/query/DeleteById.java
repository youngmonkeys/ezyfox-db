/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.io.Serializable;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this query to delete an record from a table by it's id
 * 
 * @author tavandung12
 *
 */
public class DeleteById implements Query {

    private Serializable id;
    private Class<?> entityClass;
    
    public DeleteById() {this(null, null);}
    
    public DeleteById(Serializable id, Class<?> entityClass) {
        this.id = id;
        this.entityClass = entityClass;
    }
    
    @SuppressWarnings("unchecked")
    public Boolean execute(Session session) {
        Object object = session.load(entityClass, id);
        session.delete(object);
        return Boolean.TRUE;
    }
    
    public DeleteById id(Serializable id) {
        this.id = id;
        return this;
    }
    
    public DeleteById entityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
        return this;
    }
}
