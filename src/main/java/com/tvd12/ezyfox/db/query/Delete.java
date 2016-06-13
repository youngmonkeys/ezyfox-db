/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this query to delete an record from a table
 * 
 * @author tavandung12
 *
 */
public class Delete implements Query {

    // object to delete
    private Object entity;
    
    // entity name
    private String entityName;
    
    public Delete() {}
    
    public Delete(Object entity) {
        this.entity = entity;
        this.entityName = entity.getClass().getSimpleName();
    }
    
    /*
     * (non-Javadoc)
     * @see com.tvd12.ezyfox.db.Query#execute(org.hibernate.Session)
     */
    @SuppressWarnings("unchecked")
    public Boolean execute(Session session) {
        session.delete(entityName, entity);
        return Boolean.TRUE;
    }
    
    public Delete entity(Object entity) {
        this.entity = entity;
        return this;
    }
    
    public Delete entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }
    
}
