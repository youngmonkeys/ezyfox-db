/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.util.List;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this query to fetch all records in a table
 * 
 * @author tavandung12
 *
 */
public class FetchAll implements Query {
    
    private Class<?> entityType;
    
    public FetchAll() {this(null);}
    
    public FetchAll(Class<?> entityType) {
        this.entityType = entityType;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List execute(Session session) {
        return session.createCriteria(entityType).list();
    }
    
    public FetchAll entityType(Class<?> entityType) {
        this.entityType = entityType;
        return this;
    }
}
