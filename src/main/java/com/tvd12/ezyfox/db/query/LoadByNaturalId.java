/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * @author tavandung12
 *
 */
public class LoadByNaturalId implements Query {

    private Class<?> entityClass;
    private String fieldName;
    private Object fieldValue;
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T execute(Session session) {
        return (T)session.byNaturalId(entityClass)
            .using(fieldName, fieldValue)
            .load();
    }
    
    public LoadByNaturalId using(String attributeName, Object value) {
        this.fieldName = attributeName;
        this.fieldValue = value;
        return this;
    }
    
    public LoadByNaturalId entityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
        return this;
    }
    
}
