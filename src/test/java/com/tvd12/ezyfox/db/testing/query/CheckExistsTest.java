/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.tvd12.ezyfox.db.query.CheckExists;
import com.tvd12.ezyfox.db.query.FetchListByField;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;

/**
 * @author tavandung12
 *
 */
public class CheckExistsTest extends BaseDbTest {
    
    @Override
    public void doSomeThing() {
        new CheckExists();
        new FetchListByField(GameUser.class).entityClass(GameUser.class);
        Boolean value = execute(new CheckExists(GameUser.class)
                .entityClass(GameUser.class).field("name", "dungtv14#" + id));
        assertTrue(value);
        
        value = execute(new CheckExists(GameUser.class)
                .entityClass(GameUser.class).field("name", "dungtv14zzz"));
        assertFalse(value);
    }
    
}
