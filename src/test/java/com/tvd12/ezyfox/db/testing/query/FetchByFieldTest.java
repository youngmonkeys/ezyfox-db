/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import com.tvd12.ezyfox.db.query.FetchByField;
import com.tvd12.ezyfox.db.query.FetchListByField;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;

import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class FetchByFieldTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        new FetchByField();
        new FetchListByField(GameUser.class).entityClass(GameUser.class);
        GameUser user = execute(new FetchByField(GameUser.class)
                .entityClass(GameUser.class).field("name", "dungtv14#" + id));
        assertNotNull(user);
        
        user = execute(new FetchByField(GameUser.class)
                .entityClass(GameUser.class).field("name", "dungtv14zzz"));
        assertNull(user);
    }
    
}
