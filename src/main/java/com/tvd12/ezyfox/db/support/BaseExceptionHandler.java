/**
 * 
 */
package com.tvd12.ezyfox.db.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tvd12.ezyfox.db.Query;

/**
 * Support to handle the exception and write the exception to the log
 * 
 * @author tavandung12
 *
 */
public class BaseExceptionHandler implements ExceptionHandler {
    
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(ExceptionHandler.class);

    /* (non-Javadoc)
     * @see com.tvd12.ezyfox.db.support.ExceptionHandler#handle(java.lang.Exception)
     */
    @Override
    public void handle(Exception e, Query query) {
        LOGGER.error("Can not execute query " + query, e);
    }
    
}
