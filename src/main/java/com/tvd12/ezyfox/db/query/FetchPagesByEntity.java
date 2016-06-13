/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.util.List;

import org.hibernate.Session;

/**
 * Fetch list of records in a table mapped to an entity class and sort them to list of pages
 * 
 * @author tavandung12
 *
 */
@SuppressWarnings("unchecked")
public class FetchPagesByEntity extends FetchPages {

    protected Class<?> entityType;
    
    @Override
    protected List<?> getEntities(Session session) {
        return session.createCriteria(entityType)
                .setFirstResult(from)
                .setMaxResults(pageCount * pageSize)
                .list();
    }
    
    public FetchPagesByEntity entityType(Class<?> clazz) {
        this.entityType = clazz;
        return this;
    }
    
    public FetchPagesByEntity from(int from) {
        super.from(from);
        return this;
    }
    public FetchPagesByEntity pageCount(int count) {
        super.pageCount(count);
        return this;
    }
    public FetchPagesByEntity pageSize(int size) {
        super.pageSize(size);
        return this;
    }
    
}
