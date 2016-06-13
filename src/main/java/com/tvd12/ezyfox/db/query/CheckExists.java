/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this an entity with specific columns (name) and their values
 * 
 * @author tavandung12
 *
 */
public class CheckExists implements Query {

    private FetchListByField fetchListByField
            = new FetchListByField();
    
    public CheckExists() {this("");}
    
    public CheckExists(String entityName) {
        fetchListByField.entityName(entityName);
    }
    
    public CheckExists(Class<?> entityClass) {
        this(entityClass.getSimpleName());
    }
    
    @SuppressWarnings("unchecked")
    public Boolean execute(Session session) {
        return !fetchListByField.execute(session).isEmpty();
    }
    
    public CheckExists entityName(String entityName) {
        fetchListByField.entityName(entityName);
        return this;
    }
    
    public CheckExists entityClass(Class<?> entityClass) {
        return entityName(entityClass.getSimpleName());
    }
    
    public CheckExists field(String name, Object value) {
        fetchListByField.field(name, value);
        return this;
    }
}
