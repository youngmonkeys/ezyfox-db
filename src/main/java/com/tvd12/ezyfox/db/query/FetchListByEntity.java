/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.util.List;

import org.hibernate.Session;

/**
 * Execute this query to fetch list of records in a table that mapped to an entity class
 * 
 * @author tavandung12
 *
 */
@SuppressWarnings("unchecked")
public class FetchListByEntity extends FetchList {

    private Class<?> entityType;
    
    @SuppressWarnings({"rawtypes" })
    public List execute(Session session) {
        return session.createCriteria(entityType)
                .setFirstResult(from)
                .setMaxResults(size)
                .list();
    }
    
    public FetchListByEntity from(int from) {
        super.from(from);
        return this;
    }

    public FetchListByEntity size(int size) {
        super.size(size);
        return this;
    }
    
    public FetchListByEntity entityType(Class<?> entityType) {
        this.entityType = entityType;
        return this;
    }
}
