/**
 * 
 */
package com.tvd12.ezyfox.db.testing;

import org.hibernate.Session;
import org.testng.annotations.Test;

import com.tvd12.ezyfox.db.Query;

/**
 * @author tavandung12
 *
 */
public class QueryExecutorTest extends BaseDbTest {
    
    @Test
    @Override
    public void test() {
        execute(new Query() {
            
            @Override
            public <T> T execute(Session session) {
                throw new IllegalStateException();
            }
        });
    }
    
}
