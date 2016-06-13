/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;

/**
 * Fetch list of records in a table by a query and sort them to list of pages
 * 
 * @author tavandung12
 *
 */
@SuppressWarnings("unchecked")
public class FetchPagesByQuery extends FetchPages {

    private String queryString;
    private Map<String, Object> params;
    
    public FetchPagesByQuery() {
        params = new HashMap<>();
    }
    
    /* (non-Javadoc)
     * @see com.tvd12.ezyfox.db.query.Pagination#getEntities(org.hibernate.Session)
     */
    @Override
    protected List<?> getEntities(Session session) {
        return createQuery(session)
            .setFirstResult(from)
            .setMaxResults(pageCount * pageSize)
            .list();
    }
    
    private org.hibernate.Query createQuery(Session session) {
        org.hibernate.Query query = session.createQuery(queryString);
        for(Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query;
    }
    
    public FetchPagesByQuery from(int from) {
        super.from(from);
        return this;
    }
    public FetchPagesByQuery pageCount(int count) {
        super.pageCount(count);
        return this;
    }
    public FetchPagesByQuery pageSize(int size) {
        super.pageSize(size);
        return this;
    }
    
    public FetchPagesByQuery query(String query) {
        this.queryString = query;
        return this;
    }
    
    public FetchPagesByQuery param(String name, Object value) {
        params.put(name, value);
        return this;
    }
}
