/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.io.Serializable;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this command to fetch an record in table by it's id
 * 
 * @author tavandung12
 *
 */
public class FetchById implements Query {

    private Serializable id;
    private Class<?> entityType;
    
    public FetchById() {this(null, null);}
    
    public FetchById(Serializable id, Class<?> entityType) {
        this.id = id;
        this.entityType = entityType;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T execute(Session session) {
        return (T)session.get(entityType, id);
    }
    
    public FetchById id(Serializable id) {
        this.id = id;
        return this;
    }
    
    public FetchById entityType(Class<?> entityType) {
        this.entityType = entityType;
        return this;
    }
    
}
