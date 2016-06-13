/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this query to save an object to a table
 * 
 * @author tavandung12
 *
 */
public class Save implements Query {
    
    private Object entity;
    private String entityName;
    
    public Save() {}
    
    public Save(Object entity) {
        this.entity = entity;
        this.entityName = entity.getClass().getSimpleName();
    }
    
    @SuppressWarnings("unchecked")
    public <T> T execute(Session session) {
        session.save(entityName, entity);
        return (T)entity;
    }
    
    public Save entity(Object entity) {
        this.entity = entity;
        return this;
    }
    
    public Save entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }
}
