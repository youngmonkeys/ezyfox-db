/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import static org.testng.Assert.assertEquals;

import java.util.List;

import com.tvd12.ezyfox.db.query.Delete;
import com.tvd12.ezyfox.db.query.FetchAll;
import com.tvd12.ezyfox.db.query.FetchById;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;

/**
 * @author tavandung12
 *
 */
public class DeleteTest extends BaseDbTest {
    
    @Override
    public void doSomeThing() {
        GameUser user = execute(new FetchById().id(id - 1).entityType(GameUser.class));
        execute(new Delete(user).entityName("GameUser"));
        user = execute(new FetchById().id(id - 2).entityType(GameUser.class));
        execute(new Delete().entity(user));
        List<GameUser> users = execute(new FetchAll(GameUser.class));
        assertEquals(users.size(), 3);
    }
    
}
