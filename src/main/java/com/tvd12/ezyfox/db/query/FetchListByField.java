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
 * Execute this query to get a list of entities with specific columns (name) and their values
 * 
 * @author tavandung12
 *
 */
public class FetchListByField extends FetchList {

    private String entityName;
    private Map<String, Object> fields
            = new HashMap<>();
    
    public FetchListByField() {this("");}
    
    public FetchListByField(String entityName) {
        this.entityName = entityName;
    }
    
    public FetchListByField(Class<?> entityClass) {
        this(entityClass.getSimpleName());
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List execute(Session session) {
        StringBuilder builder = new StringBuilder("SELECT e FROM ")
                .append(entityName).append(" e WHERE ");
        String and = "";
        for(String fieldName : fields.keySet()) {
            builder.append(and).append("e.")
                .append(fieldName).append(" = ")
                .append(":").append(fieldName);
            and = " AND ";
        }
        
        org.hibernate.Query query = session
                .createQuery(builder.toString())
                .setFirstResult(from).setMaxResults(size);
        for(Entry<String, Object> field : fields.entrySet()) 
            query.setParameter(field.getKey(), field.getValue());
        return query.list();
    }
 
    public FetchListByField entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }
    
    public FetchListByField entityClass(Class<?> entityClass) {
        return entityName(entityClass.getSimpleName());
    }
    
    public FetchListByField field(String name, Object value) {
        fields.put(name, value);
        return this;
    }
}
