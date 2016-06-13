/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.util.List;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this an entity with specific columns (name) and their values
 * 
 * @author tavandung12
 *
 */
public class FetchByField implements Query {

    private FetchListByField fetchListByField
            = new FetchListByField();
    
    public FetchByField() {this("");}
    
    public FetchByField(String entityName) {
        fetchListByField.entityName(entityName);
    }
    
    public FetchByField(Class<?> entityClass) {
        this(entityClass.getSimpleName());
    }
    
    @SuppressWarnings("unchecked")
    public <T> T execute(Session session) {
        List<T> items = fetchListByField.execute(session);
        if(items.isEmpty()) return null;
        return items.get(0);
    }
    
    public FetchByField entityName(String entityName) {
        fetchListByField.entityName(entityName);
        return this;
    }
    
    public FetchByField entityClass(Class<?> entityClass) {
        return entityName(entityClass.getSimpleName());
    }
    
    public FetchByField field(String name, Object value) {
        fetchListByField.field(name, value);
        return this;
    }
}
