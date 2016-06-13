/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this query to update an record in a table
 * 
 * @author tavandung12
 *
 */
public class Update implements Query {

    private Object entity;
    private String entityName;
    
    public Update() {}
    
    public Update(Object entity) {
        this.entity = entity;
        this.entityName = entity.getClass().getSimpleName();
    }
    
    @SuppressWarnings("unchecked")
    public <T> T execute(Session session) {
        session.update(entityName, entity);
        return (T)entity;
    }
    
    public Update entity(Object entity) {
        this.entity = entity;
        return this;
    }
    
    public Update entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }
    
}
