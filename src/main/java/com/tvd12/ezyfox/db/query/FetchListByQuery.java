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
 * Execute this query to fetch list of records in a table by a query string
 * 
 * @author tavandung12
 *
 */
@SuppressWarnings("unchecked")
public class FetchListByQuery extends FetchList {

    private String queryString;
    private Map<String, Object> params;

    public FetchListByQuery() {
        params = new HashMap<>();
    }
    
    @SuppressWarnings({"rawtypes" })
    public List execute(Session session) {
        return createQuery(session)
                .setFirstResult(from)
                .setMaxResults(size)
                .list();
    }
    
    public FetchListByQuery from(int from) {
        super.from(from);
        return this;
    }

    public FetchListByQuery size(int size) {
        super.size(size);
        return this;
    }
    
    private org.hibernate.Query createQuery(Session session) {
        org.hibernate.Query query = session.createQuery(queryString);
        for(Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query;
    }
    
    public FetchListByQuery query(String query) {
        this.queryString = query;
        return this;
    }
    
    public FetchListByQuery param(String name, Object value) {
        params.put(name, value);
        return this;
    }
}
