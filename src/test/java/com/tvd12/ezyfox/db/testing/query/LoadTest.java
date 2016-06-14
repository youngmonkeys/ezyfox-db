/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import com.tvd12.ezyfox.db.query.Load;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;

import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class LoadTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        GameUser user = execute(new Load().id(id - 1).entityClass(GameUser.class));
        assertNotNull(user);
        assertEquals(user.getName(), "dungtv14#" + (id));
    }
    
}
