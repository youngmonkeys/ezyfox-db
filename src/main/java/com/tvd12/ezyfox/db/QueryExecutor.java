/**
 * 
 */
package com.tvd12.ezyfox.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tvd12.ezyfox.db.support.BaseExceptionHandler;
import com.tvd12.ezyfox.db.support.ExceptionHandler;

/**
 * Support to execute a query in a transaction
 * 
 * @author tavandung12
 *
 */
public class QueryExecutor {
    
    // Handle the exception throwed at custom query runtime 
    protected ExceptionHandler exceptionHandler;
    
    /**
     * Construct with default exception handler
     */
    public QueryExecutor() {
        this(new BaseExceptionHandler());
    }
    
    /**
     * Construct with an exception handler
     * 
     * @param exceptionHandler the exception handler
     */
    public QueryExecutor(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }
    
    /**
     * Execute the query in a transaction
     * 
     * @param context context class to get SessionFactory object
     * @param query the query
     * @return returned value
     */
    public <T> T execute(Class<?> context, Query query) {
        SessionFactory sf = SessionFactoryProvider
                .getInstance().provide(context);
        Session session = sf.openSession();
        session.beginTransaction();
        
        T result = null;
        try {
            result = query.execute(session);
            session.getTransaction().commit();
        }
        catch(Exception e) {
            session.getTransaction().rollback();
            exceptionHandler.handle(e, query);
        }
        session.close();
        return result;
    } 
    
}
