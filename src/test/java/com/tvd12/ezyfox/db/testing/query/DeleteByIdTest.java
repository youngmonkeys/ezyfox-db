/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import static org.testng.Assert.assertEquals;

import java.util.List;

import com.tvd12.ezyfox.db.query.DeleteById;
import com.tvd12.ezyfox.db.query.FetchAll;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;

/**
 * @author tavandung12
 *
 */
public class DeleteByIdTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        execute(new DeleteById().id(id - 1).entityClass(GameUser.class));
        execute(new DeleteById().id(id + 10000).entityClass(GameUser.class));
        List<GameUser> users = execute(new FetchAll(GameUser.class));
        assertEquals(users.size(), 4);
    }
    
}
