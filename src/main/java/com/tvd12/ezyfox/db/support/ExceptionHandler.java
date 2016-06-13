/**
 * 
 */
package com.tvd12.ezyfox.db.support;

import com.tvd12.ezyfox.db.Query;

/**
 * Support to handle the exception when execute a query
 * 
 * @author tavandung12
 *
 */
public interface ExceptionHandler {

    /**
     * Handle the exception
     * 
     * @param e the exception
     * @param query the query
     */
    public void handle(Exception e, Query query);
    
}
