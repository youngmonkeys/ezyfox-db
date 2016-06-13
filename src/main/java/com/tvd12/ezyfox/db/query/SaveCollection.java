/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.util.Collection;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;

/**
 * Execute this command to save a collection of objects to a table
 * 
 * @author tavandung12
 *
 */
public class SaveCollection implements Query {
    
    private int batchSize;
    private Collection<?> entities;
    
    public SaveCollection() {
        this(25, null);
    }
    
    public SaveCollection(int batchSize, Collection<?> entities) {
        this.batchSize = batchSize;
        this.entities = entities;
    }

    @SuppressWarnings("unchecked")
    public Collection<?> execute(Session session) {
        int count = 0;
        for(Object entity : entities) {
            session.save(entity);
            if (++count % batchSize != 0) 
                continue;
            session.flush();
            session.clear();
        }
        return entities;
    }
    
    public SaveCollection batchSize(int batchSize) {
        this.batchSize = batchSize;
        return this;
    }
    
    public SaveCollection entities(Collection<?> entities) {
        this.entities = entities;
        return this;
    }
    
}
