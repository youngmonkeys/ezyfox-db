/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this command to delete all records in a tables
 * 
 * @author tavandung12
 *
 */
public class DeleteAll implements Query {

    private String entityName;
    
    public DeleteAll() {this("");}
    
    public DeleteAll(String entityName) {
        this.entityName = entityName;
    }
    
    public DeleteAll(Class<?> entityClass) {
        this(entityClass.getSimpleName());
    }
    
    @SuppressWarnings("unchecked")
    public Boolean execute(Session session) {
        session.createQuery("DELETE FROM " + entityName)
            .executeUpdate();
        return Boolean.TRUE;
    }
    
    public DeleteAll entityClass(Class<?> clazz) {
        return entityName(clazz.getSimpleName());
    }
    
    public DeleteAll entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }
    
}
