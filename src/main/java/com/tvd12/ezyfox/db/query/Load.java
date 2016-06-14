/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.io.Serializable;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * @author tavandung12
 *
 */
public class Load implements Query {

    private Serializable id;
    private Class<?> entityClass;
    
    public Load() {this(null, null);}
    
    public Load(Serializable id, Class<?> entityClass) {
        this.id = id;
        this.entityClass = entityClass;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T execute(Session session) {
        return (T)session.byId(entityClass).load(id);
    }
    
    public Load id(Serializable id) {
        this.id = id;
        return this;
    }
    
    public Load entityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
        return this;
    }
    
}
