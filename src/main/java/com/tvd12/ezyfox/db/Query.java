/**
 * 
 */
package com.tvd12.ezyfox.db;

import org.hibernate.Session;

/**
 * Implement this interface to create an custom query
 * 
 * @author tavandung12
 *
 */
public interface Query {

    /**
     * Execute your query
     * 
     * @param session the session
     * @return returned value
     */
    public <T> T execute(Session session);
    
}
